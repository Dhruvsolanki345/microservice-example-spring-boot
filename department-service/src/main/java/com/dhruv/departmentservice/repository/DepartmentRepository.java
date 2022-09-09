package com.dhruv.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruv.departmentservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

  // Department findByDepartmentId(Long departmentId);
  // Department findByDepartmentName(String string);

  
}
