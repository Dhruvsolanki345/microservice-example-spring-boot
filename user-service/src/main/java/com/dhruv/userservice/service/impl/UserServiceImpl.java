package com.dhruv.userservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhruv.userservice.VO.UserNDepartment;
import com.dhruv.userservice.exception.ResourceNotFoundException;
import com.dhruv.userservice.model.User;
import com.dhruv.userservice.repository.UserRepository;
import com.dhruv.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User saveUser(User user) {
    log.info("Inside saveUser method of UserService");

    return userRepository.save(user);
  }

  @Override
  public UserNDepartment getUserWithDepartment(Long userId) {
    log.info("Inside getUserWithDepartment method in UserService");

    UserNDepartment userNDepartment = new UserNDepartment();
    Optional optional = userRepository.findById(userId); 

    if(optional.isEmpty()) throw new ResourceNotFoundException("User", "userId", userId);
    
    User user = (User) optional.get();
    
  }

}
