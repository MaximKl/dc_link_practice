USE [DCLink_task]
GO

/****** Object:  Table [dbo].[client.possibilities]    Script Date: 15.05.2023 0:03:27 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[client.possibilities](
	[possibilities_id] [bigint] IDENTITY(1,1) NOT NULL,
	[possibilities_client_id] [bigint] NOT NULL,
	[possibilities_type_id] [int] NOT NULL,
	[possibilities_discount_percent] [money] NOT NULL,
	[possibilities_discount_money] [money] NOT NULL,
	[possibilities_brand_id] [int] NULL,
	[possibilities_is_available] [bit] NOT NULL,
 CONSTRAINT [PK_client.possibilities] PRIMARY KEY CLUSTERED 
(
	[possibilities_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[client.possibilities]  WITH CHECK ADD  CONSTRAINT [FK_client.possibilities_brand] FOREIGN KEY([possibilities_brand_id])
REFERENCES [dbo].[brand] ([brand_id])
GO

ALTER TABLE [dbo].[client.possibilities] CHECK CONSTRAINT [FK_client.possibilities_brand]
GO

ALTER TABLE [dbo].[client.possibilities]  WITH CHECK ADD  CONSTRAINT [FK_client.possibilities_client] FOREIGN KEY([possibilities_client_id])
REFERENCES [dbo].[client] ([client_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[client.possibilities] CHECK CONSTRAINT [FK_client.possibilities_client]
GO

ALTER TABLE [dbo].[client.possibilities]  WITH CHECK ADD  CONSTRAINT [FK_client.possibilities_product.type] FOREIGN KEY([possibilities_type_id])
REFERENCES [dbo].[product.type] ([product_type_id])
GO

ALTER TABLE [dbo].[client.possibilities] CHECK CONSTRAINT [FK_client.possibilities_product.type]
GO

