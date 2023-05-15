USE [DCLink_task]
GO

/****** Object:  Table [dbo].[client]    Script Date: 15.05.2023 0:02:29 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[client](
	[client_id] [bigint] IDENTITY(1,1) NOT NULL,
	[client_name] [varchar](400) NOT NULL,
	[client_surname] [varchar](400) NOT NULL,
	[client_patronymic_name] [varchar](400) NOT NULL,
	[client_bussiness_name] [varchar](1000) NOT NULL,
	[client_base_discount] [money] NOT NULL,
	[client_is_cooperate] [bit] NOT NULL,
 CONSTRAINT [PK_client] PRIMARY KEY CLUSTERED 
(
	[client_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

