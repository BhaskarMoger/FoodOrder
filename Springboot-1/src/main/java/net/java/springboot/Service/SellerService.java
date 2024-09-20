package net.java.springboot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.Exception.ResourceNotFound;
import net.java.springboot.model.Seller;
import net.java.springboot.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired
	private SellerRepository sellerRepository;
	
	//delete
	public void deleteSeller(Long id) {
		if (!sellerRepository.existsById(id)) {
            throw new ResourceNotFound("Seller not found : ");
        }
		sellerRepository.deleteById(id);
		
	}
	
        //post
	    public Seller addSeller(Seller seller) {
	        return sellerRepository.save(seller);
	    }
	    
	    //update
	    public Seller updateUser(Long id, Seller seller) {
	        Optional<Seller> optionalUser = sellerRepository.findById(id);

	        if (optionalUser.isPresent()) {
	            Seller existingUser = optionalUser.get();
	            existingUser.setFirstName(seller.getFirstName());
	            existingUser.setLastname(seller.getLastname());
	            existingUser.setUserName(seller.getUserName());
	            existingUser.setPassword(seller.getPassword());
	            existingUser.setEmailId(seller.getEmailId());
	            existingUser.setMobileNo(seller.getMobileNo());
	            existingUser.setAddress(seller.getAddress());

	            return sellerRepository.save(existingUser); // Save the updated user
	        } else {
	            throw new RuntimeException("Seller not found with id: " + id);
	        }
	    }

		public Object Login(String username, String password) {
			
			Seller user = sellerRepository.findByUserName(username);
			Seller user1 = sellerRepository.findByPassword(password);
			if(user != null && user1 != null)
			 {
			
			        return user.getId();  
			    } else {
			        return null;  
			    }
       }

}
