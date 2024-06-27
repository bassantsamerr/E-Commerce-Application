-- Create the database if it does not exist
CREATE DATABASE IF NOT EXISTS `wallet_service`;

-- Use the created database
USE `wallet_service`;

-- Drop the tables if they exist
DROP TABLE IF EXISTS `transactions`;
DROP TABLE IF EXISTS `wallet_provider`;
DROP TABLE IF EXISTS `wallet`;
DROP TABLE IF EXISTS `user`;

-- Create the user table
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(255) NOT NULL,
    national_id VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the wallet_provider table
CREATE TABLE wallet_provider (
  id INT NOT NULL AUTO_INCREMENT,
  mobile_number VARCHAR(45) DEFAULT NULL,
  national_id VARCHAR(45) DEFAULT NULL,
  balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the wallet table
CREATE TABLE wallet (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  wallet_id INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
  FOREIGN KEY (`wallet_id`) REFERENCES `wallet_provider`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- Create the transactions table
CREATE TABLE transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  wallet_id INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  transactionType ENUM('DEPOSIT', 'WITHDRAWAL') NOT NULL,
  FOREIGN KEY (`wallet_id`) REFERENCES `wallet`(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `roles` (
  `user_id` INT NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
