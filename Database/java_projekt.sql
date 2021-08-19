-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 19. Aug 2021 um 18:11
-- Server-Version: 10.4.14-MariaDB
-- PHP-Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `java_projekt`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `address`
--

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL,
  `city` varchar(25) NOT NULL,
  `house_number` varchar(10) NOT NULL,
  `street` varchar(35) NOT NULL,
  `zip_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `address`
--

INSERT INTO `address` (`id`, `city`, `house_number`, `street`, `zip_code`) VALUES
(1, 'Erfurt', '5', 'ErfurtStraße', '99085'),
(2, 'Erfurt', '5a', 'Marcel-Bruer-Ring', '99085'),
(3, 'Erfurt', '5', 'Marcel-Breuer-Ring', '99085'),
(4, 'erfurt', '5', 'Marcel-Breuer-ring', '99085'),
(5, 'Erfurt', '5', 'marcel-Breuer-Ring', '99085'),
(6, 'Erfurt', '5', 'marcel-Breuer-Ring', '99085');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `sort_title` varchar(255) DEFAULT NULL,
  `restaurant_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `category`
--

INSERT INTO `category` (`id`, `sort_title`, `restaurant_id`) VALUES
(1, 'shamShawarma', 1),
(2, 'shamPizza', 1),
(3, 'shamGrill', 1),
(4, 'shamSalat', 1),
(5, 'shamVegetarisch', 1),
(6, 'shamGetränke', 1),
(7, 'shamInternational', 1),
(8, 'AdemShawarma', 2),
(9, 'AdemPizza', 2),
(10, 'AdemGrill', 2),
(11, 'AdemNudel', 2),
(12, 'AdemSalat', 2),
(13, 'AdemVegetarisch', 2),
(14, 'AdemGetränke', 2),
(15, 'AdemInternational', 2);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `ordered` datetime DEFAULT NULL,
  `shipped` datetime DEFAULT NULL,
  `shipping_status` varchar(255) DEFAULT NULL,
  `total` decimal(7,2) NOT NULL,
  `payment_id` bigint(20) DEFAULT NULL,
  `shipping_address_id` bigint(20) DEFAULT NULL,
  `shoppingcart_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `orders`
--

INSERT INTO `orders` (`id`, `order_status`, `ordered`, `shipped`, `shipping_status`, `total`, `payment_id`, `shipping_address_id`, `shoppingcart_id`, `user_id`) VALUES
(1, 'REGISTERED', '2021-07-06 13:58:02', NULL, 'PENDING', '11.69', 1, 1, 1, 1),
(2, 'REGISTERED', '2021-07-06 17:35:35', NULL, 'PENDING', '10.04', 2, 1, 2, 1),
(3, 'REGISTERED', '2021-07-06 17:52:42', NULL, 'PENDING', '15.99', 3, 1, 3, 1),
(4, 'REGISTERED', '2021-07-08 18:02:53', NULL, 'PENDING', '13.98', 4, 1, 4, 1),
(5, 'REGISTERED', '2021-07-12 11:17:47', NULL, 'PENDING', '8.97', 5, 1, 6, 1),
(6, 'REGISTERED', '2021-08-19 18:08:35', NULL, 'PENDING', '7.48', 6, 6, 11, 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `payment`
--

CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL,
  `date_paid` datetime DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `payment`
--

INSERT INTO `payment` (`id`, `date_paid`, `details`, `payment_method`) VALUES
(1, NULL, NULL, 'PAYPAL'),
(2, NULL, NULL, 'PAYPAL'),
(3, NULL, NULL, 'PAYPAL'),
(4, NULL, NULL, 'PAYPAL'),
(5, NULL, NULL, 'CREDITCARD'),
(6, NULL, NULL, 'CREDITCARD');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `description` text NOT NULL,
  `imag_path` varchar(255) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `product`
--

INSERT INTO `product` (`id`, `description`, `imag_path`, `price`, `product_name`, `category_id`) VALUES
(1, 'Hähnchenfleisch, Gurken und Soße', 'img/food-delivery/restaurants/single/shawarmarolle.png', '3.49', 'Teigrolle Schawrma', 1),
(2, 'Hähnchenfleisch, Salat und Soße', 'img/food-delivery/restaurants/single/shawarmaMitSalat.png', '3.99', 'Teigrolle Schawrma', 1),
(3, 'Hähnchenfleisch, Pommes, Salat, Soße', 'img/food-delivery/restaurants/single/arabischTeller.png', '5.49', 'Arabischer Teller', 1),
(4, 'Hähnchenfleisch, (Pommes oder Reis) Salat und Soße', 'img/food-delivery/restaurants/single/shwarmaTeller.png', '6.49', 'Schawrma Teller', 1),
(5, 'mit Pommes und Soße', 'img/food-delivery/restaurants/single/shawarmaBox.png', '3.49', 'Schawrma BOX', 1),
(6, 'Hähnchenbrust, Paprika, Pilze, Zwiebeln, Mais, Käse und Soße', 'img/food-delivery/restaurants/single/fahitaRolle.png', '3.99', 'Teigrolle Fahita', 1),
(7, 'Hähnchenbrust, Paprika, Pilze, Zwiebeln, Mais, Käse, Pommes oder Reis, Salat und Soße', 'img/food-delivery/restaurants/single/fahitaTeller.png', '6.49', 'Teller Fahita ', 1),
(8, '26 cm ,mit scharf und Mozzarella Käse', 'img/food-delivery/restaurants/single/mnakishKäse.png', '2.49', 'Käse ', 2),
(9, '26 cm ,...', 'img/food-delivery/restaurants/single/manakishZatar.png', '1.99', 'Thymain', 2),
(10, '26 cm ,mit Mozzarella Käse', 'img/food-delivery/restaurants/single/Muhamra.png', '2.49', 'Muhamra-scharf ', 2),
(11, '26 cm ,mit Hackfleisch', 'img/food-delivery/restaurants/single/lahmacun.png', '2.49', 'Lahmacun', 2),
(12, '26 cm ,mit Hänchen Brust', 'img/food-delivery/restaurants/single/pizzaShish.png', '3.49', 'Shish Tawuk', 2),
(13, '26 cm ,...', 'img/food-delivery/restaurants/single/martadella.png', '2.49', 'Martadella', 2),
(14, '28 cm, mit Soße und Käse', 'img/food-delivery/restaurants/single/margherita.png', '4.49', 'Margarita ', 2),
(15, '28 cm, mit Soße, Käse, Zwiebeln und Tonfisch', 'img/food-delivery/restaurants/single/pizzaTunfisch.png', '5.99', 'Tonfisch', 2),
(16, '28 cm, mit Soße, Käse, Schawrma und Zwiebel', 'img/food-delivery/restaurants/single/shawarmaPizza.png', '6.49', 'Schawrma ', 2),
(17, '28 cm, mit Soße, Käse und Salami', 'img/food-delivery/restaurants/single/slamiPizza.png', '5.49', 'Salami', 2),
(18, 'Gegrillte Hähnchenbrust, Salat und Soße', 'img/food-delivery/restaurants/single/shishRolle.png', '3.99', 'Teigrolle Shish-Tawook', 3),
(19, 'Gegrillte Hähnchenbrust, Pommes, Salat und Soße', 'img/food-delivery/restaurants/single/shishTellerP.png', '6.49', 'Teller Shish-Tawook ', 3),
(22, 'mit gegrillten Tomaten, Spizpaprika & Zwiebel, Pommes und Humus ', 'img/food-delivery/restaurants/single/kebabTeller.png', '7.99', 'Kebab Teller', 3),
(23, 'mit gegrillten Tomaten, Spizpaprika & Zwiebel', 'img/food-delivery/restaurants/single/kebabRolle.png', '3.99', 'Kebab Rolle', 3),
(24, 'mit gegrillten Tomaten, Spizpaprika & Zwiebel, Reis und Humus', 'img/food-delivery/restaurants/single/LammspießTeller.png\r\n', '8.99', 'Lammspieß Teller', 3),
(25, 'mit gegrillten Tomaten, Spizpaprika & Zwiebel, Pommes und Humus', 'img/food-delivery/restaurants/single/lammspießTellerMitPommes.png', '8.99', 'Lammspieß Teller', 3),
(26, 'mit gegrillten Tomaten, Spizpaprika & Zwiebel, Humus', 'img/food-delivery/restaurants/single/LammspießRolle.png', '3.99', 'Lammspieß Rolle', 3),
(27, '1x Hackspieß + 1x Lammspieß+ 1x Shishtauok\r\nmit gegrillten Tomaten, Spizpaprika & Zwiebel, Reis und Humus', 'img/food-delivery/restaurants/single/mixTellerMitReis.png', '9.99', 'Mix Teller', 3),
(28, '2x Hackspieß + 1x Lammspieß+ 1x Shishtauok\r\nmit gegrillten Tomaten, Spizpaprika & Zwiebel, Pommes und Humus', 'img/food-delivery/restaurants/single/mixTellerMitPommes.png\r\n', '9.99', 'Mix Teller', 3),
(29, 'Hähnchen vom Spieß, Tomaten, Salat und Soße', 'img/food-delivery/restaurants/single/schawrmaSalat.png', '5.99', 'Schawrma Salat', 4),
(30, 'Tomaten, Gurken, Eisbergsalat, Mais', 'img/food-delivery/restaurants/single/gemischterSalat.png', '3.49', 'Gemischter Salat', 4),
(31, 'Petersilie, Tomaten, Bulgur', 'img/food-delivery/restaurants/single/taboulehSalat.png', '3.49', 'Tabouleh Salat', 4),
(32, 'Gebratener Ziegenkäse, Gemüse', 'img/food-delivery/restaurants/single/teigrolleHalloumi.png', '3.49', 'Teigrolle Halloumi', 5),
(33, 'Gebratener Ziegenkäse, Gemüse', 'img/food-delivery/restaurants/single/tellerHalloumi.png', '5.49', 'Teller Halloumi ', 5),
(34, 'Gebackene Zucchini mit Ei, Käse, Lauchzwiebeln und Hummus', 'img/food-delivery/restaurants/single/teigrolleZucchiniFeta.png', '3.49', 'Teigrolle Zucchini Feta ', 5),
(35, 'Gebackene Zucchini mit Ei, Käse, Lauchzwiebeln, Salat ', 'img/food-delivery/restaurants/single/tellerZucchiniFeta.png', '5.49', 'Teller Zucchini Feta', 5),
(36, 'Mit Kichererbsen, Salat und Hummus ', 'img/food-delivery/restaurants/single/teigrolleFalafel.png', '3.49', 'Teigrolle Falafel', 5),
(37, 'Mit Kichererbsen, Spezialsoße, Salat und Hummus', 'img/food-delivery/restaurants/single/tellerFalafel.png', '5.49', 'Teller Falafel', 5),
(38, 'mit Salat und Soße', 'img/food-delivery/restaurants/single/teigrollePommes.png', '2.99', 'Teigrolle Pommes', 5),
(39, 'mit Ketchup und Mayo', 'img/food-delivery/restaurants/single/tellerPommes.png', '2.99', 'Teller Pommes', 5),
(40, 'Hummus mit olivenöl', 'img/food-delivery/restaurants/single/hummus.png', '2.99', 'Hummus', 5),
(41, '0,33L', 'img/food-delivery/restaurants/single/alkoholfreieGetränke.png', '1.49', 'Alkoholfreie Getränke', 6),
(42, '0,33L', 'img/food-delivery/restaurants/single/frischerAyran.png', '0.99', 'Frischer Ayran', 6),
(43, '0,33L', 'img/food-delivery/restaurants/single/wasser.png', '0.99', 'Wasser', 6),
(44, 'Hähnchenleber mit Salat und Soße', 'img/food-delivery/restaurants/single/teigrolleLeber.png', '3.99', 'Teigrolle Leber', 7),
(45, 'Hähnchenleber, Pommes, Salat und Soße', 'img/food-delivery/restaurants/single/tellerLeber.png', '6.49', 'Teller Leber ', 7),
(46, 'Hähnchenleber, Reis, Salat und Soße', 'img/food-delivery/restaurants/single/tellerLeberMitReis.png', '6.49', 'Teller Leber', 7),
(47, 'Hähnchenbrust, Paprika, Pilze, Zwiebeln, Mais und Soße', 'img/food-delivery/restaurants/single/teigrolleMexikanisch.png', '3.99', 'Teigrolle Mexikanisch (Scharf)', 7),
(48, 'Hähnchenbrust, Paprika, Pilze, Zwiebeln, Mais, Salt und Soße', 'img/food-delivery/restaurants/single/tellerMexikanischScharf.png', '6.49', 'Teller Mexikanisch (Scharf)', 7),
(49, 'Hähnchenbrust, Paprika, Pilze, Zwiebeln, Mais,Bohnen', 'img/food-delivery/restaurants/single/tellerMexikanisch.png', '6.49', 'Teller Mexikanisch ', 7),
(50, 'Panierte Hähnchenbrust,Salat und Soße', 'img/food-delivery/restaurants/single/teigrolleCrispy.png', '3.99', 'Teigrolle Crispy ', 7),
(51, 'Panierte Hähnchenbrust, Pommes ,ketchup', 'img/food-delivery/restaurants/single/tellerCrispy.png', '6.49', 'Teller Crispy', 7),
(52, 'Pommes, Salat und Soße', 'img/food-delivery/restaurants/single/teigrolleChickenNuggets.png', '3.49', 'Teigrolle Chicken Nuggets', 7),
(53, 'Pommes, Salat und Soße', 'img/food-delivery/restaurants/single/tellerChickenNuggets.png', '5.49', 'Teller Chicken Nuggets', 7),
(54, 'mit Bratkartoffel, Salat und Soße', 'img/food-delivery/restaurants/single/halbesHähnchen.png', '7.99', 'Halbes Hähnchen', 7),
(55, 'mit Bratkartoffel, Salat', 'img/food-delivery/restaurants/single/ganzesHähnchen.png', '14.99', 'Ganzes Hähnchen', 7),
(56, 'Döner', 'img/food-delivery/restaurants/single/dönerKabeb.png', '3.99', 'Döner Kabeb', 8),
(57, 'Döner', 'img/food-delivery/restaurants/single/dönerKabeb.png', '4.99', 'Big Döner', 8),
(58, 'mit Käse', 'img/food-delivery/restaurants/single/dönerMitKäse.png', '4.49', 'Döner', 8),
(59, 'dönerrolle', 'img/food-delivery/restaurants/single/dürum.png', '4.49', 'Dürum', 8),
(60, 'mit Salat und Sose', 'img/food-delivery/restaurants/single/dönerBox.png', '4.49', 'Döner Box', 8),
(61, 'mit Pommes und Sose', 'img/food-delivery/restaurants/single/dönerBoxMitPommes.png', '4.49', 'Döner Box', 8),
(62, 'mit Gemüße und Sose', 'img/food-delivery/restaurants/single/dönerBoxMitGemüse.png', '4.49', 'Döner Box', 8),
(63, 'hähnchenshawarma in arabischen Brot, sauergurken Knoblauchcreme', 'img/food-delivery/restaurants/single/shawarmarolle.png', '4.49', 'Shawarmarolle', 8),
(64, 'hähnchenshawarma in sesambrot,sauergurken Knoblauchcreme', 'img/food-delivery/restaurants/single/raketenshawarma.png', '4.99', 'Raketenshawarma', 8),
(65, 'hähnchenshawarma in Brot mit Knoblauchcreme,scharf und Pommes', 'img/food-delivery/restaurants/single/raketenshawarmaMitPommes.png', '5.99', 'Raketenshawarma', 8),
(66, 'geschnitten shawarma Sandwich mit Knoblauchcreme,Salat Kolnso,Pommes', 'img/food-delivery/restaurants/single/arabischShawarmaTeller.png', '5.99', 'Arabisch Shawarma Teller', 8),
(67, 'Hänschen streifen shawarma mit Knoblauchcreme,Salat Kolnso,Pommes', 'img/food-delivery/restaurants/single/shawarmaTeller.png', '7.49', 'Shawarma Teller', 8),
(68, 'Hänschen streifen shawarma mit Knoblauchcreme,Salat,Reis', 'img/food-delivery/restaurants/single/shawarmaTellerMitReis.png', '7.49', 'Shawarma Teller', 8),
(69, 'Zwei geschnitten shawarma Sandwich mit Knoblauchcreme,Salat Kolnso,Pommes', 'img/food-delivery/restaurants/single/arabischTellerJumbo.png', '7.49', ' Arabisch Teller Jumbo', 8),
(70, 'Dönerfleisch mit Tomaten Sahne Soße mit Käse in Ofen Überbacken', 'img/food-delivery/restaurants/single/dönerÜberbacken.png', '5.99', 'Döner überbacken', 8),
(71, ' mit Salat,Pommes und Soße', 'img/food-delivery/restaurants/single/dönerTeller.png', '7.49', 'Döner Teller', 8),
(72, 'mit Salat,Reis und Soße', 'img/food-delivery/restaurants/single/dönerTellerMitReis.png', '7.49', 'Döner Teller', 8),
(73, 'mit Salt, Nudel und Soße', 'img/food-delivery/restaurants/single/dönerTellerMitNudeln.png', '7.49', 'Döner Teller', 8),
(74, '28 cm', 'img/food-delivery/restaurants/single/pizzaMargharittaKlein.png', '4.49', 'Pizza Margharitta', 9),
(75, '30 cm', 'img/food-delivery/restaurants/single/pizzaMargharittaGroß.png', '5.49', 'Pizza Margharitta', 9),
(76, '28 cm', 'img/food-delivery/restaurants/single/pizzaSalamiAdem.png', '5.49', 'Pizza Salami', 9),
(77, '30 cm', 'img/food-delivery/restaurants/single/pizzaSalamiAdem.png', '6.49', 'Pizza Salami', 9),
(78, '28 cm', 'img/food-delivery/restaurants/single/pizzaSchinkenAdem.png', '5.49', 'Pizza Schinken', 9),
(79, '30 cm', 'img/food-delivery/restaurants/single/pizzaSchinkenAdem.png', '6.49', 'Pizza Schinken', 9),
(80, '28 cm', 'img/food-delivery/restaurants/single/pizzaChampignonsAdem.png', '5.49', 'Pizza Champignons', 9),
(81, '30 cm', 'img/food-delivery/restaurants/single/pizzaChampignonsAdem.png', '6.49', 'Pizza Champignons', 9),
(82, '28 cm', 'img/food-delivery/restaurants/single/pizzaTonoThunfischUndZwiebelnAdem.png', '5.49', 'Pizza Tono Thunfisch und Zwiebeln', 9),
(83, '30 cm', 'img/food-delivery/restaurants/single/pizzaTonoThunfischUndZwiebelnAdem.png', '6.49', 'Pizza Tono Thunfisch und Zwiebeln', 9),
(84, '28 cm', 'img/food-delivery/restaurants/single/pizzaHawaiiAdem.png', '5.49', 'Pizza Hawaii schinken und Ananas', 9),
(85, '30 cm', 'img/food-delivery/restaurants/single/pizzaHawaiiAdem.png', '6.49', 'Pizza Hawaii schinken und Ananas', 9),
(86, '28 cm', 'img/food-delivery/restaurants/single/pizzaQuattroFormaggiAdem.png', '5.99', 'Pizza quattro formaggi vier Käse Sorten', 9),
(87, '30 cm', 'img/food-delivery/restaurants/single/pizzaQuattroFormaggiAdem.png', '6.99', 'Pizza quattro formaggi vier Käse Sorten', 9),
(88, '28 cm', 'img/food-delivery/restaurants/single/pizzaDönerfleichAdem.png', '6.49', 'Pizza mit Dönerfleich und Zwiebeln', 9),
(89, '30 cm', 'img/food-delivery/restaurants/single/pizzaDönerfleichAdem.png', '7.49', 'Pizza mit Dönerfleich und Zwiebeln', 9),
(90, '28 cm', 'img/food-delivery/restaurants/single/pizzaRomanaAdem.png', '6.49', 'Pizza Romana Salami Schinken Champi', 9),
(100, '30 cm', 'img/food-delivery/restaurants/single/pizzaRomanaAdem.png', '7.49', 'Pizza Romana Salami Schinken Champi', 9),
(101, '28 cm', 'img/food-delivery/restaurants/single/salamiSchinkenAdem.png', '6.49', 'Salami Schinken', 9),
(102, '30 cm', 'img/food-delivery/restaurants/single/salamiSchinkenAdem.png', '7.49', 'Salami Schinken', 9),
(103, '28 cm', 'img/food-delivery/restaurants/single/salamiChampignon.png', '6.49', 'Salami Champignon', 9),
(104, '30 cm', 'img/food-delivery/restaurants/single/salamiChampignon.png', '7.49', 'Salami Champignon', 9),
(105, '28 cm', 'img/food-delivery/restaurants/single/pizzaSchinkenChampignonAdem.png', '6.49', 'Schinken Champignon', 9),
(106, '30 cm', 'img/food-delivery/restaurants/single/pizzaSchinkenChampignonAdem.png', '7.49', 'Schinken Champignon', 9),
(107, '28 cm', 'img/food-delivery/restaurants/single/pizzaRamboDönerfleich.png', '6.49', 'Pizza rambo Dönerfleich', 9),
(108, '30 cm', 'img/food-delivery/restaurants/single/pizzaRamboDönerfleich.png', '7.49', 'Pizza rambo Dönerfleich', 9),
(109, '28 cm', 'img/food-delivery/restaurants/single/pizzarucola.png', '6.49', 'Pizza rucola', 9),
(110, '30 cm', 'img/food-delivery/restaurants/single/pizzarucola.png', '7.49', 'Pizza rucola', 9),
(111, '28 cm', 'img/food-delivery/restaurants/single/pizzaPoloSpinatAdem.png', '6.99', 'Pizza polo Spinat sauce holländaise', 9),
(112, '30 cm', 'img/food-delivery/restaurants/single/pizzaPoloSpinatAdem.png', '7.99', 'Pizza polo Spinat sauce holländaise', 9),
(113, '28 cm', 'img/food-delivery/restaurants/single/pizzaCalzoneAdem.png', '6.49', 'Pizza calzone mit Thunfisch und Paprika ', 9),
(114, '30 cm', 'img/food-delivery/restaurants/single/pizzaCalzoneAdem.png', '7.49', 'Pizza calzone mit Thunfisch und Paprika ', 9),
(115, '28 cm', 'img/food-delivery/restaurants/single/pizzaQuattroStagioneAdem.png', '5.99', 'Pizza quattro stagione paprika Champignon Tomaten Mais und Knoplauch', 9),
(116, '30 cm', 'img/food-delivery/restaurants/single/pizzaQuattroStagioneAdem.png', '6.99', 'Pizza quattro stagione paprika Champignon Mais Tomaten', 9),
(117, '28 cm', 'img/food-delivery/restaurants/single/pizzaVergetarischBrokkoli.png', '6.49', 'Pizza Brokkoli Spinat Paprika  Zwiebeln', 9),
(118, '30 cm', 'img/food-delivery/restaurants/single/pizzaVergetarischBrokkoli.png', '7.49', 'Pizza Brokkoli Spinat Paprika Champi Zwiebeln', 9),
(119, '28 cm', 'img/food-delivery/restaurants/single/pizzaSalmoneAdem.png', '6.99', 'Pizza salmone Lachs Zwiebeln Mozzarella  Knoblauch', 9),
(120, '30 cm', 'img/food-delivery/restaurants/single/pizzaSalmoneAdem.png', '7.99', 'Pizza salmone Lachs Zwiebeln Mozzarella Knoblauch', 9),
(121, '28 cm', 'img/food-delivery/restaurants/single/pizzaMareAdem.png', '6.99', 'Pizza Mare Meeresfrüchte Knoblauch', 9),
(122, '30 cm', 'img/food-delivery/restaurants/single/pizzaMareAdem.png', '7.99', 'Pizza Mare Meeresfrüchte Knoblauch', 9),
(123, '28 cm', 'img/food-delivery/restaurants/single/pizzakuchen.png', '6.49', 'Pizza kuchen', 9),
(124, '30 cm', 'img/food-delivery/restaurants/single/pizzakuchen.png', '7.49', 'Pizza kuchen', 9),
(125, '28 cm', 'img/food-delivery/restaurants/single/pizzaAdemLachs.png', '7.49', 'Pizza adem Lachs schrimps Spinat', 9),
(126, '30 cm', 'img/food-delivery/restaurants/single/pizzaAdemLachs.png', '8.49', 'Pizza adem Lachs schrimps Spinat', 9),
(127, '28 cm', 'img/food-delivery/restaurants/single/pizzaRomaAdem.png', '7.49', 'Pizza roma Salami Schinken Ei Champi Basilikum', 9),
(128, '30 cm', 'img/food-delivery/restaurants/single/pizzaRomaAdem.png', '8.49', 'Pizza roma Salami Schinken Ei  Champi basilikum', 9),
(129, '28 cm', 'img/food-delivery/restaurants/single/pizzaCapreseAdem.png', '5.99', 'Pizza caprese frisch Tomaten und Mozzarella', 9),
(130, '30 cm', 'img/food-delivery/restaurants/single/pizzaCapreseAdem.png', '6.99', 'Pizza caprese frisch Tomaten und Mozzarella', 9),
(131, '28 cm', 'img/food-delivery/restaurants/single/vegiPizza.png', '6.99', 'Vegi Pizza', 9),
(132, '30 cm', 'img/food-delivery/restaurants/single/vegiPizza.png', '7.99', 'Vegi Pizza', 9),
(133, 'Prei pro Stück\r\n10 cm', 'img/food-delivery/restaurants/single/pizzaBrötchenNachAuswahl.png', '5.99', 'Pizza Brötchen nach Auswahl', 9),
(134, 'Preis pro Stück\r\n15cm', 'img/food-delivery/restaurants/single/pizzaBrötchenNachAuswahl.png', '6.99', 'Pizza Brötchen nach Auswahl', 9),
(135, '28 cm', 'img/food-delivery/restaurants/single/mankoschaKäseAdem.png', '2.49', 'Mankoscha Käse', 9),
(136, '28 cm', 'img/food-delivery/restaurants/single/mankoschaHackfleischAdem.png', '2.49', 'Mankoscha Hackfleisch', 9),
(137, '28 cm', 'img/food-delivery/restaurants/single/mankoschaZaaterAdem.png', '1.99', 'Mankoscha zaater', 9),
(138, '28 cm', 'img/food-delivery/restaurants/single/mankoschaMhammaraAdem.png', '1.99', 'Mankoscha mhammara(scharf Soße)', 9),
(139, '28 cm', 'img/food-delivery/restaurants/single/mankoschaMhammaraMitKäseAdem.png', '2.49', 'Mankoscha mhammara mit Käse', 9),
(140, 'mit Knoblauchcreme', 'img/food-delivery/restaurants/single/ganzesHähnchenAdem.png', '7.99', 'Ganzes Hähnchen', 10),
(141, 'mit Knoblauchcreme,Pommes ', 'img/food-delivery/restaurants/single/ganzesHähnchenMitPommes.png', '11.99', 'Ganzes Hähnchen', 10),
(142, 'mit Knoblauchcreme,Salat,Pommes ', 'img/food-delivery/restaurants/single/halbHähnchenAdem.png', '7.49', 'Halb Hähnchen', 10),
(143, 'halb Hähnchen auf mandi Reis mit mandi Soße', 'img/food-delivery/restaurants/single/mandiTellerAdem.png', '8.49', 'Mandi Teller', 10),
(144, 'brüstet(knusprig) mit Pommes Knoblauchcreme und Soße', 'img/food-delivery/restaurants/single/hähnchenKnusprigAdem.png', '9.99', 'Hähnchen Knusprig', 10),
(145, 'brüstet(knusprig) ', 'img/food-delivery/restaurants/single/brüstetHähnchen.png', '14.99', 'brüstet(knusprig) Hähnchen ', 10),
(146, 'brüstet(knusprig) mit Knoblauchcreme, Salat und Pommes', 'img/food-delivery/restaurants/single/brüstetHähnchenMitPommes.png', '8.49', 'brüstet Hähnchen ', 10),
(147, 'Hahnchenschenkel mit Süßkartoffel, Mais, Salat und Paprika', 'img/food-delivery/restaurants/single/hahnchenschenkel.png', '5.99', 'Hahnchenschenkel', 10),
(148, 'Salat,Tomaten und Gurken', 'img/food-delivery/restaurants/single/grünerSalatAdem.png', '3.49', 'Grüner Salat', 12),
(149, 'Salat,Tomaten,Gurken Radischen  und knusprige Brot', 'img/food-delivery/restaurants/single/fattouschAdem.png', '4.99', 'Fattousch', 12),
(150, 'Salat,Tomaten,Gurken, Paprika und Mais', 'img/food-delivery/restaurants/single/gemischterSalatAdem.png', '4.99', 'Gemischter Salat', 12),
(151, 'Gemischter Salat,Ei,Käse und Thunfisch', 'img/food-delivery/restaurants/single/italienscherSalatAdem.png', '5.99', 'Italienscher Salat', 12),
(152, 'Salat,Tomaten und Mozzarella', 'img/food-delivery/restaurants/single/tomatenMozzarellaAdem.png', '5.99', 'Tomaten Mozzarella', 12),
(153, 'Gemischter Salat Käse und Hähnchenbrust', 'img/food-delivery/restaurants/single/salatAtyebFrischAdem.png', '5.99', 'Salat Atyeb frisch', 12),
(154, 'mit Tomaten Soße', 'img/food-delivery/restaurants/single/spaghettiNapoliAdem.png', '4.99', 'Spaghetti napoli', 11),
(155, 'mit hackfleisch Soße', 'img/food-delivery/restaurants/single/spaghettiBologneseAdem.png', '5.99', 'Spaghetti Bolognese', 11),
(156, 'mit Schinken Ei in sahne Soße', 'img/food-delivery/restaurants/single/spaghettiCarbonaraAdem.png', '5.99', 'Spaghetti carbonara', 11),
(157, 'mit Meeresfrüchten Knoblauch in Tomaten soße', 'img/food-delivery/restaurants/single/spaghettiMareAdem.png', '6.99', 'Spaghetti Mare', 11),
(158, 'mit frisch Knoblauch in Oliven Öl gebraten', 'img/food-delivery/restaurants/single/spaghettiAgiloOlioAdem.png', '4.99', 'Spaghetti Agilo olio', 11),
(159, 'mit Schinken in Tomaten Sahne Soße', 'img/food-delivery/restaurants/single/spaghettiPaesanaAdem.png', '5.99', 'Spaghetti PEASANA', 11),
(160, ' mit Tomaten Soße', 'img/food-delivery/restaurants/single/rigatoniNapoliAdem.png', '4.99', 'Rigatoni napoli', 11),
(161, 'mit hackfleisch Soße', 'img/food-delivery/restaurants/single/rigatoniBologneseAdem.png', '5.99', 'Rigatoni Bolognese', 11),
(162, ' mit Schinken Ei in sahne Soße', 'img/food-delivery/restaurants/single/rigatoniCarbonaraAdem.png', '5.99', 'Rigatoni carbonara', 11),
(163, 'mit Schinken Erbsen in Tomaten Sahne Soße', 'img/food-delivery/restaurants/single/rigatoniPeasanaAdem.png', '5.99', 'Rigatoni PEASANA', 11),
(164, 'Kuh-Käse', 'img/food-delivery/restaurants/single/rigatoniQuattroAdem.png', '5.99', 'Rigatoni Quattro formaggi in vier Käse Soße', 11),
(165, ' mit Hähnchen Brokkoli in Tomaten Sahne Soße', 'img/food-delivery/restaurants/single/rigatoniHähnchenAdem.png', '6.99', 'Rigatoni Hähnchen', 11),
(166, 'Hähnchen streifen Spinat Sahne Soße', 'img/food-delivery/restaurants/single/rigatoniPoloAdem.png', '6.99', 'Rigatoni Polo', 11),
(167, 'Mit Lachs in Tomaten Soße', 'img/food-delivery/restaurants/single/rigatoniSalmoneAdem.png', '6.99', 'Rigatoni salmone', 11),
(168, 'Mit Thunfisch und Tomaten und Oliven', 'img/food-delivery/restaurants/single/rigatoniTonoAdem.png', '5.99', 'Rigatoni tono', 11),
(169, 'Knoblauch in Tomaten soße', 'img/food-delivery/restaurants/single/rigatoniArrabiateAdem.png', '5.99', 'Rigatoni arrabiate', 11),
(170, 'Mit Dönerfleisch in Tomaten Soße', 'img/food-delivery/restaurants/single/rigatoniDönerAdem.png', '6.99', 'Rigatoni Döner', 11),
(171, 'Hähnchen champi Knolauch in hollandaise Sahne soße ', 'img/food-delivery/restaurants/single/rigatoniAtyebfrischAdem.png', '6.99', 'Rigatoni atyebfrisch', 11),
(172, 'Döner', 'img/food-delivery/restaurants/single/vegetarischeDönerAdem.png', '3.49', 'vegetarische Döner Sandwich', 13),
(173, 'in Tanourbrot mit Salat,Humos,Sauergurken und erdnuss Soße', 'img/food-delivery/restaurants/single/falafelSandwichAdem.png', '3.49', 'Falafel Sandwich', 13),
(174, 'in Sesambrot mit Salat,Humos,Sauergurken und erdnuss Soße', 'img/food-delivery/restaurants/single/falafelSandwichSesamAdem.png', '3.99', 'Falafel Sandwich', 13),
(175, 'in Tanourbrot mit Salat,Humos,Sauergurken und erdnuss Soße', 'img/food-delivery/restaurants/single/falafelUndHalloumiSandwichAdem.png', '3.99', 'Falafel und Halloumi Sandwich', 13),
(176, 'in Sesambrot mit Salat,Humos,Sauergurken und erdnuss Soße', 'img/food-delivery/restaurants/single/falafelUndHalloumiSandwich.png', '3.99', 'Falafel und Halloumi Sandwich', 13),
(177, 'Glutenfrei', 'img/food-delivery/restaurants/single/falafelGlutenfrei.png', '4.49', 'Falafel Kugel ', 13),
(178, 'mit Salat, Tomaten, Brokkoli und Käse', 'img/food-delivery/restaurants/single/bunteFalafel.png', '4.99', 'Bunte Falafel', 13),
(179, 'in Tanourbrot mit Salat,Humos,Sauergurken und erdnuss Soße', 'img/food-delivery/restaurants/single/halloumiSandwich.png', '3.99', 'Halloumi Sandwich', 13),
(180, 'in Sesambrot mit Salat,Humos,Sauergurken und erdnuss Soße', 'img/food-delivery/restaurants/single/halloumiSandwichSesambrot.png', '4.49', 'Halloumi Sandwich', 13),
(181, 'mit Salat, Soße und Reis', 'img/food-delivery/restaurants/single/HalloumiGlutenfrei.png', '4.49', 'Halloumi Glutenfrei', 13),
(182, 'in Sesambrot,Majonäse und Katcup', 'img/food-delivery/restaurants/single/pommesSandwichAdem.png', '3.99', 'Pommes Sandwich', 13),
(183, 'mit Salat,Humos und erdnuss Soße', 'img/food-delivery/restaurants/single/falafelBurger.png', '4.99', 'Falafel Burger', 13),
(184, 'mit Salat,Humos und erdnuss Soße', 'img/food-delivery/restaurants/single/falafelTellerAdem.png', '5.99', 'Falafel Teller', 13),
(185, 'mit Salat,Humos und erdnuss Soße', 'img/food-delivery/restaurants/single/halloumiTellerAdem.png', '5.99', 'Halloumi Teller', 13),
(186, 'Flafel und Halloumi mit Salat,Humos,Pommes und erdnuss Soße', 'img/food-delivery/restaurants/single/kombuniertVegetarischeTeller.png', '7.49', 'Kombuniert vegetarische Teller', 13),
(187, 'beilegen', 'img/food-delivery/restaurants/single/PommesAdem.png', '2.49', 'Pommes', 13),
(188, 'beilegen', 'img/food-delivery/restaurants/single/pommesMitKäseAdem.png', '3.99', 'Pommes mit Käse', 13),
(189, 'beilegen', 'img/food-delivery/restaurants/single/KnoblauchcremeAdem.png', '2.49', 'Knoblauchcreme', 13),
(190, 'beilegen', 'img/food-delivery/restaurants/single/HummusAdem.png', '3.49', 'Humos', 13),
(191, 'beilegen', 'img/food-delivery/restaurants/single/kebaEinStückAdem.png', '1.99', 'Keba 1 Stück', 13),
(192, '0,33L', 'img/food-delivery/restaurants/single/cola.png', '1.49', 'Cola', 14),
(193, '0,33L', 'img/food-delivery/restaurants/single/fanta.png', '1.49', 'Fanta', 14),
(194, '0,33L', 'img/food-delivery/restaurants/single/sprite.png', '1.49', 'Sprite', 14),
(195, '0,2L', 'img/food-delivery/restaurants/single/ayran.png', '1.49', 'Ayran', 14),
(196, '0,25L', 'img/food-delivery/restaurants/single/tymbarksaft.png', '1.49', 'tymbarksaft', 14),
(197, '0,5L', 'img/food-delivery/restaurants/single/wasserAdem.png', '1.49', 'Wasser', 14),
(198, 'mit Pommes und Salat', 'img/food-delivery/restaurants/single/wienerSchnitzel.png', '7.99', 'Wiener Schnitzel', 15),
(199, 'mit Käse in Sahne Soße mit Pommes und Salat', 'img/food-delivery/restaurants/single/schnitzelÜberbacken.png', '8.99', 'Schnitzel überbacken', 15),
(200, 'mit Schinken Ananas und Käse in Sahne Soße mit Pommes und Salat', 'img/food-delivery/restaurants/single/schnitzelHawaii.png', '8.99', 'Schnitzel Hawaii', 15),
(201, 'mit Käse in Hackfleisch Soße mit Pommes und Salat', 'img/food-delivery/restaurants/single/schnitzelBolognese.png', '8.99', 'Schnitzel Bolognese', 15),
(202, 'in zigeuner Soße mit Pommes und Salat', 'img/food-delivery/restaurants/single/schnitzelZigeuner.png', '8.99', 'Schnitzel zigeuner', 15),
(203, 'in Champignonsosse Soßeund Salat', 'img/food-delivery/restaurants/single/schnitzelZigeuner.png', '8.99', 'Schnitzel Champignon', 15),
(204, 'in Champignon jägersosse Soße mit Pommes und Salat', 'img/food-delivery/restaurants/single/jagerschnitzel.png', '8.99', 'Jäger Schnitzel', 15),
(205, 'Hähnchen Brust Filet paniert mit Mayonnaise und crespi Soße Salat ', 'img/food-delivery/restaurants/single/sandwichCrespi.png', '4.99', 'Sandwich Crespi', 15),
(206, 'Hähnchen Brust Filet paniert scharf mit Mayonnaise Zanger Soße, Salat, Käse', 'img/food-delivery/restaurants/single/sandwichZanger.png', '4.99', 'Sandwich Zanger', 15),
(207, 'Hähnchen Brust Filet paniert mit Mayonnaise Salat ', 'img/food-delivery/restaurants/single/scaloppeSandwich.png', '4.99', ' Scaloppe Sandwich', 15),
(208, 'Hähnchen Burger oder Fleisch Burger mit Barbecue Soße sauergurken, Tomaten, Zwiebeln, Käse', 'img/food-delivery/restaurants/single/Cheeseburger.png', '4.99', 'Cheeseburger oder Chickenburger', 15),
(209, 'Hähnchenleber mit Zwiebeln Paprika in sesambrot Knoblauchcreme  Tomaten, Salat', 'img/food-delivery/restaurants/single/hähnchenleberSandwich.png', '4.49', 'Hähnchenleber Sandwich', 15),
(210, 'Hähnchen streifen mit Paprika, Zwiebeln, Chamignons in sesambrot , Käse', 'img/food-delivery/restaurants/single/fahitaSandwich.png', '5.49', ' Fahita Sandwich', 15),
(211, 'Hähnchen streifen ,Schwarzkümmel Kern in sesambrot', 'img/food-delivery/restaurants/single/francescoSandwich.png', '5.49', ' Francesco Sandwich', 15),
(212, 'Hähnchen streifen mit Paprika, Zwiebeln, Mais in sesambrot mit scharf Soße, Käse', 'img/food-delivery/restaurants/single/mexikanischerSandwich.png', '5.49', ' Mexikanischer Sandwich', 15),
(213, 'Hähnchen Filet mit Crespi Mischung und Pommes ', 'img/food-delivery/restaurants/single/crespiTeller.png', '7.49', ' Crespi Teller', 15),
(214, 'Hähnchen Filet mit Zanger Mischung und zanger Soße, Knoblauchcreme,Nudeln und Pommes ', 'img/food-delivery/restaurants/single/zangerTeller.png', '7.49', ' Zanger Teller', 15),
(215, 'Hähnchen Filet mit Scaloppe Mischung und zanger Soße, Käse, Knoblauchcreme, kolnslo salat, verschiedene eingelegten Gemüße und Pommes ', 'img/food-delivery/restaurants/single/scaloppeTeller.png', '7.49', ' Scaloppe Teller', 15),
(216, 'Hähnchenleber mit Zwiebeln und eingelegten Gemüße und Kartoffeln', 'img/food-delivery/restaurants/single/hähnchenLeberTeller.png', '6.99', ' Hähnchen Leber Teller', 15),
(217, 'Hähnchen streifen mit Zwiebeln und Paprika, verschiedene eingelegten Gemüße', 'img/food-delivery/restaurants/single/fahitaTellerAdem.png', '7.49', ' Fahita Teller', 15),
(218, 'in Nuss-Panade', 'img/food-delivery/restaurants/single/vegiSchnitzel.png', '7.49', ' Vegi Schnitzel', 15),
(219, 'Tacos mit Hähnchen streifen, Mais, Kümmelkerne,verschiedene Gemüße ', 'img/food-delivery/restaurants/single/tacosMitPaprika.png', '7.49', 'Tacos', 15);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `restaurant`
--

CREATE TABLE `restaurant` (
  `id` bigint(20) NOT NULL,
  `restaurant_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `restaurant`
--

INSERT INTO `restaurant` (`id`, `restaurant_name`) VALUES
(1, 'Sham-Bistro'),
(2, 'Pizzeria Adem');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `shopping_cart`
--

CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `shopping_cart`
--

INSERT INTO `shopping_cart` (`id`, `total_price`) VALUES
(1, 7.7),
(2, 6.050000000000001),
(3, 12),
(4, 9.99),
(5, 0),
(6, 4.98),
(7, 0),
(8, 0),
(9, 4.49),
(10, 0),
(11, 3.49),
(12, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `shopping_cart_items`
--

CREATE TABLE `shopping_cart_items` (
  `shopping_cart_id` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `shopping_cart_items`
--

INSERT INTO `shopping_cart_items` (`shopping_cart_id`, `items_id`) VALUES
(1, 5),
(1, 30),
(2, 6),
(2, 41),
(3, 3),
(3, 7),
(4, 28),
(6, 1),
(6, 197),
(9, 59),
(11, 5);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `account_status` varchar(255) DEFAULT NULL,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(35) NOT NULL,
  `last_name` varchar(35) NOT NULL,
  `password` varchar(255) NOT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `shopping_cart_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`id`, `account_status`, `dob`, `email`, `first_name`, `last_name`, `password`, `payment_method`, `phone`, `address_id`, `shopping_cart_id`) VALUES
(1, 'USER', '2021-07-06', 'test@test.de', 'Max', 'Müller', '$2a$10$sRI.NtqwKXjjhHg/fdMNWeS29J/ONC6Har1mH/c8jwKzWeyXvsrVS', 'PAYPAL', '012345678912', 1, 8),
(2, 'USER', '2010-10-10', '1234@gmail.com', 'jamel', 'ans', '$2a$10$VODiCaTr81FPpQbrr0Yneut1u2aSUFQbM6KjyIMoOePsBFTpRNWSm', NULL, '015779891331', 2, 5),
(3, 'USER', '1996-01-01', 'mohammad.assaf@fh-erfurt.de', 'Mohammad', 'Assaf', '$2a$10$3728egpXYR8gOP7ijpNXpewLZA0bYjXFYIZv3N4ShmTKKmReMQp22', NULL, '015779891331', 3, 7),
(4, 'USER', '1992-08-25', 'george.wakji@fh-erfurt.de', 'George', 'Wakji', '$2a$10$LkZOMrY648IWe8Ro1Q40FeTAbJi6iOYKAopJbEVzwJAgq1JxZylOy', NULL, '46846545646', 4, 9),
(5, 'USER', '1995-07-13', 'assafjuma1@gmail.com', 'Juma', 'Assaf', '$2a$10$ehTp0WMsFemyODTJB61MNe2Lwc5.mNS4nH5FnAe2t0cHljD5kKWyi', NULL, '017660921025', 5, 10),
(6, 'USER', '2000-01-01', 'Testerst@gmail.com', 'Test', 'erst', '$2a$10$3N.UARmiFuY/vaAk876HEu9UQQQBHXOIZhcGxohYCmK2B.hB755Z.', 'CREDITCARD', '11111111111', 6, 12);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp6n44aqw5n74qc4f1d6eyqgha` (`restaurant_id`);

--
-- Indizes für die Tabelle `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKag8ppnkjvx255gj7lm3m18wkj` (`payment_id`),
  ADD KEY `FKh0uue95ltjysfmkqb5abgk7tj` (`shipping_address_id`),
  ADD KEY `FKmxs9847mc5i8gyrkw6qp7krv9` (`shoppingcart_id`),
  ADD KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`);

--
-- Indizes für die Tabelle `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Indizes für die Tabelle `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `shopping_cart_items`
--
ALTER TABLE `shopping_cart_items`
  ADD KEY `FK6nk3ebvoommy2tdb5oiod1rph` (`items_id`),
  ADD KEY `FKn4ocuqbcv64d0pvyhv863l1y5` (`shopping_cart_id`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD KEY `FKddefmvbrws3hvl5t0hnnsv8ox` (`address_id`),
  ADD KEY `FK47sl5t5w02wtg9lg2f6iqopnn` (`shopping_cart_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `address`
--
ALTER TABLE `address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT für Tabelle `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `payment`
--
ALTER TABLE `payment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220;

--
-- AUTO_INCREMENT für Tabelle `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `shopping_cart`
--
ALTER TABLE `shopping_cart`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `FKp6n44aqw5n74qc4f1d6eyqgha` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`);

--
-- Constraints der Tabelle `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKag8ppnkjvx255gj7lm3m18wkj` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  ADD CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKh0uue95ltjysfmkqb5abgk7tj` FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKmxs9847mc5i8gyrkw6qp7krv9` FOREIGN KEY (`shoppingcart_id`) REFERENCES `shopping_cart` (`id`);

--
-- Constraints der Tabelle `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints der Tabelle `shopping_cart_items`
--
ALTER TABLE `shopping_cart_items`
  ADD CONSTRAINT `FK6nk3ebvoommy2tdb5oiod1rph` FOREIGN KEY (`items_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKn4ocuqbcv64d0pvyhv863l1y5` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_cart` (`id`);

--
-- Constraints der Tabelle `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK47sl5t5w02wtg9lg2f6iqopnn` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_cart` (`id`),
  ADD CONSTRAINT `FKddefmvbrws3hvl5t0hnnsv8ox` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
