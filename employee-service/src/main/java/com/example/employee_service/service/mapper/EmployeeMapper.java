package com.example.employee_service.service.mapper;

import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(employee.getDepartment())
                .build();
    }
}
