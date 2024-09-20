package net.java.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.Service.SellerService;
import net.java.springboot.model.Login;
import net.java.springboot.model.Seller;
import net.java.springboot.repository.SellerRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3010")
public class Seller_Controller {
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/Seller")
	public List<Seller> getAllSellers(){
		return sellerRepository.findAll();
	}
	
	@DeleteMapping("/Seller/{id}")
    public ResponseEntity<String> deleteSeller(@PathVariable Long id) {
		 sellerService.deleteSeller(id);
		 return ResponseEntity.ok("Seller deleted successfully");
        
    }
	
	@PostMapping("/Seller/add")
    public ResponseEntity<Seller> addSeller(@RequestBody Seller seller) {
        Seller addSeller = sellerService.addSeller(seller);
		return new ResponseEntity<>(addSeller, HttpStatus.CREATED);
    }
	
	@GetMapping("/Seller/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        Seller user = sellerRepository.findById(id).orElseThrow(null);
        return ResponseEntity.ok(user);
    }
	
	@PutMapping("/Seller/update/{id}")
    public ResponseEntity<Seller> updateUser(@PathVariable Long id, @RequestBody Seller userDetails) {
        Seller updatedUser = sellerService.updateUser(id, userDetails);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
	
	@PostMapping("/Seller/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
      Object userId = sellerService.Login(login.getUserName(),login.getPassword());
        
        if (userId != null) {
        // Prepare a response with both the userId and a success message
		Map<String, Object> response = new HashMap<>();
		response.put("userId", userId);
		response.put("message", "Login successful");
		
		return ResponseEntity.status(200).body(response);
        }
        else {
        	return ResponseEntity.status(401).body("Invalid credentials");
		}
    }

}
