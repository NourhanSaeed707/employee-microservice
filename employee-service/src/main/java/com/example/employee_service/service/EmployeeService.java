package com.example.employee_service.service;
import com.example.employee_service.client.DepartmentClient;
import com.example.employee_service.dto.EmployeeDTO;
import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import com.example.employee_service.service.mapper.EmployeeMapper;
import jakarta.persistence.EntityNotFoundException;
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
        Employee employeeFound = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));
        employeeFound.setAddress(employeeDTO.getAddress());
        employeeFound.setFirstName(employeeDTO.getFirstName());
        employeeFound.setLastName(employeeDTO.getLastName());
        employeeFound.setEmail(employeeDTO.getEmail());
        employeeFound.setMobile(employeeDTO.getMobile());
        employeeFound.setDepartmentId(employeeDTO.getDepartment().getId());
        employeeRepository.save(employeeFound);
    }

    public EmployeeDTO getOne(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee not found with id " + id));
        return mapper.toEmployeeDTO(employee);
    }

    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));
        if(employee != null) {
            employeeRepository.deleteById(id);
        }
    }

    public List<EmployeeDTO> getEmployeesByDepartmentId(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
