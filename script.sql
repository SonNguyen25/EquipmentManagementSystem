USE [master]
GO
/****** Object:  Database [Equipment Management]    Script Date: 09-Apr-20 4:09:37 AM ******/
CREATE DATABASE [Equipment Management]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Equipment Management', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.BAOSONSQL\MSSQL\DATA\Equipment Management.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Equipment Management_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.BAOSONSQL\MSSQL\DATA\Equipment Management_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Equipment Management] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Equipment Management].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Equipment Management] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Equipment Management] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Equipment Management] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Equipment Management] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Equipment Management] SET ARITHABORT OFF 
GO
ALTER DATABASE [Equipment Management] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Equipment Management] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Equipment Management] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Equipment Management] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Equipment Management] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Equipment Management] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Equipment Management] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Equipment Management] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Equipment Management] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Equipment Management] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Equipment Management] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Equipment Management] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Equipment Management] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Equipment Management] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Equipment Management] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Equipment Management] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Equipment Management] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Equipment Management] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Equipment Management] SET  MULTI_USER 
GO
ALTER DATABASE [Equipment Management] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Equipment Management] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Equipment Management] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Equipment Management] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Equipment Management] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Equipment Management', N'ON'
GO
ALTER DATABASE [Equipment Management] SET QUERY_STORE = OFF
GO
USE [Equipment Management]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 09-Apr-20 4:09:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](50) NULL,
	[FullName] [varchar](255) NULL,
	[Password] [varchar](255) NULL,
	[Email] [varchar](255) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Borrow]    Script Date: 09-Apr-20 4:09:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Borrow](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DateBorrow] [datetime] NULL,
	[EquipmentID] [int] NULL,
	[ReturnDate] [date] NULL,
	[FullName] [varchar](255) NULL,
	[Email] [varchar](255) NULL,
	[Class] [varchar](255) NULL,
	[TimeReturned] [varchar](255) NULL,
 CONSTRAINT [PK_Borrow] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Equipment]    Script Date: 09-Apr-20 4:09:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Equipment](
	[EquipmentID] [int] IDENTITY(1,1) NOT NULL,
	[EquipmentCode] [varchar](50) NULL,
	[EquipmentName] [varchar](200) NULL,
	[EquipmentDescription] [varchar](255) NULL,
	[Supplier] [varchar](100) NULL,
	[Quantity] [int] NULL,
	[Classroom] [varchar](200) NULL,
 CONSTRAINT [PK_Equipment] PRIMARY KEY CLUSTERED 
(
	[EquipmentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Return]    Script Date: 09-Apr-20 4:09:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Return](
	[ReturnID] [int] IDENTITY(1,1) NOT NULL,
	[BorrowDate] [datetime] NULL,
	[DateOfReturn] [datetime] NULL,
	[EquipmentID] [int] NULL,
	[Email] [varchar](255) NULL,
	[FullName] [varchar](255) NULL,
 CONSTRAINT [PK_Return] PRIMARY KEY CLUSTERED 
(
	[ReturnID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Borrow]  WITH CHECK ADD FOREIGN KEY([EquipmentID])
REFERENCES [dbo].[Equipment] ([EquipmentID])
GO
ALTER TABLE [dbo].[Return]  WITH CHECK ADD FOREIGN KEY([EquipmentID])
REFERENCES [dbo].[Equipment] ([EquipmentID])
GO
USE [master]
GO
ALTER DATABASE [Equipment Management] SET  READ_WRITE 
GO
