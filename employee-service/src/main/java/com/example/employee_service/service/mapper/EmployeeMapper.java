package com.example.employee_service.service.mapper;

import com.example.employee_service.client.DepartmentClient;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeMapper {
    private final DepartmentClient departmentClient;

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        var depart = departmentClient.getOne(employee.getDepartmentId());
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .mobile(employee.getMobile())
                .address(employee.getAddress())
                .department(depart)
                .build();
    }
}
