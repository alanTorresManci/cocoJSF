-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 15, 2016 at 07:15 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coco`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `username`, `password`) VALUES
(1, 'german', '654321');

-- --------------------------------------------------------

--
-- Table structure for table `assistants`
--

CREATE TABLE `assistants` (
  `id` int(11) NOT NULL,
  `conference` int(11) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assistants`
--

INSERT INTO `assistants` (`id`, `conference`, `name`) VALUES
(1, 1, 'yolo');

-- --------------------------------------------------------

--
-- Table structure for table `conferences`
--

CREATE TABLE `conferences` (
  `id` int(11) NOT NULL,
  `manager` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `exhibitor` varchar(128) NOT NULL,
  `capacity` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `image` varchar(256) DEFAULT NULL,
  `synopsis` text NOT NULL,
  `cost` int(11) NOT NULL,
  `room` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `conferences`
--

INSERT INTO `conferences` (`id`, `manager`, `name`, `exhibitor`, `capacity`, `date`, `image`, `synopsis`, `cost`, `room`) VALUES
(1, 1, 'La conferencia de prueba', 'El coco', 23, '2016-06-16 15:00:00', NULL, 'Esta es la conferencia de prueba.', 0, 'A14');

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

CREATE TABLE `managers` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `managers`
--

INSERT INTO `managers` (`id`, `name`) VALUES
(1, 'saul');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assistants`
--
ALTER TABLE `assistants`
  ADD PRIMARY KEY (`id`),
  ADD KEY `conference` (`conference`);

--
-- Indexes for table `conferences`
--
ALTER TABLE `conferences`
  ADD PRIMARY KEY (`id`),
  ADD KEY `manager_index` (`manager`);

--
-- Indexes for table `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `assistants`
--
ALTER TABLE `assistants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `conferences`
--
ALTER TABLE `conferences`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `managers`
--
ALTER TABLE `managers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `assistants`
--
ALTER TABLE `assistants`
  ADD CONSTRAINT `conference` FOREIGN KEY (`conference`) REFERENCES `conferences` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `conferences`
--
ALTER TABLE `conferences`
  ADD CONSTRAINT `manager` FOREIGN KEY (`manager`) REFERENCES `managers` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
