package net.java.springboot.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.Exception.ResourceNotFound;
import net.java.springboot.model.User;
import net.java.springboot.repository.UserRepository;

@Service
public class Userservice {

	

	@Autowired
	private UserRepository userRepository;
	
	//delete
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
            throw new ResourceNotFound("User not found : ");
        }
		userRepository.deleteById(id);
		
	}
	
        //post
	    public User addUser(User user) {
	        return userRepository.save(user);
	    }
	    
	    //update
	    public User updateUser(Long id, User userDetails) {
	        Optional<User> optionalUser = userRepository.findById(id);

	        if (optionalUser.isPresent()) {
	            User existingUser = optionalUser.get();
	            existingUser.setFirstName(userDetails.getFirstName());
	            existingUser.setLastname(userDetails.getLastname());
	            existingUser.setUserName(userDetails.getUserName());
	            existingUser.setPassword(userDetails.getPassword());
	            existingUser.setEmailId(userDetails.getEmailId());
	            existingUser.setMobileNo(userDetails.getMobileNo());
	            existingUser.setAddress(userDetails.getAddress());

	            return userRepository.save(existingUser); 
	        } else {
	            throw new RuntimeException("User not found with id: " + id);
	        }
	    }
	    
	    

        public Long Login(String username, String password) {
			
			User user = userRepository.findByUserName(username);
			User user1 = userRepository.findByPassword(password);
			if(user != null && user1 != null)
			 {
			
			        return user.getId();  
			    } else {
			        return null;  
			    }
        }



		

}
