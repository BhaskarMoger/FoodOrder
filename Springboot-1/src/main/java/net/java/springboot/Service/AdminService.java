package net.java.springboot.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.springboot.Exception.ResourceNotFound;
import net.java.springboot.model.Admin;
import net.java.springboot.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	//delete
	public void deleteAdmin(Long id) {
		if (!adminRepository.existsById(id)) {
            throw new ResourceNotFound("Admin not found : ");
        }
		adminRepository.deleteById(id);
		
	}
	
        //post
	    public Admin addAdmin(Admin admin) {
	        return adminRepository.save(admin);
	    }
	    
	    //update
	    public Admin updateUser(Long id, Admin userDetails) {
	        Optional<Admin> optionalUser = adminRepository.findById(id);

	        if (optionalUser.isPresent()) {
	            Admin existingUser = optionalUser.get();
	            existingUser.setFirstName(userDetails.getFirstName());
	            existingUser.setLastname(userDetails.getLastname());
	            existingUser.setUserName(userDetails.getUserName());
	            existingUser.setPassword(userDetails.getPassword());
	            existingUser.setEmailId(userDetails.getEmailId());
	            existingUser.setMobileNo(userDetails.getMobileNo());
	            existingUser.setAddress(userDetails.getAddress());

	            return adminRepository.save(existingUser); // Save the updated user
	        } else {
	            throw new RuntimeException("Admin not found with id: " + id);
	        }
	    }
	       
	       
           public Long Login(String username, String password) {
			
			Admin user = adminRepository.findByUserName(username);
			Admin user1 = adminRepository.findByPassword(password);
			if(user != null && user1 != null)
			{	
				  return user.getId();  
		    } else {
		        return null;  
		    }
        }

}
