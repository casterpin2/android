USE [MasterAndroid]
GO
/****** Object:  Table [dbo].[AccountTBL]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AccountTBL](
	[Account] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[EmployeeID] [varchar](50) NOT NULL,
 CONSTRAINT [PK_AccountTBL] PRIMARY KEY CLUSTERED 
(
	[Account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[EmployeeTBL]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[EmployeeTBL](
	[EmployeeId] [varchar](50) NOT NULL,
	[EmployeeName] [nvarchar](max) NOT NULL,
	[EmployeeAddress] [nvarchar](max) NULL,
	[EmployeePhone] [int] NULL,
	[RoleID] [int] NOT NULL,
 CONSTRAINT [PK_EmployeeTBL] PRIMARY KEY CLUSTERED 
(
	[EmployeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FoodTBL]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FoodTBL](
	[FoodID] [varchar](200) NOT NULL,
	[FoodName] [nvarchar](50) NOT NULL,
	[FoodPrice] [float] NULL,
	[Promotion] [int] NOT NULL,
	[InStock] [int] NOT NULL,
	[FoodQuantity] [int] NOT NULL,
	[FoodTypeId] [int] NULL,
	[FoodImg] [varchar](50) NOT NULL,
	[FoodDescription] [nvarchar](max) NULL,
 CONSTRAINT [PK_FoodTBL] PRIMARY KEY CLUSTERED 
(
	[FoodID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[FoodType]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FoodType](
	[FoodTypeId] [int] NOT NULL,
	[FoodTypeName] [varchar](200) NULL,
 CONSTRAINT [PK_FoodType] PRIMARY KEY CLUSTERED 
(
	[FoodTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderTBL]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderTBL](
	[No] [int] IDENTITY(1,1) NOT NULL,
	[TableNo] [int] NULL,
	[OrderTime] [date] NOT NULL,
	[FoodID] [varchar](200) NOT NULL,
	[FoodOrderQuantity] [int] NOT NULL,
	[DemandCustomer] [nvarchar](max) NULL,
	[StatusID] [int] NOT NULL,
	[EmployeeOrder] [varchar](50) NOT NULL,
	[OrderID] [varchar](max) NOT NULL,
 CONSTRAINT [PK_OrderTBL] PRIMARY KEY CLUSTERED 
(
	[No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RoleTBL]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleTBL](
	[RoleID] [int] NOT NULL,
	[RoleName] [nchar](10) NULL,
 CONSTRAINT [PK_RoleTBL] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StatusTBL]    Script Date: 3/22/2018 12:00:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StatusTBL](
	[StatusID] [int] NOT NULL,
	[StatusType] [varchar](50) NULL,
 CONSTRAINT [PK_StatusTBL] PRIMARY KEY CLUSTERED 
(
	[StatusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[AccountTBL] ([Account], [Password], [EmployeeID]) VALUES (N'accounttest', N'123456', N'EMP001')
INSERT [dbo].[EmployeeTBL] ([EmployeeId], [EmployeeName], [EmployeeAddress], [EmployeePhone], [RoleID]) VALUES (N'EMP001', N'God Tuyen', N'Ha Noi', 988888888, 1)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'BANHDAP-002', N'BÁNH ĐẬP', 70000, 0, 1, 20, 4, N'banh_dap', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'BANHDAPTOMCHAY-003', N'BÁNH ĐẬP TÔM CHÁY', 70000, 0, 1, 20, 4, N'banh_dap_tom_chay', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'BUNBOHUE-016', N'BÚN BÒ HUẾ', 110000, 0, 1, 10, 1, N'bun_bo_hue', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'BUNSUONG-017', N'BÚN SUÔNG', 110000, 0, 1, 10, 1, N'bun_suong', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'CAHOI-0015', N'CÁ HỒI THÌA LÀ', 250000, 0, 1, 10, 3, N'ca_hoi_thia_la', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'CANGCUABOCCHAO-009', N'CÀNG CUA BỌC CHẠO', 180000, 0, 1, 10, 3, N'cang_cua_boc_chao', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'CHAOTOM-008', N'CHẠO TÔM', 120000, 0, 1, 10, 3, N'chao_tom', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'CUAFARCI-007', N'CUA FARCI', 120000, 0, 1, 10, 3, N'cua_farci', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'GANVIT-014', N'GAN VỊT PHÁP', 600000, 0, 1, 10, 3, N'gan_vit_phap', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'LUONXUCBANHRAN-004', N'LƯƠN XÚC BÁNH TRÁN', 70000, 0, 1, 20, 4, N'luon_xuc_banh_tra', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'MIQUANG-019', N'MÌ QUẢNG', 11000, 0, 1, 10, 1, N'mi_quang', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'NHAMHUE-005', N'NHẤM HUẾ', 70000, 0, 1, 20, 4, N'nham_hue', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'PHOGA-0020', N'PHỞ GÀ', 110000, 0, 1, 10, 1, N'pho_ga', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'SACAHOI-012', N'SALADE CÁ HỒI', 180000, 0, 1, 10, 3, N'salades_ca_hoi', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'SALAPRO-013', N'SALADE PROVENÇALE', 180000, 0, 1, 10, 3, N'salades_dong_pho', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'SALAUCVIT-011', N'SALADE ỨC VỊT', 180000, 0, 1, 10, 3, N'salades_uc_vit', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'SUICAO-018', N'SỦI CẢO NƯỚC', 180000, 0, 1, 10, 1, N'sui_cao_nuoc', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'THAPCAMNUONG-006', N'THẬP CẨM NƯỚNG', 420000, 0, 1, 10, 3, N'thap_cam_nuong', NULL)
INSERT [dbo].[FoodTBL] ([FoodID], [FoodName], [FoodPrice], [Promotion], [InStock], [FoodQuantity], [FoodTypeId], [FoodImg], [FoodDescription]) VALUES (N'TOMNUONG-0010', N'TÔM NƯỚNG', 130000, 0, 1, 10, 3, N'tom_nuong_banh_hoi ', NULL)
INSERT [dbo].[FoodType] ([FoodTypeId], [FoodTypeName]) VALUES (1, N'KhaiVi')
INSERT [dbo].[FoodType] ([FoodTypeId], [FoodTypeName]) VALUES (2, N'BunNuoc')
INSERT [dbo].[FoodType] ([FoodTypeId], [FoodTypeName]) VALUES (3, N'MonPhap')
INSERT [dbo].[FoodType] ([FoodTypeId], [FoodTypeName]) VALUES (4, N'MonNuong')
SET IDENTITY_INSERT [dbo].[OrderTBL] ON 

INSERT [dbo].[OrderTBL] ([No], [TableNo], [OrderTime], [FoodID], [FoodOrderQuantity], [DemandCustomer], [StatusID], [EmployeeOrder], [OrderID]) VALUES (3, 1, CAST(0x243D0B00 AS Date), N'BANHDAP-002', 2, N'N/A', 1, N'EMP001', N'EMP001-01')
INSERT [dbo].[OrderTBL] ([No], [TableNo], [OrderTime], [FoodID], [FoodOrderQuantity], [DemandCustomer], [StatusID], [EmployeeOrder], [OrderID]) VALUES (8, 1, CAST(0x243D0B00 AS Date), N'BANHDAPTOMCHAY-003', 1, NULL, 1, N'EMP001', N'EMP001-01')
INSERT [dbo].[OrderTBL] ([No], [TableNo], [OrderTime], [FoodID], [FoodOrderQuantity], [DemandCustomer], [StatusID], [EmployeeOrder], [OrderID]) VALUES (9, 1, CAST(0x243D0B00 AS Date), N'BUNBOHUE-016', 1, NULL, 1, N'EMP001', N'EMP001-01')
SET IDENTITY_INSERT [dbo].[OrderTBL] OFF
INSERT [dbo].[RoleTBL] ([RoleID], [RoleName]) VALUES (1, N'Admin     ')
INSERT [dbo].[RoleTBL] ([RoleID], [RoleName]) VALUES (2, N'Employee  ')
INSERT [dbo].[RoleTBL] ([RoleID], [RoleName]) VALUES (3, N'Cooker    ')
INSERT [dbo].[StatusTBL] ([StatusID], [StatusType]) VALUES (1, N'Waitting')
INSERT [dbo].[StatusTBL] ([StatusID], [StatusType]) VALUES (2, N'Done')
INSERT [dbo].[StatusTBL] ([StatusID], [StatusType]) VALUES (3, N'Delivered')
INSERT [dbo].[StatusTBL] ([StatusID], [StatusType]) VALUES (4, N'Reject')
ALTER TABLE [dbo].[AccountTBL]  WITH CHECK ADD  CONSTRAINT [FK_AccountTBL_EmployeeTBL1] FOREIGN KEY([EmployeeID])
REFERENCES [dbo].[EmployeeTBL] ([EmployeeId])
GO
ALTER TABLE [dbo].[AccountTBL] CHECK CONSTRAINT [FK_AccountTBL_EmployeeTBL1]
GO
ALTER TABLE [dbo].[EmployeeTBL]  WITH CHECK ADD  CONSTRAINT [FK_EmployeeTBL_RoleTBL1] FOREIGN KEY([RoleID])
REFERENCES [dbo].[RoleTBL] ([RoleID])
GO
ALTER TABLE [dbo].[EmployeeTBL] CHECK CONSTRAINT [FK_EmployeeTBL_RoleTBL1]
GO
ALTER TABLE [dbo].[FoodTBL]  WITH CHECK ADD  CONSTRAINT [FK_FoodTBL_FoodType] FOREIGN KEY([FoodTypeId])
REFERENCES [dbo].[FoodType] ([FoodTypeId])
GO
ALTER TABLE [dbo].[FoodTBL] CHECK CONSTRAINT [FK_FoodTBL_FoodType]
GO
ALTER TABLE [dbo].[OrderTBL]  WITH CHECK ADD  CONSTRAINT [FK_OrderTBL_EmployeeTBL] FOREIGN KEY([EmployeeOrder])
REFERENCES [dbo].[EmployeeTBL] ([EmployeeId])
GO
ALTER TABLE [dbo].[OrderTBL] CHECK CONSTRAINT [FK_OrderTBL_EmployeeTBL]
GO
ALTER TABLE [dbo].[OrderTBL]  WITH CHECK ADD  CONSTRAINT [FK_OrderTBL_FoodTBL] FOREIGN KEY([FoodID])
REFERENCES [dbo].[FoodTBL] ([FoodID])
GO
ALTER TABLE [dbo].[OrderTBL] CHECK CONSTRAINT [FK_OrderTBL_FoodTBL]
GO
ALTER TABLE [dbo].[OrderTBL]  WITH CHECK ADD  CONSTRAINT [FK_OrderTBL_StatusTBL] FOREIGN KEY([StatusID])
REFERENCES [dbo].[StatusTBL] ([StatusID])
GO
ALTER TABLE [dbo].[OrderTBL] CHECK CONSTRAINT [FK_OrderTBL_StatusTBL]
GO
