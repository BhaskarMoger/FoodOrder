package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByUserName(String userName);
	Admin findByPassword(String password);
    Admin findById(long id);
}
