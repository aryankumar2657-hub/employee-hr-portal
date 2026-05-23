CREATE DATABASE IF NOT EXISTS hr_portal_db;
USE hr_portal_db;

CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    department VARCHAR(80),
    designation VARCHAR(100),
    salary DOUBLE,
    joining_date VARCHAR(30),
    phone VARCHAR(20)
);

INSERT INTO employees (first_name, last_name, email, department, designation, salary, joining_date, phone) VALUES
('Aryan', 'Kumar', 'aryan.kumar@example.com', 'Engineering', 'Java Full Stack Intern', 25000, '2026-01-10', '9876543210'),
('Priya', 'Singh', 'priya.singh@example.com', 'HR', 'HR Executive', 32000, '2025-08-15', '9123456780'),
('Rahul', 'Sharma', 'rahul.sharma@example.com', 'IT', 'Backend Developer', 45000, '2025-05-20', '9988776655');
