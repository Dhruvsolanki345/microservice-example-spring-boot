// VO full form is Value Object
package com.dhruv.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Simple POJO Class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

  private Long departmentId;

  private String departmentName;
  private String departmentAddress;
  private String departmentCode;
}
