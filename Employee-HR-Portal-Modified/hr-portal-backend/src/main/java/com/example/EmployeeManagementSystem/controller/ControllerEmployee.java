package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.DtoEmployee;
import com.example.EmployeeManagementSystem.service.ServiceEmployeeIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequestMapping("/api/employees")
public class ControllerEmployee {
    private final ServiceEmployeeIn serviceEmployee;

    public ControllerEmployee(ServiceEmployeeIn serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @PostMapping
    public ResponseEntity<DtoEmployee> createEmployee(@RequestBody DtoEmployee dtoEmployee){
        return new ResponseEntity<>(serviceEmployee.createEmployee(dtoEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoEmployee> findById(@PathVariable int id){
        return new ResponseEntity<>(serviceEmployee.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DtoEmployee>> findAllEmployee(){
        return new ResponseEntity<>(serviceEmployee.findAllEmployee(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoEmployee> updateEmployee(@PathVariable int id, @RequestBody DtoEmployee updatedemployee){
        return new ResponseEntity<>(serviceEmployee.updateEmployee(id, updatedemployee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        serviceEmployee.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<DtoEmployee>> searchEmployees(@RequestParam String keyword){
        return new ResponseEntity<>(serviceEmployee.searchEmployees(keyword), HttpStatus.OK);
    }
}
