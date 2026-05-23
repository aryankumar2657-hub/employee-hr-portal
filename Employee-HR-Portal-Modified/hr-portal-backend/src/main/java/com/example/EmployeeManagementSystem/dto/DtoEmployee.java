package com.example.EmployeeManagementSystem.dto;

public class DtoEmployee {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String department;
    private String designation;
    private double salary;
    private String joiningDate;
    private String phone;

    public DtoEmployee() {}

    public DtoEmployee(int id, String firstname, String lastname, String email, String department, String designation, double salary, String joiningDate, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.phone = phone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getJoiningDate() { return joiningDate; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
