USE [DCLink_task]
GO

/****** Object:  Table [dbo].[product]    Script Date: 15.05.2023 0:03:02 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[product](
	[product_id] [bigint] IDENTITY(1,1) NOT NULL,
	[product_cost] [money] NOT NULL,
	[product_price] [money] NOT NULL,
	[product_type_id] [int] NOT NULL,
	[product_brand_id] [int] NOT NULL,
	[product_is_available] [bit] NOT NULL,
	[product_name] [varchar](800) NOT NULL,
	[product_description] [varchar](5000) NOT NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_brand] FOREIGN KEY([product_brand_id])
REFERENCES [dbo].[brand] ([brand_id])
GO

ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_brand]
GO

ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_product.type] FOREIGN KEY([product_type_id])
REFERENCES [dbo].[product.type] ([product_type_id])
GO

ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_product.type]
GO

