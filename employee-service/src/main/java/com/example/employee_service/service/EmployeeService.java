package com.example.employee_service.service;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.model.Employee;
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

    public void create(EmployeeDTO employeeDTO) {
        Employee employee = mapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
    }

    public void update(EmployeeDTO employeeDTO, Long id) {
        
    }

    public EmployeeDTO getOne(Long id) {
    }

    public void delete(Long id) {
    }
}
