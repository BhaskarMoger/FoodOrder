package net.java.springboot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.Exception.ResourceNotFound;
import net.java.springboot.model.Item;
import net.java.springboot.repository.ItemRepository;

@Service
public class Itemservice {
	@Autowired
	private ItemRepository itemRepository;
	
	//delete
	public void deleteItem(Long id) {
		if (!itemRepository.existsById(id)) {
            throw new ResourceNotFound("Item not found : ");
        }
		itemRepository.deleteById(id);
		
	}
	
        //post
	    public Item addItem(Item item) {
	        return itemRepository.save(item);
	    }
	    
	    //update
	    public Item updateUser(Long id, Item item) {
	        Optional<Item> optionalUser = itemRepository.findById(id);

	        if (optionalUser.isPresent()) {
	            Item existingItem = optionalUser.get();
	            existingItem.setName(item.getName());
	            existingItem.setDescription(item.getDescription());
	            existingItem.setPrice(item.getPrice());
	            existingItem.setImageUrl(item.getImageUrl());
	            

	            return itemRepository.save(existingItem); // Save the updated user
	        } else {
	            throw new RuntimeException("Item not found with id: " + id);
	        }
	    }

}
