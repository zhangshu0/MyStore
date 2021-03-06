USE [finalHomework]
GO
/****** Object:  Table [dbo].[users]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[users_id] [int] IDENTITY(1,1) NOT NULL,
	[users_username] [varchar](20) NULL,
	[users_password] [varchar](20) NULL,
	[users_email] [varchar](20) NULL,
	[users_head_portrait] [varchar](256) NULL,
	[address] [varchar](256) NULL,
PRIMARY KEY CLUSTERED 
(
	[users_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[book_type]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[book_type](
	[types_id] [int] IDENTITY(1,1) NOT NULL,
	[types_name] [varchar](256) NULL,
PRIMARY KEY CLUSTERED 
(
	[types_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[admin]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[admin](
	[admin_id] [int] IDENTITY(1,1) NOT NULL,
	[admin_username] [varchar](50) NULL,
	[admin_password] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[admin_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cart]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cart](
	[proxy_id] [int] IDENTITY(1,1) NOT NULL,
	[create_time] [varchar](256) NULL,
	[users_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[proxy_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[book]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[book](
	[book_id] [int] IDENTITY(1,1) NOT NULL,
	[book_name] [varchar](50) NULL,
	[book_auth] [varchar](20) NULL,
	[book_price] [float] NULL,
	[book_publisher] [varchar](100) NULL,
	[b_t] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[orders]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[orders](
	[proxy_id] [int] IDENTITY(1,1) NOT NULL,
	[price] [int] NULL,
	[create_time] [varchar](256) NULL,
	[address] [varchar](256) NULL,
	[users_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[proxy_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[proxy_id] [int] IDENTITY(1,1) NOT NULL,
	[book_id] [int] NULL,
	[number] [int] NULL,
	[order_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[proxy_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cart_details]    Script Date: 12/22/2017 10:27:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart_details](
	[proxy_id] [int] IDENTITY(1,1) NOT NULL,
	[book_id] [int] NULL,
	[number] [int] NULL,
	[cart_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[proxy_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK__book__b_t__367C1819]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[book]  WITH CHECK ADD FOREIGN KEY([b_t])
REFERENCES [dbo].[book_type] ([types_id])
GO
/****** Object:  ForeignKey [FK__cart__users_id__395884C4]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[cart]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
ON DELETE CASCADE
GO
/****** Object:  ForeignKey [FK__cart_deta__book___2B0A656D]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[cart_details]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([book_id])
GO
/****** Object:  ForeignKey [FK__cart_deta__cart___3A4CA8FD]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[cart_details]  WITH CHECK ADD FOREIGN KEY([cart_id])
REFERENCES [dbo].[cart] ([proxy_id])
ON DELETE CASCADE
GO
/****** Object:  ForeignKey [FK__order_det__book___19DFD96B]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([book_id])
GO
/****** Object:  ForeignKey [FK__order_det__order__3864608B]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([proxy_id])
ON DELETE CASCADE
GO
/****** Object:  ForeignKey [FK__orders__users_id__37703C52]    Script Date: 12/22/2017 10:27:19 ******/
ALTER TABLE [dbo].[orders]  WITH CHECK ADD FOREIGN KEY([users_id])
REFERENCES [dbo].[users] ([users_id])
ON DELETE CASCADE
GO
