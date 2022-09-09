package com.dhruv.departmentservice.service;

import com.dhruv.departmentservice.model.Department;

public interface DepartmentService {
  
  public Department saveDepartment(Department department);

  public Department findDepartmentById(Long departmentId);
}
