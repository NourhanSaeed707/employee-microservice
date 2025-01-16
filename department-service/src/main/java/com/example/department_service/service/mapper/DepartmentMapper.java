package com.example.department_service.service.mapper;
import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.model.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {

    public DepartmentDTO toDepartmentDTO(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .location(department.getLocation())
                .build();
    }

    public Department toDepartment(DepartmentDTO departmentDTO) {
        return Department.builder()
                .name(departmentDTO.getName())
                .location(departmentDTO.getLocation())
                .build();
    }
}
