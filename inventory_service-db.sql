-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS `inventory_service`;

-- Use the created database
USE `inventory_service`;

-- Drop the tables if they exist
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `inventory`;

-- Create the product table
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the inventory table
CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
