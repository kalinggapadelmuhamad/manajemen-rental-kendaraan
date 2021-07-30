-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2021 at 12:26 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCs` int(11) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `jenisKelamin` enum('Laki - Laki','Perempuan') NOT NULL,
  `alamat` text NOT NULL,
  `noHandphone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCs`, `nama`, `jenisKelamin`, `alamat`, `noHandphone`) VALUES
(1, 'Kalingga Padel Muhamad', 'Laki - Laki', 'JL Kimaja Gg Cempaka No 43, Way Halim - Bandar Lampung', '082175572310'),
(2, 'Ismail Marzuki', 'Laki - Laki', 'Teluk Betung No 32', '082175573240'),
(3, 'M Fivo Arnande', 'Laki - Laki', 'Teluk Betung No 30', '082178876540');

-- --------------------------------------------------------

--
-- Table structure for table `denda`
--

CREATE TABLE `denda` (
  `idDenda` int(11) NOT NULL,
  `namaDenda` varchar(25) NOT NULL,
  `hargaDenda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `denda`
--

INSERT INTO `denda` (`idDenda`, `namaDenda`, `hargaDenda`) VALUES
(1, 'Telat Pengembalian', 200000),
(2, 'Rusak Ringan', 700000),
(3, 'Rusak Sedang', 1200000),
(4, 'Rusak Berat', 3000000),
(6, 'Tidak Ada', 0);

-- --------------------------------------------------------

--
-- Stand-in structure for view `fkembali`
-- (See below for the actual view)
--
CREATE TABLE `fkembali` (
`noTransaksi` int(11)
,`tglKembali` date
,`Petugas` varchar(25)
,`Customer` varchar(25)
,`NoPinjam` int(11)
,`noPol` varchar(12)
,`Nama` varchar(20)
,`jenis` varchar(20)
,`hargaSewa` int(10)
,`namaDenda` varchar(25)
,`Total` int(15)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `kembali`
-- (See below for the actual view)
--
CREATE TABLE `kembali` (
`noTransaksi` int(11)
,`tglKembali` date
,`Petugas` int(11)
,`Customer` int(11)
,`NoPinjam` int(11)
,`noPol` varchar(12)
,`Nama` varchar(20)
,`jenis` varchar(20)
,`hargaSewa` int(10)
,`namaDenda` varchar(25)
,`Total` int(15)
);

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `noPol` varchar(12) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `merek` varchar(20) NOT NULL,
  `hargaSewa` int(10) NOT NULL,
  `status` enum('Tersedia','Tidak Tersedia') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`noPol`, `jenis`, `merek`, `hargaSewa`, `status`) VALUES
('BE254576YK', 'Mini Bus', 'Toyota Avanza 2018', 500000, 'Tersedia'),
('BE77756GG', 'Mini Bus', 'Toyota Avanza 2020', 700000, 'Tidak Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `noTransaksi` int(11) NOT NULL,
  `tglPeminjaman` date NOT NULL,
  `idPetugas` int(11) NOT NULL,
  `idCs` int(11) NOT NULL,
  `noPol` varchar(12) NOT NULL,
  `lamaPinjam` int(2) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`noTransaksi`, `tglPeminjaman`, `idPetugas`, `idCs`, `noPol`, `lamaPinjam`, `harga`) VALUES
(7, '2021-07-27', 1, 1, 'BE254576YK', 1, 500000),
(8, '2021-07-27', 2, 1, 'BE77756GG', 1, 700000),
(9, '2021-07-26', 1, 3, 'BE254576YK', 1, 700000);

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `noTransaksi` int(11) NOT NULL,
  `tglKembali` date NOT NULL,
  `idPetugas` int(11) NOT NULL,
  `idCs` int(11) NOT NULL,
  `noPol` varchar(12) NOT NULL,
  `noTrx` int(11) NOT NULL,
  `idDenda` int(11) NOT NULL,
  `harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`noTransaksi`, `tglKembali`, `idPetugas`, `idCs`, `noPol`, `noTrx`, `idDenda`, `harga`) VALUES
(4, '2021-07-28', 1, 1, 'BE254576YK', 7, 6, 500000),
(5, '2021-07-29', 2, 1, 'BE77756GG', 8, 1, 700000),
(6, '2021-07-28', 1, 3, 'BE254576YK', 9, 6, 700000);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `idPetugas` int(11) NOT NULL,
  `namaPetugas` varchar(25) NOT NULL,
  `jenisKelamin` enum('Laki - Laki','Perempuan') NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `gaji` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`idPetugas`, `namaPetugas`, `jenisKelamin`, `jabatan`, `gaji`, `username`, `password`) VALUES
(1, 'Indri Mada Aprilia', 'Perempuan', 'CEO', 5000000, 'indri', 'indri'),
(2, 'admin', 'Laki - Laki', 'CEO', 3000000, 'admin', 'admin'),
(5, 'cs1', 'Perempuan', 'CS', 3000000, 'cs1', 'cs1');

-- --------------------------------------------------------

--
-- Stand-in structure for view `pinjam`
-- (See below for the actual view)
--
CREATE TABLE `pinjam` (
`noTransaksi` int(11)
,`tglPeminjaman` date
,`lamaPinjam` int(2)
,`namaPetugas` varchar(25)
,`nama` varchar(25)
,`noPol` varchar(12)
,`merek` varchar(20)
,`jenis` varchar(20)
,`hargaSewa` int(10)
,`total` int(11)
);

-- --------------------------------------------------------

--
-- Structure for view `fkembali`
--
DROP TABLE IF EXISTS `fkembali`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `fkembali`  AS SELECT `pengembalian`.`noTransaksi` AS `noTransaksi`, `pengembalian`.`tglKembali` AS `tglKembali`, `petugas`.`namaPetugas` AS `Petugas`, `customer`.`nama` AS `Customer`, `pengembalian`.`noTrx` AS `NoPinjam`, `pengembalian`.`noPol` AS `noPol`, `kendaraan`.`merek` AS `Nama`, `kendaraan`.`jenis` AS `jenis`, `kendaraan`.`hargaSewa` AS `hargaSewa`, `denda`.`namaDenda` AS `namaDenda`, `pengembalian`.`harga` AS `Total` FROM ((((`pengembalian` join `petugas`) join `customer`) join `kendaraan`) join `denda`) WHERE `petugas`.`idPetugas` = `pengembalian`.`idPetugas` AND `customer`.`idCs` = `pengembalian`.`idCs` AND `kendaraan`.`noPol` = `pengembalian`.`noPol` AND `denda`.`idDenda` = `pengembalian`.`idDenda` ;

-- --------------------------------------------------------

--
-- Structure for view `kembali`
--
DROP TABLE IF EXISTS `kembali`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `kembali`  AS SELECT `pengembalian`.`noTransaksi` AS `noTransaksi`, `pengembalian`.`tglKembali` AS `tglKembali`, `petugas`.`idPetugas` AS `Petugas`, `customer`.`idCs` AS `Customer`, `pengembalian`.`noTrx` AS `NoPinjam`, `pengembalian`.`noPol` AS `noPol`, `kendaraan`.`merek` AS `Nama`, `kendaraan`.`jenis` AS `jenis`, `kendaraan`.`hargaSewa` AS `hargaSewa`, `denda`.`namaDenda` AS `namaDenda`, `pengembalian`.`harga` AS `Total` FROM ((((`pengembalian` join `petugas`) join `customer`) join `kendaraan`) join `denda`) WHERE `petugas`.`idPetugas` = `pengembalian`.`idPetugas` AND `customer`.`idCs` = `pengembalian`.`idCs` AND `kendaraan`.`noPol` = `pengembalian`.`noPol` AND `denda`.`idDenda` = `pengembalian`.`idDenda` ;

-- --------------------------------------------------------

--
-- Structure for view `pinjam`
--
DROP TABLE IF EXISTS `pinjam`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pinjam`  AS SELECT `peminjaman`.`noTransaksi` AS `noTransaksi`, `peminjaman`.`tglPeminjaman` AS `tglPeminjaman`, `peminjaman`.`lamaPinjam` AS `lamaPinjam`, `petugas`.`namaPetugas` AS `namaPetugas`, `customer`.`nama` AS `nama`, `peminjaman`.`noPol` AS `noPol`, `kendaraan`.`merek` AS `merek`, `kendaraan`.`jenis` AS `jenis`, `kendaraan`.`hargaSewa` AS `hargaSewa`, `peminjaman`.`harga` AS `total` FROM (((`peminjaman` join `petugas`) join `customer`) join `kendaraan`) WHERE `petugas`.`idPetugas` = `peminjaman`.`idPetugas` AND `customer`.`idCs` = `peminjaman`.`idCs` AND `kendaraan`.`noPol` = `peminjaman`.`noPol` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCs`);

--
-- Indexes for table `denda`
--
ALTER TABLE `denda`
  ADD PRIMARY KEY (`idDenda`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`noPol`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`noTransaksi`),
  ADD KEY `idPetugas` (`idPetugas`),
  ADD KEY `idCs` (`idCs`),
  ADD KEY `noPol` (`noPol`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`noTransaksi`),
  ADD KEY `idDenda` (`idDenda`),
  ADD KEY `noPol` (`noPol`),
  ADD KEY `idCs` (`idCs`),
  ADD KEY `idPetugas` (`idPetugas`),
  ADD KEY `noTrx` (`noTrx`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`idPetugas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `idCs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `denda`
--
ALTER TABLE `denda`
  MODIFY `idDenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `noTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `noTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `petugas`
--
ALTER TABLE `petugas`
  MODIFY `idPetugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`idCs`) REFERENCES `customer` (`idCs`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`noPol`) REFERENCES `kendaraan` (`noPol`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`idPetugas`) REFERENCES `petugas` (`idPetugas`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`idCs`) REFERENCES `customer` (`idCs`),
  ADD CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`idPetugas`) REFERENCES `petugas` (`idPetugas`),
  ADD CONSTRAINT `pengembalian_ibfk_3` FOREIGN KEY (`idDenda`) REFERENCES `denda` (`idDenda`),
  ADD CONSTRAINT `pengembalian_ibfk_4` FOREIGN KEY (`noPol`) REFERENCES `kendaraan` (`noPol`),
  ADD CONSTRAINT `pengembalian_ibfk_5` FOREIGN KEY (`noTrx`) REFERENCES `peminjaman` (`noTransaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
