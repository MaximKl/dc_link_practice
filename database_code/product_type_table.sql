USE [DCLink_task]
GO

/****** Object:  Table [dbo].[product.type]    Script Date: 15.05.2023 0:02:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[product.type](
	[product_type_id] [int] IDENTITY(1,1) NOT NULL,
	[product_type_name] [varchar](400) NOT NULL,
 CONSTRAINT [PK_product.type] PRIMARY KEY CLUSTERED 
(
	[product_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

