package com.dhruv.userservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dhruv.userservice.VO.Department;
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

  @Autowired
  public RestTemplate restTemplate;

  @Override
  public User saveUser(User user) {
    log.info("Inside saveUser method of UserService");

    return userRepository.save(user);
  }

  @Override
  public UserNDepartment getUserWithDepartment(Long userId) {
    log.info("Inside getUserWithDepartment method in UserService");

    UserNDepartment userNDepartment = new UserNDepartment();
    Optional<User> optional = userRepository.findById(userId);

    if (optional.isEmpty())
      throw new ResourceNotFoundException("User", "userId", userId);

    User user = optional.get();

    try {
      Department department = restTemplate.getForObject(
          "http://localhost:9001/api/departments/" + user.getDepartmentId(),
          Department.class);

      userNDepartment.setDepartment(department);
    } catch (Exception e) {
      throw new ResourceNotFoundException(
          String.format("Department not found for user with userId: '%s'", user.getUserId()));
    }

    userNDepartment.setUser(user);

    return userNDepartment;
  }

}
