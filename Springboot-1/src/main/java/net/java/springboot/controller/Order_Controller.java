package net.java.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.model.Cart;
import net.java.springboot.model.Order;
import net.java.springboot.DTO.CartDTO;
import net.java.springboot.DTO.OrderRequest;
import net.java.springboot.Service.OrderService;
import net.java.springboot.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3010")
public class Order_Controller {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderService orderService;

	
	@GetMapping("/Order")
	public List<Order> getllOrders()
	{
		return orderRepository.findAll();
	}
	
	
	@PostMapping("/Order/add")
    public ResponseEntity<Order> addOrder(@RequestBody OrderRequest orderRequest) {
        Order addOrders = orderService.addOrder(orderRequest);
		return new ResponseEntity<>(addOrders, HttpStatus.CREATED);
    }
	
	 @GetMapping("Order/User/{userId}")
    public ResponseEntity<List<Order>> FindByUserId(@PathVariable Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return ResponseEntity.ok(orders);
    } 
	 
	/* @GetMapping("Order/User/{userId}")
	    public List<Order> Getorders(@PathVariable Long userId) {
	        // Fetch all cart items for the specified user
	        List<Order> orders = orderRepository.findByUserId(userId);

	        if (orders.isEmpty()) {
	            throw new RuntimeException("No items found in the cart for this user");
	        }

	        // Convert Cart entities to CartDTO for clean representation
	        List<OrderRequest> orderRequest = orders.stream().map(order -> {
	        	OrderRequest dto = new OrderRequest();
	            dto.setUserId(order.getId())
	            dto.setFirstName(order.)
	            dto.setImageUrl(cart.getImageUrl());
	            dto.setDescription(cart.getDescription());
	            dto.setPrice(cart.getPrice());
	            
	            return dto;
	        }).collect(Collectors.toList());

	        // Wrap the list of CartDTOs into a response map
	        Map<String, Object> response = new HashMap<>();
	        response.put("cartItems", cartDTOs);

	        return  response;  // Return the map containing the cart items
	    }  */

}
