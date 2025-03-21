create database HR_MANAGEMENT;
use HR_MANAGEMENT;

CREATE TABLE Departments (
                             department_id INT PRIMARY KEY AUTO_INCREMENT,
                             department_name VARCHAR(50) NOT NULL UNIQUE,
                             department_status BIT DEFAULT 1
);

CREATE TABLE Employee (
                          employee_id INT PRIMARY KEY AUTO_INCREMENT,
                          employee_name VARCHAR(50) NOT NULL UNIQUE,
                          position VARCHAR(50) NOT NULL,
                          salary DOUBLE NOT NULL CHECK (salary > 0),
                          hire_date DATE NOT NULL,
                          department_id INT NOT NULL,
                          FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);