package com.clarivate.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.User;

@Repository
public interface userRepository extends JpaRepository<User, Integer>{

}
