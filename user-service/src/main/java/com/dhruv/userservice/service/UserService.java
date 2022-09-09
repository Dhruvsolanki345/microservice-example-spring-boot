package com.dhruv.userservice.service;

import com.dhruv.userservice.VO.UserNDepartment;
import com.dhruv.userservice.model.User;

public interface UserService {

  public User saveUser(User user);

  public UserNDepartment getUserWithDepartment(Long userId);
  
}
