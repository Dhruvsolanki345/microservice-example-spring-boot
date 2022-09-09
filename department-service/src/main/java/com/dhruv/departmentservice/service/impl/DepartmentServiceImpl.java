package com.dhruv.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhruv.departmentservice.exception.ResourceNotFoundException;
import com.dhruv.departmentservice.model.Department;
import com.dhruv.departmentservice.repository.DepartmentRepository;
import com.dhruv.departmentservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public Department saveDepartment(Department department) {
    log.info("Inside saveDepartment method of DepartmentService");

    return departmentRepository.save(department);
  }

  @Override
  public Department findDepartmentById(Long departmentId) {
    log.info("Inside findDepartmentById method of DepartmentService");

    // We can create our own methods based on signature(column name). Using this Jpa will
    // automatically create its logic based on the signature(column name)
    // return departmentRepository.findByDepartmentId(departmentId);
    // return departmentRepository.findByDepartmentName("IT-3");

    return departmentRepository.findById(departmentId)
        .orElseThrow(() -> new ResourceNotFoundException("Department", "departmentId", departmentId));
  }

}
