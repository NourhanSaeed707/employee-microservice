package com.example.employee_service.client;
import com.example.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service", url = "${application.config.department-url}")
public interface DepartmentClient {
    @GetMapping("/{id}")
    DepartmentDTO getOne(@PathVariable("id") Long id);
}
