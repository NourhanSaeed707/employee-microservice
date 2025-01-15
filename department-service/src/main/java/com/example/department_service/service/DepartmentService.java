package com.example.department_service.service;
import com.example.department_service.model.Department;
import com.example.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
