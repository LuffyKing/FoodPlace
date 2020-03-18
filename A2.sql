CREATE TABLE `Customers` (
  `C_id` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255),
  `created_at` timestamp,
  `Address` varchar(255),
  `Password` varchar(255)
);

CREATE TABLE `Staff` (
  `S_id` int PRIMARY KEY AUTO_INCREMENT,
  `hours_worked` int,
  `hours_2bworked` int,
  `Passwprd` varchar(255),
  `type` varchar(255),
  `created_at` timestamp
);

CREATE TABLE `bookings` (
  `b_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `type` varchar(255),
  `Customers_id` varchar(255),
  `table_schedule_id` int,
  `staff_schedule_id` int
);

CREATE TABLE `table_schedule` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `tables_id` int,
  `start_time` datetime,
  `end_time` datetime
);

CREATE TABLE `tables` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `seats` int,
  `status` varchar(255)
);

CREATE TABLE `orders` (
  `id` int PRIMARY KEY,
  `Customers_id` int UNIQUE NOT NULL,
  `status` varchar(255),
  `Menu_id` varchar(255),
  `created_at` varchar(255) COMMENT 'When order created'
);

CREATE TABLE `staff_schedule` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `staff_id` int,
  `weekday` int,
  `start_time` datetime,
  `end_time` datetime,
  `lunch_time` datetime
);

CREATE TABLE `Menu` (
  `m_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `price` int,
  `status` ENUM ('out_of_stock', 'in_stock', 'running_low'),
  `created_at` datetime DEFAULT (now())
);

ALTER TABLE `Customers` ADD FOREIGN KEY (`C_id`) REFERENCES `orders` (`Customers_id`);

ALTER TABLE `Menu` ADD FOREIGN KEY (`m_id`) REFERENCES `orders` (`Menu_id`);

ALTER TABLE `Customers` ADD FOREIGN KEY (`C_id`) REFERENCES `bookings` (`Customers_id`);

ALTER TABLE `staff_schedule` ADD FOREIGN KEY (`staff_id`) REFERENCES `Staff` (`S_id`);

ALTER TABLE `table_schedule` ADD FOREIGN KEY (`tables_id`) REFERENCES `tables` (`id`);

ALTER TABLE `table_schedule` ADD FOREIGN KEY (`id`) REFERENCES `bookings` (`table_schedule_id`);

ALTER TABLE `bookings` ADD FOREIGN KEY (`staff_schedule_id`) REFERENCES `staff_schedule` (`id`);
