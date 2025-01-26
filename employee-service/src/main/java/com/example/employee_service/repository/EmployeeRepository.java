package com.example.employee_service.repository;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeDTO> findByDepartmentId(Long departmentId);
}
