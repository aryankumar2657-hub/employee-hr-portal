package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.DtoEmployee;
import com.example.EmployeeManagementSystem.exception.ExceptionEmployee;
import com.example.EmployeeManagementSystem.mapper.MapperEmployee;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEmployee implements ServiceEmployeeIn{
    @Autowired
    private RepositoryEmployee repositoryEmployee;

    @Override
    public DtoEmployee createEmployee(DtoEmployee dtoEmployee) {
        Employee employee = MapperEmployee.mapTOEmployee(dtoEmployee);
        Employee savedEmployee = repositoryEmployee.save(employee);
        return MapperEmployee.mapToDtoEmployee(savedEmployee);
    }

    @Override
    public DtoEmployee findById(int id) {
        Employee employee = repositoryEmployee.findById(id).orElseThrow(
                () -> new ExceptionEmployee("Employee not found with id: " + id));
        return MapperEmployee.mapToDtoEmployee(employee);
    }

    @Override
    public List<DtoEmployee> findAllEmployee() {
        return repositoryEmployee.findAll()
                .stream()
                .map(MapperEmployee::mapToDtoEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public DtoEmployee updateEmployee(int id, DtoEmployee updatedemployee) {
        Employee employee = repositoryEmployee.findById(id).orElseThrow(
                () -> new ExceptionEmployee("Employee not found with id: " + id));
        employee.setFirstname(updatedemployee.getFirstname());
        employee.setLastname(updatedemployee.getLastname());
        employee.setEmail(updatedemployee.getEmail());
        employee.setDepartment(updatedemployee.getDepartment());
        employee.setDesignation(updatedemployee.getDesignation());
        employee.setSalary(updatedemployee.getSalary());
        employee.setJoiningDate(updatedemployee.getJoiningDate());
        employee.setPhone(updatedemployee.getPhone());
        return MapperEmployee.mapToDtoEmployee(repositoryEmployee.save(employee));
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = repositoryEmployee.findById(id).orElseThrow(
                () -> new ExceptionEmployee("Employee not found with id: " + id));
        repositoryEmployee.delete(employee);
    }

    @Override
    public List<DtoEmployee> searchEmployees(String keyword) {
        return repositoryEmployee
                .findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(keyword, keyword, keyword)
                .stream()
                .map(MapperEmployee::mapToDtoEmployee)
                .collect(Collectors.toList());
    }
}
