package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEmployee extends JpaRepository<Employee,Integer> {
    List<Employee> findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCaseOrDepartmentContainingIgnoreCase(String firstname, String lastname, String department);
}
