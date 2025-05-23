USE [master]
GO
/****** Object:  Database [BanGiayChinhSuaTest3]    Script Date: 4/23/2025 10:17:01 PM ******/
CREATE DATABASE [BanGiayChinhSuaTest3]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BanGiayChinhSuaTest3', FILENAME = N'D:\GAME AND APPS\MSSQL16.MSSQLSERVER\MSSQL\DATA\BanGiayChinhSuaTest3.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BanGiayChinhSuaTest3_log', FILENAME = N'D:\GAME AND APPS\MSSQL16.MSSQLSERVER\MSSQL\DATA\BanGiayChinhSuaTest3_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BanGiayChinhSuaTest3].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ARITHABORT OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET RECOVERY FULL 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET  MULTI_USER 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BanGiayChinhSuaTest3', N'ON'
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET QUERY_STORE = ON
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BanGiayChinhSuaTest3]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varchar](255) NOT NULL,
	[roles] [varchar](10) NOT NULL,
	[hoVaTen] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[email] [varchar](200) NULL,
	[sdt] [nvarchar](50) NULL,
	[ngayDangKi] [date] NULL,
	[trangThai] [bit] NULL,
	[anhDaiDien] [nvarchar](max) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NULL,
	[passwordResetToken] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenDanhMuc] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idAccountKhachHang] [int] NULL,
	[idAccountNhanVien] [int] NULL,
	[ngayTaoDon] [datetime] NULL,
	[tongTien] [decimal](10, 2) NULL,
	[trangThai] [int] NULL,
	[sdtKhachHang] [varchar](15) NULL,
	[tenKhachhang] [nvarchar](100) NULL,
	[diaChi] [nvarchar](max) NULL,
	[idGiamGia] [int] NULL,
	[soTienSauKhiGiam] [decimal](10, 2) NULL,
	[khachTra] [decimal](10, 2) NULL,
	[hinhThucThanhToan] [bit] NULL,
	[hinhThucGiaoHang] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHangChiTiet]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHangChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idDonHang] [int] NULL,
	[idSanPham] [int] NULL,
	[soLuong] [int] NULL,
	[donGia] [decimal](10, 2) NULL,
	[thanhTien] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiamGia]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiamGia](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[giamGiaPhamTram] [decimal](5, 2) NULL,
	[giamGiaSoTien] [decimal](10, 2) NULL,
	[dieuKienApDung] [decimal](10, 2) NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[anhSanPham] [nvarchar](max) NULL,
	[tenSanPham] [nvarchar](max) NULL,
	[idSanPhamChiTiet] [int] NULL,
	[soLuong] [int] NULL,
	[donGia] [decimal](10, 2) NULL,
	[idAccountKhachhang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[id] [int] NOT NULL,
	[ngayLapHoaDon] [date] NULL,
	[idAccountKhachHang] [int] NULL,
	[idAccountNhanVien] [int] NULL,
	[tongTien] [decimal](10, 2) NULL,
	[trangThai] [int] NULL,
	[sdtKhachHang] [varchar](15) NULL,
	[tenKhachhang] [nvarchar](100) NULL,
	[diaChi] [nvarchar](max) NULL,
	[giamGiaID] [int] NULL,
	[soTienSauKhiGiam] [decimal](10, 2) NULL,
	[khachTra] [decimal](10, 2) NULL,
	[hinhThucThanhToan] [bit] NULL,
	[hinhThucGiaoHang] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idHoaDon] [int] NULL,
	[idSanPham] [int] NULL,
	[soLuong] [int] NULL,
	[donGia] [decimal](10, 2) NULL,
	[thanhTien] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachang]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachang](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maKhachHang] [nvarchar](50) NULL,
	[tenKhachHang] [nvarchar](max) NULL,
	[sdt] [varchar](15) NULL,
	[diaChi] [nvarchar](max) NULL,
	[email] [nvarchar](100) NULL,
	[ngaySinh] [date] NULL,
	[gioitinh] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichCo]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichCo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenKichCo] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tenMauSac] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maSanPham] [varchar](50) NOT NULL,
	[tenSanPham] [nvarchar](100) NULL,
	[moTa] [nvarchar](max) NULL,
	[idMauSac] [int] NULL,
	[anhSanPham] [nvarchar](max) NULL,
	[idThuongHieu] [int] NULL,
	[gia] [decimal](18, 2) NULL,
	[trangThai] [bit] NULL,
	[idDanhMuc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPhamChiTiet]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPhamChiTiet](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idSanPham] [int] NOT NULL,
	[idMauSac] [int] NULL,
	[idKichCo] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[donGia] [decimal](18, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 4/23/2025 10:17:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[maThuongHieu] [varchar](50) NOT NULL,
	[tenThuongHieu] [nvarchar](50) NULL,
	[logo] [nvarchar](max) NULL,
	[trangWeb] [nvarchar](200) NULL,
	[diaChi] [nvarchar](200) NULL,
	[email] [nvarchar](200) NULL,
	[sdt] [nvarchar](50) NULL,
	[ngayThanhLap] [date] NULL,
	[mota] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Accounts] ON 

INSERT [dbo].[Accounts] ([id], [UserName], [Password], [roles], [hoVaTen], [diaChi], [email], [sdt], [ngayDangKi], [trangThai], [anhDaiDien], [gioiTinh], [ngaySinh], [passwordResetToken]) VALUES (1, N'khachhang1', N'$2a$10$Fptaef4DevYf2sgRX/T7UOlYOI2QrVMCS7GzvHg2qxDkztF7WC6ke', N'CUSTOMER', N'Đinh Văn Công', N'00040,002,01', N'madsinfdfjf@gmail.com', N'0937523532', CAST(N'2024-12-12' AS Date), 1, N'default-avatar-icon-of-social-media-user-vector.jpg', 1, CAST(N'2005-06-17' AS Date), NULL)
INSERT [dbo].[Accounts] ([id], [UserName], [Password], [roles], [hoVaTen], [diaChi], [email], [sdt], [ngayDangKi], [trangThai], [anhDaiDien], [gioiTinh], [ngaySinh], [passwordResetToken]) VALUES (3, N'nhanvien1', N'$2a$10$Wsc8U4Dg3NpX2yA42GIfCuCd6R2a5h5VrDJMEyueWz1K.Xfbfopy2', N'EMPLOYEE', N'Đinh Văn Mạnh', N'05506,165,19', NULL, N'0846593536', CAST(N'2025-01-01' AS Date), 1, N'default-avatar-icon-of-social-media-user-vector.jpg', 1, CAST(N'2025-01-15' AS Date), NULL)
INSERT [dbo].[Accounts] ([id], [UserName], [Password], [roles], [hoVaTen], [diaChi], [email], [sdt], [ngayDangKi], [trangThai], [anhDaiDien], [gioiTinh], [ngaySinh], [passwordResetToken]) VALUES (7, N'admin1', N'$2a$10$H2R1iJrdfVj0LWoBk9Yje.yyoZjvNWXWS5LTDLyfTZ095BmyRDkeu', N'ADMIN', N'Đinh Văn Mạnh', N'Hà Nội', N'manhdinh522@gmail.com', N'0355053870', CAST(N'2025-01-08' AS Date), 1, NULL, 1, CAST(N'2004-01-01' AS Date), NULL)
INSERT [dbo].[Accounts] ([id], [UserName], [Password], [roles], [hoVaTen], [diaChi], [email], [sdt], [ngayDangKi], [trangThai], [anhDaiDien], [gioiTinh], [ngaySinh], [passwordResetToken]) VALUES (43, N'admin2', N'$2a$10$1Vfc9gmNfUElufZkt5s8x.LWpkba86BxlC.N7Htj0JVnoPMEbDOlG', N'ADMIN', N'Tạ Đức Anh', N'Hà Nội', N'anhtdph37665@fpt.edu.vn', N'0379560556', CAST(N'2025-01-14' AS Date), 1, NULL, 1, CAST(N'2004-05-15' AS Date), NULL)
INSERT [dbo].[Accounts] ([id], [UserName], [Password], [roles], [hoVaTen], [diaChi], [email], [sdt], [ngayDangKi], [trangThai], [anhDaiDien], [gioiTinh], [ngaySinh], [passwordResetToken]) VALUES (44, N'admin3', N'$2a$10$zlLsBEV5I/hbR9I06L0fWeNTT609pzI0iPX9Pga5VPg144H1Pm2s6', N'ADMIN', N'Nguễn Đình Quyền', N'Hà Nội', N'quyenndph39421@fpt.edu.vn', N'0379560556', CAST(N'2025-01-14' AS Date), 1, NULL, 1, CAST(N'2004-02-08' AS Date), NULL)
INSERT [dbo].[Accounts] ([id], [UserName], [Password], [roles], [hoVaTen], [diaChi], [email], [sdt], [ngayDangKi], [trangThai], [anhDaiDien], [gioiTinh], [ngaySinh], [passwordResetToken]) VALUES (45, N'admin4', N'$2a$10$5B5D76IDt1M7J.vcDiOEY.FnlBJYZSAFR9q1jUy6mT.CHwFBZ8z8u', N'ADMIN', N'Vũ Thế Anh', N'Hà Nội', N'anhvtph37751@fpt.edu.vn', N'0973682004', CAST(N'2025-01-14' AS Date), 1, NULL, 1, CAST(N'2004-08-05' AS Date), NULL)
SET IDENTITY_INSERT [dbo].[Accounts] OFF
GO
SET IDENTITY_INSERT [dbo].[DanhMuc] ON 

INSERT [dbo].[DanhMuc] ([id], [tenDanhMuc]) VALUES (1, N'Sneaker thời trang')
INSERT [dbo].[DanhMuc] ([id], [tenDanhMuc]) VALUES (2, N'Sneaker thể thao')
INSERT [dbo].[DanhMuc] ([id], [tenDanhMuc]) VALUES (3, N'Sneaker cổ thấp')
INSERT [dbo].[DanhMuc] ([id], [tenDanhMuc]) VALUES (4, N'Sneaker cổ cao')
INSERT [dbo].[DanhMuc] ([id], [tenDanhMuc]) VALUES (5, N'Sneaker chunky')
SET IDENTITY_INSERT [dbo].[DanhMuc] OFF
GO
SET IDENTITY_INSERT [dbo].[DonHang] ON 

INSERT [dbo].[DonHang] ([id], [idAccountKhachHang], [idAccountNhanVien], [ngayTaoDon], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [idGiamGia], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (174, 1, NULL, CAST(N'2025-01-15T09:40:47.803' AS DateTime), CAST(2427000.00 AS Decimal(10, 2)), 3, N'0937523532', N'Đinh Văn Công', N'12032,00091,003,01', NULL, NULL, NULL, 0, 1)
INSERT [dbo].[DonHang] ([id], [idAccountKhachHang], [idAccountNhanVien], [ngayTaoDon], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [idGiamGia], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (180, 1, NULL, CAST(N'2025-01-15T10:18:35.053' AS DateTime), CAST(179000.00 AS Decimal(10, 2)), 8, N'0937523532', N'Đinh Văn Công', N'7777,00118,004,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[DonHang] ([id], [idAccountKhachHang], [idAccountNhanVien], [ngayTaoDon], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [idGiamGia], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (183, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[DonHang] ([id], [idAccountKhachHang], [idAccountNhanVien], [ngayTaoDon], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [idGiamGia], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (184, 1, NULL, CAST(N'2025-03-29T10:44:23.353' AS DateTime), CAST(1204000.00 AS Decimal(10, 2)), 8, N'0937523532', N'Đinh Văn Công', N'Hdhf,00688,024,02', NULL, NULL, NULL, 1, 1)
SET IDENTITY_INSERT [dbo].[DonHang] OFF
GO
SET IDENTITY_INSERT [dbo].[DonHangChiTiet] ON 

INSERT [dbo].[DonHangChiTiet] ([id], [idDonHang], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (229, 174, 14, 3, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[DonHangChiTiet] ([id], [idDonHang], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (240, 180, 6, 1, CAST(149000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[DonHangChiTiet] ([id], [idDonHang], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (246, 184, 4, 1, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[DonHangChiTiet] ([id], [idDonHang], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (247, 184, 19, 3, CAST(125000.00 AS Decimal(10, 2)), NULL)
SET IDENTITY_INSERT [dbo].[DonHangChiTiet] OFF
GO
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (155, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(230000.00 AS Decimal(10, 2)), 4, N'0937523532', N'Đinh Văn Công', N'số 120,00040,002,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (156, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(829000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công1111', N'eee2,02230,072,08', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (157, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(430000.00 AS Decimal(10, 2)), 0, N'0937523532', N'Đinh Văn Công', N'256,00001,001,01', NULL, NULL, CAST(430000.00 AS Decimal(10, 2)), 0, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (158, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(430000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'120,00001,001,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (159, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(1229000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'120,00040,002,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (166, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(1329000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'123,00001,001,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (168, CAST(N'2025-01-14' AS Date), 1, NULL, CAST(405000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'123,00001,001,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (169, CAST(N'2025-01-15' AS Date), 7, 7, CAST(250000.00 AS Decimal(10, 2)), 0, N'06846693736', N'Lê Hồng Quang', NULL, NULL, NULL, CAST(2500000.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (170, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(1628000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'120,00001,001,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (171, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(490000.00 AS Decimal(10, 2)), 0, N'0937523532', N'Đinh Văn Công', N'120,00001,001,01', NULL, NULL, CAST(490000.00 AS Decimal(10, 2)), 0, 0)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (172, CAST(N'2025-01-15' AS Date), 7, 7, CAST(450000.00 AS Decimal(10, 2)), 0, N'09365365935', N'Lê Văn Đạt', NULL, NULL, NULL, CAST(450000.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (173, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(155000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'120,00157,005,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (175, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(829000.00 AS Decimal(10, 2)), 0, N'0937523532', N'Đinh Văn Công', N'1203,00718,026,02', NULL, NULL, CAST(829000.00 AS Decimal(10, 2)), 0, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (176, CAST(N'2025-01-15' AS Date), 7, 7, CAST(3571000.00 AS Decimal(10, 2)), 0, N'09365365935', N'Lê Văn Đạt', NULL, NULL, NULL, CAST(3571000.00 AS Decimal(10, 2)), 1, NULL)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (177, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(4918000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'222,00043,002,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (178, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(179000.00 AS Decimal(10, 2)), 4, N'0937523532', N'Đinh Văn Công', N'666,01861,060,06', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (181, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(3280000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'123,00001,001,01', NULL, NULL, NULL, 1, 1)
INSERT [dbo].[HoaDon] ([id], [ngayLapHoaDon], [idAccountKhachHang], [idAccountNhanVien], [tongTien], [trangThai], [sdtKhachHang], [tenKhachhang], [diaChi], [giamGiaID], [soTienSauKhiGiam], [khachTra], [hinhThucThanhToan], [hinhThucGiaoHang]) VALUES (182, CAST(N'2025-01-15' AS Date), 1, NULL, CAST(280000.00 AS Decimal(10, 2)), 5, N'0937523532', N'Đinh Văn Công', N'123,00001,001,01', NULL, NULL, NULL, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] ON 

INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (109, 155, 1, 1, CAST(200000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (110, 156, 14, 1, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (111, 158, 1, 1, CAST(200000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (112, 158, 3, 1, CAST(200000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (113, 157, 1, 2, CAST(200000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (114, 159, 1, 2, CAST(200000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (115, 159, 14, 1, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (116, 166, 1, 2, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (117, 166, 2, 2, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (118, 166, 14, 1, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (119, 168, 19, 3, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (120, 169, 1, 2, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (121, 170, 4, 2, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (122, 171, 5, 2, CAST(220000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (123, 173, 1, 1, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (124, 175, 14, 1, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (125, 172, 1, 2, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (126, 172, 2, 1, CAST(200000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (127, 177, 5, 13, CAST(220000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (128, 177, 29, 1, CAST(430000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (129, 177, 14, 2, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (130, 178, 6, 1, CAST(149000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (131, 181, 1, 2, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (132, 181, 2, 7, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (133, 181, 3, 17, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (134, 176, 1, 3, CAST(125000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (135, 176, 4, 4, CAST(799000.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[HoaDonChiTiet] ([id], [idHoaDon], [idSanPham], [soLuong], [donGia], [thanhTien]) VALUES (136, 182, 19, 2, CAST(125000.00 AS Decimal(10, 2)), NULL)
SET IDENTITY_INSERT [dbo].[HoaDonChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[khachang] ON 

INSERT [dbo].[khachang] ([id], [maKhachHang], [tenKhachHang], [sdt], [diaChi], [email], [ngaySinh], [gioitinh]) VALUES (1, N'KH001', N'Lê Văn Đạt', N'09365365935', N'Hà Nội,Đống Đa,Ngõ 7', N'levandat152@gmail.com', CAST(N'2002-02-03' AS Date), 1)
INSERT [dbo].[khachang] ([id], [maKhachHang], [tenKhachHang], [sdt], [diaChi], [email], [ngaySinh], [gioitinh]) VALUES (2, N'KH002', N'Lê Hồng Quang', N'06846693736', N'Hà Nội,Đống Đa,Ngõ 6', N'lehongquang152@gmail.com', CAST(N'2002-04-03' AS Date), 1)
INSERT [dbo].[khachang] ([id], [maKhachHang], [tenKhachHang], [sdt], [diaChi], [email], [ngaySinh], [gioitinh]) VALUES (7, NULL, N'Đinh Văn Mạnh', N'0846593536', NULL, NULL, NULL, NULL)
INSERT [dbo].[khachang] ([id], [maKhachHang], [tenKhachHang], [sdt], [diaChi], [email], [ngaySinh], [gioitinh]) VALUES (13, NULL, N'Nguyễn Đình Quyền', N'0947587264', NULL, NULL, NULL, NULL)
INSERT [dbo].[khachang] ([id], [maKhachHang], [tenKhachHang], [sdt], [diaChi], [email], [ngaySinh], [gioitinh]) VALUES (17, NULL, N'Tạ Đức Anh', N'0937485764', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[khachang] OFF
GO
SET IDENTITY_INSERT [dbo].[KichCo] ON 

INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (1, N'37')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (2, N'38')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (3, N'39')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (4, N'40')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (5, N'41')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (6, N'42')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (7, N'43')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (8, N'44')
INSERT [dbo].[KichCo] ([id], [tenKichCo]) VALUES (9, N'45')
SET IDENTITY_INSERT [dbo].[KichCo] OFF
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([id], [tenMauSac]) VALUES (1, N'White')
INSERT [dbo].[MauSac] ([id], [tenMauSac]) VALUES (2, N'Red')
INSERT [dbo].[MauSac] ([id], [tenMauSac]) VALUES (3, N'Black')
INSERT [dbo].[MauSac] ([id], [tenMauSac]) VALUES (5, N'Blue')
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (1, N'100001', N'Giày Jordan 1 Low', N'giày chất lượng cao', 1, N'jodan-1-low-white.jpg', 1, CAST(125000.00 AS Decimal(18, 2)), 1, 1)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (2, N'100002', N'Giày Jordan 1 Low', N'Giày thể thao phù hợp cho vận động', 3, N'jodan-1-low-black.jpg', 3, CAST(799000.00 AS Decimal(18, 2)), 1, 1)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (3, N'100003', N'Giày Jordan Stadium 90', N'giày chất lượng cao', 1, N'jodan-stadium-90-white.jpg', 3, CAST(220000.00 AS Decimal(18, 2)), 1, 2)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (4, N'100004', N'Giày Jordan 1 Low SE', N'giày chất lượng cao', 5, N'jodan-1-low-se-blue.jpg', 3, CAST(149000.00 AS Decimal(18, 2)), 1, 3)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (6, N'100006', N'Giày Adidas Bravada', N'giày chất lượng cao', 1, N'Giay-Adidas-Bravada-2.0-Lifestyle-Skateboarding-Canvas-White-HP6022.jpg', 2, CAST(179000.00 AS Decimal(18, 2)), 1, 4)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (7, N'100007', N'Giày Adidas Bravada', N'giày chất lượng cao', 3, N'giay-adidas-bravada-black-fv8085-5.jpg', 2, CAST(189000.00 AS Decimal(18, 2)), 1, 4)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (8, N'100008', N'Giày Nike Revolution 5', N'giày chất lượng cao', 5, N'giay-nike-revolution-5-gray-blue-bq3204-015.jpg', 1, CAST(550000.00 AS Decimal(18, 2)), 1, 1)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (10, N'100001-43', N'Giày SH213', N'giày chất lượng cao', 1, N'jodan-stadium-90-white.jpg', 1, CAST(560000.00 AS Decimal(18, 2)), 1, 1)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (14, N'100009', N'Giày Air Jordan 11 Low', N'giày chất lượng cao', 3, N'Giay-Air-Jordan-11-Low-Space-Jam-FV5104-004-1.jpg', 3, CAST(650000.00 AS Decimal(18, 2)), 1, 5)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (15, N'100010', N'Giày Nike Dunk Low', N'giày chất lượng cao', 5, N'Giay-Nike-Dunk-Low-Blue-Paisley-DH4401-101.jpg', 1, CAST(430000.00 AS Decimal(18, 2)), 1, 5)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (16, N'100011', N'Giày Adidas Stan Smith', N'giày chất lượng cao', 1, N'Giay-adidas-Stan-Smith-Navy-M20325.jpg', 2, CAST(830000.00 AS Decimal(18, 2)), 1, 2)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (25, N'100012', N'Giày Adidas Runfalcon 3.0 Cloudfoam Low', N'giày chất lượng cao', 3, N'Giay-Adidas-Runfalcon-3.0-Cloudfoam-Low-Black-Carbon-HP7544.jpg', 2, CAST(650000.00 AS Decimal(18, 2)), 1, 2)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (26, N'100013', N'Giày Adidas RunFalcon 2.0 TR', N'', 5, N'Giay-adidas-RunFalcon-2.0-TR-Blue-G58137.jpg', 2, CAST(240000.00 AS Decimal(18, 2)), 0, 1)
INSERT [dbo].[SanPham] ([id], [maSanPham], [tenSanPham], [moTa], [idMauSac], [anhSanPham], [idThuongHieu], [gia], [trangThai], [idDanhMuc]) VALUES (35, N'1000012333', N'Giày SH1222', N'', 1, N'Giay-Adidas-Bravada-2.0-Lifestyle-Skateboarding-Canvas-White-HP6022.jpg', 1, CAST(200000.00 AS Decimal(18, 2)), 0, 2)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] ON 

INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (1, 1, 1, 1, 0, 0, CAST(125000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (2, 1, 1, 2, 0, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (3, 1, 1, 3, 0, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (4, 2, 3, 3, 5, 0, CAST(799000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (5, 3, 1, 2, 5, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (6, 4, 2, 4, 17, 1, CAST(149000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (9, 1, 1, 4, 0, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (10, 1, 1, 5, 14, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (11, 1, 1, 6, 24, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (12, 6, 1, 1, 12, 1, CAST(179000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (13, 7, 1, 2, 43, 1, CAST(189000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (14, 2, 3, 1, 0, 1, CAST(799000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (15, 8, 1, 1, 12, 1, CAST(560000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (17, 10, 1, 2, 12, 1, CAST(560000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (19, 1, 1, 9, 32, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (24, 14, 3, 1, 12, 1, CAST(650000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (25, 16, 1, 1, 21, 1, CAST(830000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (26, 16, 1, 2, 14, 1, CAST(830000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (27, 25, 3, 1, 32, 1, CAST(650000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (28, 25, 3, 3, 12, 1, CAST(650000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (29, 15, 5, 1, 11, 1, CAST(430000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (30, 26, 5, 1, 12, 1, CAST(240000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (39, 35, 1, 4, 29, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (40, 35, 1, 3, 20, 1, CAST(200000.00 AS Decimal(18, 2)))
INSERT [dbo].[SanPhamChiTiet] ([id], [idSanPham], [idMauSac], [idKichCo], [soLuong], [trangThai], [donGia]) VALUES (41, 35, 1, 5, 20, 1, CAST(200000.00 AS Decimal(18, 2)))
SET IDENTITY_INSERT [dbo].[SanPhamChiTiet] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 

INSERT [dbo].[ThuongHieu] ([id], [maThuongHieu], [tenThuongHieu], [logo], [trangWeb], [diaChi], [email], [sdt], [ngayThanhLap], [mota]) VALUES (1, N'TH001', N'Nike', N'logo_nike.png', N'www.nike.com', N'USA', N'contact@nike.com', N'1234567890', CAST(N'1964-01-01' AS Date), N'Mô tả về Nike')
INSERT [dbo].[ThuongHieu] ([id], [maThuongHieu], [tenThuongHieu], [logo], [trangWeb], [diaChi], [email], [sdt], [ngayThanhLap], [mota]) VALUES (2, N'TH002', N'Adidas', N'logo_adidas.png', N'www.adidas.com', N'Germany', N'contact@adidas.com', N'0987654321', CAST(N'1949-08-18' AS Date), N'Mô tả về Adidas')
INSERT [dbo].[ThuongHieu] ([id], [maThuongHieu], [tenThuongHieu], [logo], [trangWeb], [diaChi], [email], [sdt], [ngayThanhLap], [mota]) VALUES (3, N'TH003', N'Jordan', NULL, N'Jumpman_logo.svg.png', N'USA', N'contact@adidas.com', N'0485837534', CAST(N'1999-02-04' AS Date), N'Mô tả về Jordan')
INSERT [dbo].[ThuongHieu] ([id], [maThuongHieu], [tenThuongHieu], [logo], [trangWeb], [diaChi], [email], [sdt], [ngayThanhLap], [mota]) VALUES (7, N'PL001', N'Poly', NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([idAccountKhachHang])
REFERENCES [dbo].[Accounts] ([id])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([idAccountNhanVien])
REFERENCES [dbo].[Accounts] ([id])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([idGiamGia])
REFERENCES [dbo].[GiamGia] ([id])
GO
ALTER TABLE [dbo].[DonHangChiTiet]  WITH CHECK ADD FOREIGN KEY([idDonHang])
REFERENCES [dbo].[DonHang] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DonHangChiTiet]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPhamChiTiet] ([id])
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD FOREIGN KEY([idAccountKhachhang])
REFERENCES [dbo].[Accounts] ([id])
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD FOREIGN KEY([idSanPhamChiTiet])
REFERENCES [dbo].[SanPhamChiTiet] ([id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([giamGiaID])
REFERENCES [dbo].[GiamGia] ([id])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([idDanhMuc])
REFERENCES [dbo].[DanhMuc] ([id])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([idMauSac])
REFERENCES [dbo].[MauSac] ([id])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([idThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([id])
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD FOREIGN KEY([idKichCo])
REFERENCES [dbo].[KichCo] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD FOREIGN KEY([idMauSac])
REFERENCES [dbo].[MauSac] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SanPhamChiTiet]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([id])
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [BanGiayChinhSuaTest3] SET  READ_WRITE 
GO
