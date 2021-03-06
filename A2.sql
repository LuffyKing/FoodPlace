drop database food_place;
create database food_place;
use food_place;
DROP USER 'username'@'localhost';
CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON food_place.* TO 'username'@'localhost';
CREATE TABLE `Customers` (
  `c_id` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `C_Username` varchar(255) unique,
  `created_at` timestamp DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255),
  `password` varchar(255)
);

CREATE TABLE `Staff` (
  `s_id` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `hours_worked` int,
  `hours_2bworked` int,
  `S_Username` varchar(255) unique,
  `Password` varchar(255),
  `type` varchar(255),
  `created_at` timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE `bookings` (
  `b_id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int,
  `waiter_id` int,
  `booking_time` timestamp,
  `noOfGuests` int,
  `approved`  boolean,
  `booking_length` int
);


CREATE TABLE `notifications` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `message` text,
    `customer_id` int
);

CREATE TABLE `tables` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `seats` int,
  `status` varchar(255)
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `customer_id` int,
  `status` boolean,
  `created_at` timestamp DEFAULT CURRENT_TIMESTAMP,
  `ord_type` varchar(255),
  `waiter_id` int,
  `driver_id` int,
  `est_delivery_time` timestamp,
  `delivery_status` varchar(255),
  `delivery_address` varchar(255),
  `is_delivery_approved` boolean,
  `pickup_time` timestamp,
  `collection_status` boolean
);

CREATE TABLE `order_items` (
    `id` int PRIMARY KEY AUTO_INCREMENT,
    `quantity` int,
    `order_id` int,
    `menu_item_id` int
);

CREATE TABLE `Menu` (
  `m_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `isSpecial`  boolean,
  `category` varchar(255),
  `description` text,
  `unitPrice` double

);

ALTER TABLE `bookings` ADD FOREIGN KEY (`customer_id`) REFERENCES `customers` (`c_id`);

ALTER TABLE `bookings` ADD FOREIGN KEY (`waiter_id`) REFERENCES `staff` (`s_id`);

ALTER TABLE `order_items` ADD FOREIGN KEY (`menu_item_id`) REFERENCES `menu` (`m_id`);

ALTER TABLE `orders` ADD FOREIGN KEY (`customer_id`) REFERENCES `customers` (`c_id`);


ALTER TABLE `notifications` ADD FOREIGN KEY (`customer_id`) REFERENCES `customers`(`c_id`);
