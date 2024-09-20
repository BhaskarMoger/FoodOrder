package net.java.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	

}
