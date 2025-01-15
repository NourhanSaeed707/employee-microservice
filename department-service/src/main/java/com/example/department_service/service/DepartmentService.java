package com.example.department_service.service;
import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.model.Department;
import com.example.department_service.repository.DepartmentRepository;
import com.example.department_service.service.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper mapper;

    public List<DepartmentDTO> findAll() {
        var departments = departmentRepository.findAll();
        return departments.stream().map(mapper::toDepartmentDTO).toList();
    }
}
