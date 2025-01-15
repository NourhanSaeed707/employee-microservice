package com.example.employee_service.service;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;

    public List<EmployeeDTO> findAll() {
        var employees = employeeRepository.findAll();
        return employees.stream().map(mapper::toEmployeeDTO).toList();
    }
}
