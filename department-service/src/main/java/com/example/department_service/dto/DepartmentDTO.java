package com.example.department_service.dto;
import com.example.department_service.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {
    private Long id;
    private String name;
    private List<Employee> employees;
}
