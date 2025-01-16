package com.example.department_service.controller;
import com.example.department_service.dto.DepartmentDTO;
import com.example.department_service.service.DepartmentService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<DepartmentDTO> findAll() {
        return departmentService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.create(departmentDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO getOne(@PathVariable("id") Long id) {
        return departmentService.getOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDTO update(@PathVariable("id") Long id, @RequestBody DepartmentDTO departmentDTO) {
        return departmentService.update(id, departmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        departmentService.delete(id);
    }
}
