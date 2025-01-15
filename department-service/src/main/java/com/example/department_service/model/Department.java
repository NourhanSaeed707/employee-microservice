package com.example.department_service.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employee")
    private List<Employee> employees;
}
