create database dxc;
use dxc;

CREATE TABLE roles (
    role_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE
);

CREATE TABLE user_roles (
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE employee (
    employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(100),
    designation VARCHAR(100)
);

CREATE TABLE payroll (
    payroll_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    salary DOUBLE,
    bonus DOUBLE,
    employee_id BIGINT UNIQUE,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);
