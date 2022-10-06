package com.clarivate.foodapp.repository;





import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);

	public Optional<User> findByName(String username); 

}
