-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 16, 2020 lúc 01:52 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlcuahanggiaydb`
--
CREATE DATABASE IF NOT EXISTS `qlcuahanggiaydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `qlcuahanggiaydb`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblchitiethd`
--

DROP TABLE IF EXISTS `tblchitiethd`;
CREATE TABLE `tblchitiethd` (
  `Magiay` varchar(20) NOT NULL,
  `MaHD` varchar(20) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaBan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblchitiethd`
--

INSERT INTO `tblchitiethd` (`Magiay`, `MaHD`, `SoLuong`, `GiaBan`) VALUES
('SP1', 'HD001', 1, 100),
('SP1', 'HD004', 1, 100),
('SP1', 'HD007', 8, 100),
('SP1', 'HD010', 1, 150),
('SP1', 'HD012', 1, 150),
('SP2', 'HD003', 1, 150),
('SP2', 'HD004', 1, 150),
('SP2', 'HD007', 8, 150),
('SP2', 'HD012', 1, 200),
('SP3', 'HD001', 1, 200),
('SP3', 'HD003', 1, 200),
('SP3', 'HD004', 2, 200),
('SP3', 'HD007', 6, 200),
('SP4', 'HD002', 1, 250),
('SP4', 'HD003', 1, 250),
('SP4', 'HD004', 2, 250),
('SP4', 'HD006', 1, 250),
('SP4', 'HD007', 5, 250),
('SP5', 'HD002', 1, 300),
('SP5', 'HD006', 3, 100),
('SP5', 'HD007', 6, 300),
('SP5', 'HD008', 3, 350),
('SP5', 'HD011', 1, 350),
('SP6', 'HD005', 2, 350),
('SP6', 'HD007', 8, 350);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblchitietkm`
--

DROP TABLE IF EXISTS `tblchitietkm`;
CREATE TABLE `tblchitietkm` (
  `MaGiay` varchar(20) NOT NULL,
  `MaKM` varchar(20) NOT NULL,
  `TiLeKM` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblchitietkm`
--

INSERT INTO `tblchitietkm` (`MaGiay`, `MaKM`, `TiLeKM`) VALUES
('SP1', 'KM1', 0.1),
('SP1', 'KM5', 0.5),
('SP1', 'KM6', 0.5),
('SP2', 'KM1', 0.1),
('SP2', 'KM2', 0.2),
('SP2', 'KM5', 0.5),
('SP2', 'KM6', 0.5),
('SP3', 'KM1', 0.1),
('SP3', 'KM4', 0.4),
('SP3', 'KM5', 0.5),
('SP3', 'KM6', 0.3),
('SP4', 'KM3', 0.3),
('SP4', 'KM5', 0.5),
('SP5', 'KM4', 0.4),
('SP5', 'KM5', 0.5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblchitietpn`
--

DROP TABLE IF EXISTS `tblchitietpn`;
CREATE TABLE `tblchitietpn` (
  `MaGiay` varchar(20) NOT NULL,
  `MaPN` varchar(20) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaNhap` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblchitietpn`
--

INSERT INTO `tblchitietpn` (`MaGiay`, `MaPN`, `SoLuong`, `GiaNhap`) VALUES
('SP1', 'PN001', 10, 50),
('SP2', 'PN001', 10, 100),
('SP3', 'PN001', 10, 150),
('SP4', 'PN001', 10, 200),
('SP5', 'PN001', 10, 250),
('SP6', 'PN001', 10, 300),
('SP5', 'PN002', 10, 300),
('SP1', 'PN003', 3, 100),
('SP2', 'PN003', 3, 150),
('SP3', 'PN003', 3, 200),
('SP4', 'PN003', 3, 250);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblhoadon`
--

DROP TABLE IF EXISTS `tblhoadon`;
CREATE TABLE `tblhoadon` (
  `MaHD` varchar(20) NOT NULL,
  `MaNV` varchar(20) NOT NULL,
  `MaKH` varchar(20) NOT NULL,
  `MaKM` varchar(20) NOT NULL,
  `NgayBan` varchar(20) NOT NULL,
  `TongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblhoadon`
--

INSERT INTO `tblhoadon` (`MaHD`, `MaNV`, `MaKH`, `MaKM`, `NgayBan`, `TongTien`) VALUES
('HD001', 'admin', 'KH1', 'KM2', '08 Jun 2020', 300),
('HD002', 'admin', 'KH2', 'KM6', '08 Jun 2020', 550),
('HD003', 'admin', 'KH5', 'KM4', '08 Jun 2020', 520),
('HD004', 'admin', 'KH6', 'KM3', '08 Jun 2020', 1000),
('HD005', 'admin', 'KH3', 'KM3', '08 Jun 2020', 700),
('HD006', 'admin', 'KH1', 'KM2', '08 Jun 2020', 550),
('HD007', 'admin', 'KH2', 'KM6', '08 Jun 2020', 7690),
('HD008', 'admin', 'KH1', 'KM6', '08 Jun 2020', 1050),
('HD010', 'admin', 'KH6', 'KM6', '13 Jun 2020', 75),
('HD011', 'admin', 'KH6', 'KM6', '13 Jun 2020', 350),
('HD012', 'admin', 'KH4', 'KM6', '14 Jun 2020', 175);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblkhachhang`
--

DROP TABLE IF EXISTS `tblkhachhang`;
CREATE TABLE `tblkhachhang` (
  `MaKH` varchar(20) NOT NULL,
  `Ho` varchar(20) NOT NULL,
  `Ten` varchar(20) NOT NULL,
  `GioiTinh` varchar(20) NOT NULL,
  `DiaChi` varchar(40) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Loai` varchar(20) NOT NULL,
  `TongChiTieu` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblkhachhang`
--

INSERT INTO `tblkhachhang` (`MaKH`, `Ho`, `Ten`, `GioiTinh`, `DiaChi`, `Email`, `Loai`, `TongChiTieu`) VALUES
('KH1', 'Nguyễn Tuấn', 'Anh', 'Nam', '123321123321 địa chỉ', 'nguyenanh@gmail.com', 'vip', 58939.3),
('KH2', 'Tăng Chí', 'Chung', 'Nam', '12332 địa chỉ', 'chungtang@gmail.com', 'đặc biệt', 0),
('KH3', 'Võ Văn Gia', 'Bảo', 'Nam', '13321 địa chỉ', 'baovo@gmail.com', 'vip', 98495),
('KH4', 'Nguyễn Đào', 'Kim', 'Nữ', '1231 địa chỉ', 'khoeghe@gmail.com', 'bình thường', 53576),
('KH5', 'Trần Lê Anh', 'Đào', 'Nữ', '23213 địa chỉ', 'daotran@gmail.com', 'bình thường', 1150),
('KH6', 'Nguyễn Văn', 'An', 'Nam', 'địa chỉ', 'abc@gmail.com', 'bình thường', 6740);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblkhuyenmai`
--

DROP TABLE IF EXISTS `tblkhuyenmai`;
CREATE TABLE `tblkhuyenmai` (
  `MaKM` varchar(20) NOT NULL,
  `TenChuongTrinh` varchar(40) NOT NULL,
  `LoaiChuongTrinh` varchar(20) NOT NULL,
  `DieuKien` varchar(20) NOT NULL,
  `NgayBatDau` varchar(20) NOT NULL,
  `NgayKetThuc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblkhuyenmai`
--

INSERT INTO `tblkhuyenmai` (`MaKM`, `TenChuongTrinh`, `LoaiChuongTrinh`, `DieuKien`, `NgayBatDau`, `NgayKetThuc`) VALUES
('KM1', 'Mùa hè xanh', 'Loại 1', 'vip', '13 May 2020', '15 May 2020'),
('KM2', 'Ngày vàng', 'Loại 3', 'đặc biệt', '01 Jun 2020', '08 Jun 2020'),
('KM3', 'Ngày trở về', 'Loại 2', 'vip', '08 Jun 2020', '17 Jun 2020'),
('KM4', 'Mùa đông lạnh giá', 'Loại 3', 'bình thường', '01 Jun 2020', '17 Jun 2020'),
('KM5', 'Ngày mới', 'Loại 3', 'bình thường', '01 Jan 2020', '01 Jan 2030'),
('KM6', 'admin', 'Loại 1', 'bình thường', '1 Jun 2020', '30 Jun 2020');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblloai`
--

DROP TABLE IF EXISTS `tblloai`;
CREATE TABLE `tblloai` (
  `Maloai` varchar(20) NOT NULL,
  `Tenloai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblloai`
--

INSERT INTO `tblloai` (`Maloai`, `Tenloai`) VALUES
('1', 'sneaker'),
('2', 'Running'),
('3', 'Fashion'),
('4', 'Basketball'),
('5', 'Soccer');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblmausac`
--

DROP TABLE IF EXISTS `tblmausac`;
CREATE TABLE `tblmausac` (
  `Mamau` varchar(20) NOT NULL,
  `Tenmau` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblmausac`
--

INSERT INTO `tblmausac` (`Mamau`, `Tenmau`) VALUES
('BLK', 'Black'),
('BLU', 'Blue'),
('GR', 'Green'),
('ORG', 'Orange'),
('WT', 'White');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnhacungcap`
--

DROP TABLE IF EXISTS `tblnhacungcap`;
CREATE TABLE `tblnhacungcap` (
  `MaNCC` varchar(20) NOT NULL,
  `TenNCC` varchar(20) NOT NULL,
  `DiaChi` varchar(40) NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblnhacungcap`
--

INSERT INTO `tblnhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `Email`) VALUES
('NCC1', 'Rồng Thiên', '123 Ra đường bị la,P ABC,TP HN', 'rongthien619@gmail.com'),
('NCC2', 'Trời Đỏ', '456 kế bên nhà 123', 'sunred916@gmail.com'),
('NCC3', 'Rực lửa', '135 là số lẻ không phải số lẽ', '246@gmail.com'),
('NCC4', 'Bước Nhảy', '246 không phải là số chẳn mà là số chẵn', 'jumpandjump@gmail.com'),
('NCC5', 'Tầm xa', '3 là số nguyên tố', '357@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnhanvien`
--

DROP TABLE IF EXISTS `tblnhanvien`;
CREATE TABLE `tblnhanvien` (
  `MaNV` varchar(20) NOT NULL,
  `Ho` varchar(30) NOT NULL,
  `Ten` varchar(10) NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `DienThoai` int(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Luong` int(20) NOT NULL,
  `ChucVu` varchar(20) NOT NULL,
  `Anh` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblnhanvien`
--

INSERT INTO `tblnhanvien` (`MaNV`, `Ho`, `Ten`, `GioiTinh`, `DiaChi`, `DienThoai`, `Email`, `Luong`, `ChucVu`, `Anh`) VALUES
('admin', 'Quản trị', 'Viên', 'Nam', '123 Đi la cà,P đi,Q Ăn, TPHCM', 1001011101, 'admin@admin.vn', 999999, 'Quản trị viên', 'boy 4'),
('id1', 'Nguyễn Thị', 'Thư', 'Nữ', '123 Nguyện Văn A,P.A, Q.A,TPHCM', 1234567890, 'nguyenvanan@gamil.co', 1000, 'Thư ký', 'girl 1'),
('id2', 'Tàu Văn', 'Phà', 'Nam', '123 Lạc Văn Biển,P.A, Q.A,TPHCM', 1239876540, 'taunhobien@gamil.com', 800, 'Kiểm tra hàng hóa', 'boy 2'),
('id3', 'Trần', 'Dần', 'Nam', '123 A,P LA,Q DHA,TpHCM', 2147483647, 'trandan@gmail.com', 300, 'Nhập Hàng', 'boy 3'),
('id4', 'Lê Văn', 'Hoàng', 'Nữ', '3 ABCD,P LA,Q DHA,TpHCM', 41234111, 'levanhoang@gmail.com', 8000, 'Khuyến Mãi', 'girl 3'),
('id5', 'Nguyễn Thị Lê', 'Kim', 'Nữ', '13 An Mà,P LA,Q DHA,TpHCM', 123456789, 'nguyenthilekim@gmail', 900, 'Hóa Đơn', 'girl 2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblphieunhap`
--

DROP TABLE IF EXISTS `tblphieunhap`;
CREATE TABLE `tblphieunhap` (
  `MaPN` varchar(20) NOT NULL,
  `MaNCC` varchar(20) NOT NULL,
  `MaNV` varchar(20) NOT NULL,
  `NgayNhap` varchar(20) NOT NULL,
  `TongTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblphieunhap`
--

INSERT INTO `tblphieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`, `TongTien`) VALUES
('PN001', 'NCC1', 'admin', '08 Jun 2020', 10500),
('PN002', 'NCC2', 'admin', '08 Jun 2020', 3000),
('PN003', 'NCC3', 'admin', '11 Jun 2020', 2100);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblsanpham`
--

DROP TABLE IF EXISTS `tblsanpham`;
CREATE TABLE `tblsanpham` (
  `Magiay` varchar(20) NOT NULL,
  `Tengiay` varchar(20) NOT NULL,
  `Soluong` int(10) NOT NULL,
  `Gia` int(10) NOT NULL,
  `Size` int(10) NOT NULL,
  `Doituongsd` varchar(20) NOT NULL,
  `Chatlieu` varchar(20) NOT NULL,
  `Maloai` varchar(20) NOT NULL,
  `Maxx` varchar(20) NOT NULL,
  `Mamau` varchar(20) NOT NULL,
  `Mathuonghieu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblsanpham`
--

INSERT INTO `tblsanpham` (`Magiay`, `Tengiay`, `Soluong`, `Gia`, `Size`, `Doituongsd`, `Chatlieu`, `Maloai`, `Maxx`, `Mamau`, `Mathuonghieu`) VALUES
('SP1', 'SuperStar', 1, 150, 29, 'Nam', 'Vải', '3', 'US', 'WT', 'AD'),
('SP2', 'Dép tổ ong', 2, 200, 40, 'Nam', 'Vải', '2', 'VN', 'BLK', 'TO'),
('SP3', 'Giày tàng hình', 3, 250, 40, 'Tất cả', 'NanoGen', '3', 'US', 'WT', 'BT'),
('SP4', 'Ngàn sao', 3, 50, 35, 'Nữ', 'Nilon', '5', 'CN', 'BLU', 'NK'),
('SP5', 'Guốc', 6, 350, 34, 'Nữ', 'Vải', '3', 'ID', 'GR', 'NK'),
('SP6', 'Dép Lê', 0, 350, 40, 'Nam', 'Cây cỏ', '3', 'ID', 'ORG', 'BT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbltaikhoan`
--

DROP TABLE IF EXISTS `tbltaikhoan`;
CREATE TABLE `tbltaikhoan` (
  `tendangnhap` varchar(10) NOT NULL,
  `matkhau` varchar(20) NOT NULL,
  `capbac` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbltaikhoan`
--

INSERT INTO `tbltaikhoan` (`tendangnhap`, `matkhau`, `capbac`) VALUES
('admin', 'admin', 1),
('id1', '123', 2),
('id2', '123', 3),
('id3', '123', 4),
('id4', '123', 5),
('id5', '123', 6);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblthuonghieu`
--

DROP TABLE IF EXISTS `tblthuonghieu`;
CREATE TABLE `tblthuonghieu` (
  `Mathuonghieu` varchar(20) NOT NULL,
  `Tenthuonghieu` varchar(30) NOT NULL,
  `Diachi` varchar(40) NOT NULL,
  `Email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblthuonghieu`
--

INSERT INTO `tblthuonghieu` (`Mathuonghieu`, `Tenthuonghieu`, `Diachi`, `Email`) VALUES
('@@', '@@@@', 'England', '@@@gmial.com'),
('AD', 'Adidas', 'USA', 'adidas@gmail.com'),
('BT', 'Bitis', 'VietNam', 'bitis@gmial.com'),
('NK', 'Nike', 'USA', 'nike@gmail.com'),
('TO', 'ToOng', 'VietNam', 'toong@gmial.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblxuatxu`
--

DROP TABLE IF EXISTS `tblxuatxu`;
CREATE TABLE `tblxuatxu` (
  `Maxx` varchar(20) NOT NULL,
  `Tennuoc` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblxuatxu`
--

INSERT INTO `tblxuatxu` (`Maxx`, `Tennuoc`) VALUES
('CN', 'China'),
('ID', 'Indonesia'),
('UK', 'United Kingdom'),
('US', 'USA'),
('VN', 'VietNam');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  ADD PRIMARY KEY (`Magiay`,`MaHD`),
  ADD KEY `FKMaHD` (`MaHD`),
  ADD KEY `FKMaGiayHD` (`Magiay`);

--
-- Chỉ mục cho bảng `tblchitietkm`
--
ALTER TABLE `tblchitietkm`
  ADD PRIMARY KEY (`MaGiay`,`MaKM`),
  ADD KEY `FKMaGiayKM` (`MaGiay`),
  ADD KEY `FKMaKMCTKM` (`MaKM`);

--
-- Chỉ mục cho bảng `tblchitietpn`
--
ALTER TABLE `tblchitietpn`
  ADD PRIMARY KEY (`MaPN`,`MaGiay`),
  ADD KEY `FKMaPN` (`MaPN`),
  ADD KEY `FKMaGiayPN` (`MaGiay`);

--
-- Chỉ mục cho bảng `tblhoadon`
--
ALTER TABLE `tblhoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `FKMaNVHD` (`MaNV`),
  ADD KEY `FKMaKMHD` (`MaKM`),
  ADD KEY `FKMaKHHD` (`MaKH`);

--
-- Chỉ mục cho bảng `tblkhachhang`
--
ALTER TABLE `tblkhachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `tblkhuyenmai`
--
ALTER TABLE `tblkhuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `tblloai`
--
ALTER TABLE `tblloai`
  ADD PRIMARY KEY (`Maloai`);

--
-- Chỉ mục cho bảng `tblmausac`
--
ALTER TABLE `tblmausac`
  ADD PRIMARY KEY (`Mamau`);

--
-- Chỉ mục cho bảng `tblnhacungcap`
--
ALTER TABLE `tblnhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `tblnhanvien`
--
ALTER TABLE `tblnhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `tblphieunhap`
--
ALTER TABLE `tblphieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `FKMaNCC` (`MaNCC`),
  ADD KEY `FKMaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `tblsanpham`
--
ALTER TABLE `tblsanpham`
  ADD PRIMARY KEY (`Magiay`),
  ADD KEY `FKMaXuatXu` (`Maxx`),
  ADD KEY `FKMaThuonghieu` (`Mathuonghieu`),
  ADD KEY `FKMaMau` (`Mamau`),
  ADD KEY `FKMaLoai` (`Maloai`);

--
-- Chỉ mục cho bảng `tbltaikhoan`
--
ALTER TABLE `tbltaikhoan`
  ADD PRIMARY KEY (`tendangnhap`);

--
-- Chỉ mục cho bảng `tblthuonghieu`
--
ALTER TABLE `tblthuonghieu`
  ADD PRIMARY KEY (`Mathuonghieu`);

--
-- Chỉ mục cho bảng `tblxuatxu`
--
ALTER TABLE `tblxuatxu`
  ADD PRIMARY KEY (`Maxx`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  ADD CONSTRAINT `FKMaHD` FOREIGN KEY (`MaHD`) REFERENCES `tblhoadon` (`MaHD`),
  ADD CONSTRAINT `FKMagGiayHD` FOREIGN KEY (`Magiay`) REFERENCES `tblsanpham` (`Magiay`);

--
-- Các ràng buộc cho bảng `tblchitietkm`
--
ALTER TABLE `tblchitietkm`
  ADD CONSTRAINT `FKMaGiayKM` FOREIGN KEY (`MaGiay`) REFERENCES `tblsanpham` (`Magiay`),
  ADD CONSTRAINT `FKMaKMCTKM` FOREIGN KEY (`MaKM`) REFERENCES `tblkhuyenmai` (`MaKM`);

--
-- Các ràng buộc cho bảng `tblchitietpn`
--
ALTER TABLE `tblchitietpn`
  ADD CONSTRAINT `FKMaGiayPN` FOREIGN KEY (`MaGiay`) REFERENCES `tblsanpham` (`Magiay`),
  ADD CONSTRAINT `FKMaPN` FOREIGN KEY (`MaPN`) REFERENCES `tblphieunhap` (`MaPN`);

--
-- Các ràng buộc cho bảng `tblhoadon`
--
ALTER TABLE `tblhoadon`
  ADD CONSTRAINT `FKMaKHHD` FOREIGN KEY (`MaKH`) REFERENCES `tblkhachhang` (`MaKH`),
  ADD CONSTRAINT `FKMaKMHD` FOREIGN KEY (`MaKM`) REFERENCES `tblkhuyenmai` (`MaKM`),
  ADD CONSTRAINT `FKMaNVHD` FOREIGN KEY (`MaNV`) REFERENCES `tblnhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `tblphieunhap`
--
ALTER TABLE `tblphieunhap`
  ADD CONSTRAINT `FKMaNCC` FOREIGN KEY (`MaNCC`) REFERENCES `tblnhacungcap` (`MaNCC`),
  ADD CONSTRAINT `FKMaNV` FOREIGN KEY (`MaNV`) REFERENCES `tblnhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `tblsanpham`
--
ALTER TABLE `tblsanpham`
  ADD CONSTRAINT `FKMaLoai` FOREIGN KEY (`Maloai`) REFERENCES `tblloai` (`Maloai`),
  ADD CONSTRAINT `FKMaMau` FOREIGN KEY (`Mamau`) REFERENCES `tblmausac` (`Mamau`),
  ADD CONSTRAINT `FKMaThuonghieu` FOREIGN KEY (`Mathuonghieu`) REFERENCES `tblthuonghieu` (`Mathuonghieu`),
  ADD CONSTRAINT `FKMaXuatXu` FOREIGN KEY (`Maxx`) REFERENCES `tblxuatxu` (`Maxx`);

--
-- Các ràng buộc cho bảng `tbltaikhoan`
--
ALTER TABLE `tbltaikhoan`
  ADD CONSTRAINT `FKMaNVTK` FOREIGN KEY (`tendangnhap`) REFERENCES `tblnhanvien` (`MaNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
