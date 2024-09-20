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

import net.java.springboot.Service.AdminService;
import net.java.springboot.model.Admin;
import net.java.springboot.model.Login;
import net.java.springboot.repository.AdminRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3010")
public class Admin_Controller {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/Admin")
	public List<Admin> getllAdmins()
	{
		return adminRepository.findAll();
	}
	
	@DeleteMapping("/Admin/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
		 adminService.deleteAdmin(id);
		 return ResponseEntity.ok("Admin deleted successfully");
        
    }
	
	@PostMapping("/Admin/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin addAdmin = adminService.addAdmin(admin);
		return new ResponseEntity<>(addAdmin, HttpStatus.CREATED);
    }
	@GetMapping("/Admin/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin user = adminRepository.findById(id).orElseThrow(null);
        return ResponseEntity.ok(user);
    }
	
	@PutMapping("/Admin/update/{id}")
    public ResponseEntity<Admin> updateUser(@PathVariable Long id, @RequestBody Admin userDetails) {
        Admin updatedUser = adminService.updateUser(id, userDetails);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
	
	@PostMapping("/Admin/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
Long userId = adminService.Login(login.getUserName(),login.getPassword());
        
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
