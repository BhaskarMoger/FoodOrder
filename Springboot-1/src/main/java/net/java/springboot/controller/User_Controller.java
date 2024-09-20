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

import net.java.springboot.Service.Userservice;
import net.java.springboot.model.Login;
import net.java.springboot.model.User;
import net.java.springboot.repository.UserRepository;



@RestController
@CrossOrigin(origins = "http://localhost:3010")
@RequestMapping("/api/v1/")
public class User_Controller {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Userservice userservice;
	
	@GetMapping("/User")
	public List <User> getAllUser() {
	    return userRepository.findAll();
	}
	
	@DeleteMapping("/User/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
		 userservice.deleteUser(id);
		 return ResponseEntity.ok("User deleted successfully");
        
    }
	
	@PostMapping("/User/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User addUser = userservice.addUser(user);
		return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }
	
	@GetMapping("/User/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(null);
        return ResponseEntity.ok(user);
    }
	
	@PutMapping("/User/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userservice.updateUser(id, userDetails);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
	
	@PostMapping("/User/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        Long userId = userservice.Login(login.getUserName(),login.getPassword());
        
        if (userId != null) {
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
