-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2024 at 08:22 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tcsss_oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `ContactInfo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `Name`, `ContactInfo`) VALUES
(1, 'John', '09876543211'),
(2, 'James', '09128745762'),
(3, 'Michael', '09888855667'),
(8, 'Bro', 'bro@yahoo.com'),
(9, 'Mali', '098700065432'),
(10, 'Mark', 'mark@tahimik.com'),
(12, 'checkmann', 'checkman@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `deleted_customers`
--

CREATE TABLE `deleted_customers` (
  `CustomerID` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `ContactInfo` varchar(255) DEFAULT NULL,
  `DeletedAt` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deleted_customers`
--

INSERT INTO `deleted_customers` (`CustomerID`, `Name`, `ContactInfo`, `DeletedAt`) VALUES
('5', 'David', '09876543432', '2024-11-28 03:24:37'),
('7', 'Marc', '09876543213', '2024-11-28 12:15:27'),
('15', 'Gigi', 'gigi@gmail.com', '2024-11-29 01:41:25'),
('15', 'Gigi', 'gigi@gmail.com', '2024-11-29 01:43:35'),
('16', 'riley', '09050010001', '2024-11-29 02:31:10');

-- --------------------------------------------------------

--
-- Table structure for table `deleted_items`
--

CREATE TABLE `deleted_items` (
  `ItemID` varchar(50) NOT NULL,
  `ItemName` varchar(100) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Description` text DEFAULT NULL,
  `Stock` int(11) NOT NULL,
  `DeletedAt` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deleted_items`
--

INSERT INTO `deleted_items` (`ItemID`, `ItemName`, `Price`, `Category`, `Description`, `Stock`, `DeletedAt`) VALUES
('36', 'Apple Strudel', 50.00, 'Pastries', 'Traditional pastry filled with spiced apples', 50, '2024-11-29 03:03:39');

-- --------------------------------------------------------

--
-- Table structure for table `deleted_orders`
--

CREATE TABLE `deleted_orders` (
  `OrderID` varchar(50) NOT NULL,
  `CustomerID` varchar(50) NOT NULL,
  `OrderDate` datetime NOT NULL,
  `TotalAmount` decimal(10,2) NOT NULL,
  `DeletedAt` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deleted_orders`
--

INSERT INTO `deleted_orders` (`OrderID`, `CustomerID`, `OrderDate`, `TotalAmount`, `DeletedAt`) VALUES
('10', '14', '2024-11-29 00:00:00', 160.00, '2024-11-29 02:49:42'),
('11', '15', '2024-11-29 00:00:00', 110.00, '2024-11-29 02:49:11'),
('12', '16', '2024-11-29 00:00:00', 195.00, '2024-11-29 01:45:02'),
('13', '17', '2024-11-29 00:00:00', 230.00, '2024-11-29 03:20:35'),
('9', '13', '2024-11-29 00:00:00', 170.00, '2024-11-29 02:56:09');

-- --------------------------------------------------------

--
-- Table structure for table `deleted_payments`
--

CREATE TABLE `deleted_payments` (
  `PaymentID` varchar(50) NOT NULL,
  `OrderID` varchar(50) NOT NULL,
  `Amount` decimal(10,2) NOT NULL,
  `PaymentMethod` varchar(50) DEFAULT NULL,
  `Status` enum('Paid','Unpaid') DEFAULT NULL,
  `DeletedAt` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `deleted_payments`
--

INSERT INTO `deleted_payments` (`PaymentID`, `OrderID`, `Amount`, `PaymentMethod`, `Status`, `DeletedAt`) VALUES
('10', '11', 200.00, 'Cash', 'Paid', '2024-11-29 02:49:11'),
('11', '12', 200.00, 'Cash', 'Paid', '2024-11-29 02:31:10'),
('12', '13', 250.00, 'Cash', 'Paid', '2024-11-29 03:20:35'),
('8', '9', 200.00, 'Cash', 'Paid', '2024-11-29 02:56:09'),
('9', '10', 500.00, 'Cash', 'Paid', '2024-11-29 02:49:42');

-- --------------------------------------------------------

--
-- Table structure for table `deleted_users`
--

CREATE TABLE `deleted_users` (
  `UserID` varchar(50) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Status` enum('Admin','Staff') DEFAULT NULL,
  `DeletedAt` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `ItemID` int(11) NOT NULL,
  `ItemName` varchar(255) NOT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `Category` varchar(255) DEFAULT NULL,
  `Description` text DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`ItemID`, `ItemName`, `Price`, `Category`, `Description`, `Stock`) VALUES
(1, 'Brewed Coffee', 30.00, 'Coffee', 'Freshly brewed coffee', 90),
(2, 'Iced Tea', 40.00, 'Tea', 'Organic green tea', 69),
(3, 'Croissant', 40.00, 'Pastries', 'Butter croissant', 41),
(4, 'Cookies', 25.00, 'Pastries', 'Chocolate chip cookies', 193),
(5, 'Espresso', 55.00, 'Coffee', 'Rich and bold espresso shot', 100),
(6, 'Cappuccino', 60.00, 'Coffee', 'A perfect blend of espresso and steamed milk', 80),
(7, 'Matcha Latte', 50.00, 'Tea', 'Creamy matcha latte', 65),
(8, 'Chai Tea', 45.00, 'Tea', 'Spiced chai with aromatic spices', 50),
(9, 'Almond Croissant', 45.00, 'Pastries', 'Pastry filled with almond cream', 60),
(10, 'Macarons', 30.00, 'Pastries', 'Colorful French macarons, assorted flavors', 120),
(11, 'Latte', 55.00, 'Coffee', 'Smooth latte with steamed milk', 73),
(12, 'Iced Matcha', 45.00, 'Tea', 'Refreshing iced matcha drink', 67),
(13, 'Tart au Citron', 35.00, 'Pastries', 'Lemon tart with a buttery crust', 40),
(14, 'Herbal Tea', 30.00, 'Tea', 'Aromatic herbal tea blend', 79),
(15, 'French Toast Pastry', 50.00, 'Pastries', 'Pastry inspired by classic French toast', 30),
(16, 'Cold Brew', 55.00, 'Coffee', 'Smooth and flavorful cold brew coffee', 75),
(17, 'Vanilla Latte', 60.00, 'Coffee', 'Creamy latte infused with vanilla', 70),
(18, 'Earl Grey Tea', 38.00, 'Tea', 'Classic black tea flavored with bergamot', 90),
(19, 'Peppermint Tea', 35.00, 'Tea', 'Refreshing peppermint herbal tea', 85),
(20, 'Chocolate Croissant', 50.00, 'Pastries', 'Flaky pastry filled with rich chocolate', 45),
(21, 'Fruit Tart', 60.00, 'Pastries', 'Delicious tart topped with seasonal fruits', 20),
(22, 'Mocha', 65.00, 'Coffee', 'Rich coffee blended with chocolate and steamed milk', 60),
(23, 'Jasmine Green Tea', 40.00, 'Tea', 'Fragrant green tea with jasmine blossoms', 55),
(24, 'Cinnamon Roll', 30.00, 'Pastries', 'Warm cinnamon roll topped with icing', 100),
(25, 'Irish Coffee', 70.00, 'Coffee', 'Rich coffee with Irish whiskey and cream', 25),
(26, 'Green Tea Latte', 45.00, 'Tea', 'Smooth green tea blended with frothed milk', 50),
(27, 'Pistachio Cake', 65.00, 'Pastries', 'Moist cake with pistachio flavor', 30),
(28, 'Affogato', 75.00, 'Coffee', 'Vanilla ice cream topped with hot espresso', 40),
(29, 'Lemon Ginger Tea', 35.00, 'Tea', 'Zingy lemon and ginger herbal infusion', 70),
(30, 'Blueberry Muffin', 25.00, 'Pastries', 'Moist muffin filled with fresh blueberries', 110),
(31, 'Caramel Macchiato', 65.00, 'Coffee', 'Espresso with caramel and frothy milk', 32),
(32, 'Chrysanthemum Tea', 30.00, 'Tea', 'Delicate floral tea made from chrysanthemum flowers', 60),
(33, 'Cheese Danish', 40.00, 'Pastries', 'Flaky pastry filled with creamy cheese', 80),
(34, 'Hazelnut Coffee', 50.00, 'Coffee', 'Nutty hazelnut flavored coffee', 90),
(35, 'Rooibos Tea', 30.00, 'Tea', 'Naturally caffeine-free red tea', 75);

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE `orderdetails` (
  `OrderDetailID` int(11) NOT NULL,
  `OrderID` varchar(20) NOT NULL,
  `ItemID` varchar(20) NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`OrderDetailID`, `OrderID`, `ItemID`, `Quantity`) VALUES
(1, '1', '1', 1),
(2, '1', '3', 2),
(3, '2', '2', 3),
(4, '3', '3', 2),
(5, '3', '4', 2),
(6, '4', '1', 6),
(7, '5', '1', 4),
(8, '6', '2', 3),
(9, '6', '4', 5),
(11, '8', '2', 2),
(12, '8', '3', 3);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `CustomerID` int(11) DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `TotalAmount` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`OrderID`, `CustomerID`, `OrderDate`, `TotalAmount`) VALUES
(1, 1, '2024-11-27', 130.00),
(2, 2, '2024-11-27', 120.00),
(3, 3, '2024-11-28', 130.00),
(4, 8, '2024-11-29', 300.00),
(5, 9, '2024-11-29', 200.00),
(6, 10, '2024-11-29', 245.00),
(8, 12, '2024-11-29', 200.00);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PaymentID` int(11) NOT NULL,
  `OrderID` int(11) DEFAULT NULL,
  `Amount` decimal(10,2) DEFAULT NULL,
  `PaymentMethod` varchar(50) DEFAULT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PaymentID`, `OrderID`, `Amount`, `PaymentMethod`, `Status`) VALUES
(1, 1, 130.00, 'Cash', 'Paid'),
(2, 2, 80.00, 'Credit', 'Paid'),
(3, 3, 90.00, 'Check', 'Paid'),
(4, 4, 500.00, 'Cash', 'Paid'),
(5, 5, 200.00, 'Check', 'Unpaid'),
(6, 6, 245.00, 'Credit', 'Paid'),
(7, 8, 200.00, 'Check', 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL,
  `Username` varchar(100) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  `Status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserID`, `Username`, `Email`, `Password`, `Status`) VALUES
(1, 'Aeron', 'admin123@admin.com', 'Admin123', 'Admin'),
(2, 'Staff1', 'staff1@gmail.com', 'Staff123', 'Staff'),
(3, 'Staff2', 'staff2@gmail.com', 'Staff4567', 'Staff'),
(4, 'Adrian', 'adrian@yahoo.com', 'Admin123', 'Admin'),
(5, 'Marc', 'marc@yahoo.com', 'admin123', 'Admin'),
(6, 'jojo', 'jojo@gmail.com', 'Admin123', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `deleted_items`
--
ALTER TABLE `deleted_items`
  ADD PRIMARY KEY (`ItemID`);

--
-- Indexes for table `deleted_orders`
--
ALTER TABLE `deleted_orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `deleted_payments`
--
ALTER TABLE `deleted_payments`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `deleted_users`
--
ALTER TABLE `deleted_users`
  ADD PRIMARY KEY (`UserID`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`ItemID`);

--
-- Indexes for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`OrderDetailID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PaymentID`),
  ADD KEY `OrderID` (`OrderID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `OrderDetailID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`CustomerID`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `orders` (`OrderID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
