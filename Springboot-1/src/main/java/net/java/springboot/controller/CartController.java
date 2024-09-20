package net.java.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.DTO.CartDTO;
import net.java.springboot.model.Cart;
import net.java.springboot.model.Item;
import net.java.springboot.model.User;
import net.java.springboot.repository.Cartrepository;
import net.java.springboot.repository.ItemRepository;
import net.java.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/Cart")
@CrossOrigin(origins = "http://localhost:3010")
public class CartController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private Cartrepository cartrepository;
	

    // Add to Cart
    @PostMapping("/add")
    public Cart addToCart(@RequestBody CartRequest cartRequest) {
        User user = userRepository.findById(cartRequest.getUserId()).orElseThrow();
        Item item = itemRepository.findById(cartRequest.getFoodItemId()).orElseThrow();

        Cart cart = new Cart();
        cart.setUserId(cartRequest.getUserId());
        cart.setItemId(cartRequest.getFoodItemId());
        cart.setQuantity(cartRequest.getQuantity());
        cart.setItemName(item.getName());
        cart.setDescription(item.getDescription());
        cart.setImageUrl(item.getImageUrl());
        cart.setPrice((double) item.getPrice());

        return cartrepository.save(cart);
    }
    
   // @GetMapping("/Cart")
	//public List<Cart> getAllItems(){
	//	return cartrepository.findAll();
	//}

   // Get Cart Items by User ID
    @GetMapping("/User/{userId}")
    public Map<String, Object> getCartItems(@PathVariable Long userId) {
        // Fetch all cart items for the specified user
        List<Cart> cartItems = cartrepository.findByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("No items found in the cart for this user");
        }

        // Convert Cart entities to CartDTO for clean representation
        List<CartDTO> cartDTOs = cartItems.stream().map(cart -> {
            CartDTO dto = new CartDTO();
            dto.setId(cart.getId());
            dto.setImageName(cart.getItemName());
            dto.setImageUrl(cart.getImageUrl());
            dto.setDescription(cart.getDescription());
            dto.setPrice(cart.getPrice());
            
            return dto;
        }).collect(Collectors.toList());

        // Wrap the list of CartDTOs into a response map
        Map<String, Object> response = new HashMap<>();
        response.put("cartItems", cartDTOs);

        return  response;  // Return the map containing the cart items
    } 
    

    // Remove from Cart
    @DeleteMapping("/remove/{cartId}")
    public void removeCartItem(@PathVariable Long cartId) {
        cartrepository.deleteById(cartId);
    }

    // DTO for Add to Cart Request
    public static class CartRequest {
        private Long userId;
        private Long foodItemId;
        private int quantity;
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getFoodItemId() {
			return foodItemId;
		}
		public void setFoodItemId(Long foodItemId) {
			this.foodItemId = foodItemId;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

        // Getters and Setters
    }

	

}
