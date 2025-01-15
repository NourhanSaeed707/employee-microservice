package com.example.department_service.controller;
import com.example.department_service.model.Department;
import com.example.department_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> findAll() {
        return departmentService.findAll();
    }
}
