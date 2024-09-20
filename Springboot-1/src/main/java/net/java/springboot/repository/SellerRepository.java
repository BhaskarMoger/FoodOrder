package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

	Seller findByUserName(String userName);
	Seller findByPassword(String password);
	Seller findById(long id);
}
