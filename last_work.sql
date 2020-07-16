-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2020 at 08:00 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `last_work`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` varchar(4) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL,
  `verify_code` varchar(50) NOT NULL,
  `is_active` tinyint(4) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `account_role`
--

CREATE TABLE `account_role` (
  `id` varchar(5) NOT NULL,
  `account` varchar(4) NOT NULL,
  `role` varchar(5) NOT NULL,
  `is_deleted` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(20) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `leave_quota` int(2) NOT NULL,
  `manager` varchar(4) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `email`, `phone_number`, `leave_quota`, `manager`, `is_deleted`) VALUES
('E001', 'Yosef ', 'yosef@gmail.com', '081212345678', 12, NULL, 0),
('E002', 'Dilan', 'dilan@gmail.com', '081223456789', 12, 'E001', 1),
('E003', 'Danu', 'danu@gmail.com', '081233885727', 12, 'E001', 0);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` varchar(5) NOT NULL,
  `pic` varchar(4) NOT NULL,
  `request` varchar(6) NOT NULL,
  `notes` longtext DEFAULT NULL,
  `date_time` datetime NOT NULL,
  `status` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `pic`, `request`, `notes`, `date_time`, `status`) VALUES
('R001', 'E001', 'REQ001', 'Selamat berlibur', '2020-07-15 16:43:15', 'S001');

-- --------------------------------------------------------

--
-- Table structure for table `parameter`
--

CREATE TABLE `parameter` (
  `id` varchar(3) NOT NULL,
  `name` varchar(20) NOT NULL,
  `note` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `public_holiday`
--

CREATE TABLE `public_holiday` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `holiday_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE `request` (
  `id` varchar(6) NOT NULL,
  `requester` varchar(4) NOT NULL,
  `type` varchar(4) NOT NULL,
  `current_status` varchar(4) NOT NULL DEFAULT 'S003',
  `total` int(2) NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `reason` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `request`
--

INSERT INTO `request` (`id`, `requester`, `type`, `current_status`, `total`, `start`, `end`, `reason`) VALUES
('REQ001', 'E002', 'T001', 'S003', 2, '2020-07-15', '2020-07-17', 'Mau Cuti');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
('RO001', 'Manager'),
('RO002', 'Employee');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
('S001', 'Approved'),
('S002', 'Rejected'),
('S003', 'Waiting');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` varchar(4) NOT NULL,
  `name` varchar(30) NOT NULL,
  `number_of_days` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `name`, `number_of_days`) VALUES
('T001', 'Cuti', 2),
('T002', 'Sakit', 3),
('T003', 'Cuti Melahirkan', 90);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `verify_code` (`verify_code`);

--
-- Indexes for table `account_role`
--
ALTER TABLE `account_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `account` (`account`,`role`),
  ADD KEY `role` (`role`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email` (`email`,`phone_number`),
  ADD KEY `manager` (`manager`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status` (`status`),
  ADD KEY `pic` (`pic`),
  ADD KEY `request` (`request`);

--
-- Indexes for table `parameter`
--
ALTER TABLE `parameter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `public_holiday`
--
ALTER TABLE `public_holiday`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `request`
--
ALTER TABLE `request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `current_status` (`current_status`),
  ADD KEY `type` (`type`),
  ADD KEY `requester` (`requester`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_role`
--
ALTER TABLE `account_role`
  ADD CONSTRAINT `account_role_ibfk_1` FOREIGN KEY (`account`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `account_role_ibfk_2` FOREIGN KEY (`role`) REFERENCES `role` (`id`);

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`manager`) REFERENCES `employees` (`id`);

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`status`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`pic`) REFERENCES `employees` (`id`),
  ADD CONSTRAINT `history_ibfk_3` FOREIGN KEY (`request`) REFERENCES `request` (`id`);

--
-- Constraints for table `request`
--
ALTER TABLE `request`
  ADD CONSTRAINT `request_ibfk_1` FOREIGN KEY (`current_status`) REFERENCES `status` (`id`),
  ADD CONSTRAINT `request_ibfk_2` FOREIGN KEY (`type`) REFERENCES `type` (`id`),
  ADD CONSTRAINT `request_ibfk_3` FOREIGN KEY (`requester`) REFERENCES `employees` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
