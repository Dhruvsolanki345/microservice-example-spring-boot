package com.dhruv.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruv.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
