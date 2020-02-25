-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 20-02-2020 a las 12:16:16
-- Versión del servidor: 8.0.19
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dam2020`
--
CREATE DATABASE IF NOT EXISTS `dam2020` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `dam2020`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carousel`
--

CREATE TABLE `carousel` (
  `id` int NOT NULL,
  `texto` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `imagen` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `carousel`
--

INSERT INTO `carousel` (`id`, `texto`, `imagen`) VALUES
(1, 'fruta', 'https://i.picsum.photos/id/800/800/300.jpg'),
(2, 'hortaliza', 'https://i.picsum.photos/id/429/800/300.jpg'),
(3, 'legumbre', 'https://i.picsum.photos/id/270/800/300.jpg'),
(4, 'fruta', 'https://i.picsum.photos/id/271/800/300.jpg'),
(5, 'fruta', 'https://i.picsum.photos/id/400/800/300.jpg'),
(6, 'hortaliza', 'https://i.picsum.photos/id/273/800/300.jpg'),
(7, 'legumbre', 'https://i.picsum.photos/id/274/800/300.jpg'),
(8, 'fruta', 'https://i.picsum.photos/id/275/800/300.jpg'),
(9, 'fruta', 'https://i.picsum.photos/id/800/800/300.jpg'),
(10, 'hortaliza', 'https://i.picsum.photos/id/429/800/300.jpg'),
(11, 'legumbre', 'https://i.picsum.photos/id/270/800/300.jpg'),
(12, 'fruta', 'https://i.picsum.photos/id/271/800/300.jpg'),
(13, 'fruta', 'https://i.picsum.photos/id/400/800/300.jpg'),
(14, 'hortaliza', 'https://i.picsum.photos/id/273/800/300.jpg'),
(15, 'legumbre', 'https://i.picsum.photos/id/274/800/300.jpg'),
(16, 'fruta', 'https://i.picsum.photos/id/275/800/300.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `id` int NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `precio` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `clave` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`usuario`, `clave`, `mail`, `nombre`) VALUES
('admin', '1234', 'augustobrigaprofe@gmail.com', 'Pruden');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vegetales`
--

CREATE TABLE `vegetales` (
  `id` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `imagen` varchar(100) NOT NULL,
  `procedencia` varchar(100) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vegetales`
--

INSERT INTO `vegetales` (`id`, `nombre`, `categoria`, `imagen`, `procedencia`, `precio`) VALUES
(1, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(2, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(3, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(4, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(5, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(6, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(7, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(8, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(9, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(10, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(11, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(12, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(13, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(14, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(15, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55),
(16, 'Naranja', 'Fruta', 'naranja.jpg', 'Badajoz', 0.55);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `vegetales`
--
ALTER TABLE `vegetales`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `vegetales`
--
ALTER TABLE `vegetales`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
