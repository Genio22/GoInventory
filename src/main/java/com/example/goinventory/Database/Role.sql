-- Create database and use it
CREATE DATABASE IF NOT EXISTS goinventory;
USE goinventory;

-- Create employees table
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20),
    email VARCHAR(100),
    location VARCHAR(100),
    working_status ENUM('Active', 'Inactive', 'On Leave') DEFAULT 'Active',
    salary DECIMAL(10, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert sample data
INSERT INTO employees (name, mobile_number, email, location, working_status, salary) VALUES
('Ahnaf', '1234567890', 'john@example.com', 'New York', 'Active', 55000),
('Jane Smith', '0987654321', 'jane@example.com', 'Los Angeles', 'On Leave', 62000);
