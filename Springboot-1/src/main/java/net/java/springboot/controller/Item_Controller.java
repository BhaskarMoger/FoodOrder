package net.java.springboot.controller;

import java.util.List;

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

import net.java.springboot.Service.Itemservice;
import net.java.springboot.model.Item;
import net.java.springboot.repository.ItemRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3010")
public class Item_Controller {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private Itemservice itemservice;
	
	@GetMapping("/Item")
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	@DeleteMapping("/Item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
		 itemservice.deleteItem(id);
		 return ResponseEntity.ok("Item deleted successfully");
        
    }
	
	@PostMapping("/Item/add")
    public ResponseEntity<Item> addSeller(@RequestBody Item item) {
        Item addItem = itemservice.addItem(item);
		return new ResponseEntity<>(addItem, HttpStatus.CREATED);
   }
	
	@PutMapping("/Item/update/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Item updatedItem = itemservice.updateUser(id, itemDetails);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

}
