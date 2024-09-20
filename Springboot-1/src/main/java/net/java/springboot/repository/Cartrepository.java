package net.java.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Cart;

@Repository
public interface Cartrepository extends JpaRepository<Cart, Long>{
	
	List<Cart>  findByUserId(Long userId);

}
