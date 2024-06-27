-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS `shop_service`;

-- Use the created database
USE `shop_service`;

-- Drop the tables if they exist
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `shopping_cart_item`;
DROP TABLE IF EXISTS `shopping_cart`;
DROP TABLE IF EXISTS `order_item`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `payment`;

-- Create the product table
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the shopping_cart table
CREATE TABLE shopping_cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `wallet_service`.`user`(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the shopping_cart_item table
CREATE TABLE shopping_cart_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cart_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES shopping_cart(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the order table
CREATE TABLE `order` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    status ENUM('PENDING', 'COMPLETED', 'CANCELLED') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES `wallet_service`.`user`(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the order_item table
CREATE TABLE order_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `order`(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the payment table
CREATE TABLE payment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    status ENUM('PENDING', 'COMPLETED', 'FAILED') NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `order`(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
