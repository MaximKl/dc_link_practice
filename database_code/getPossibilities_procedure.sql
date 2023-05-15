create procedure getPossibilities
@client_id bigint, @product_id bigint
AS

if not exists(select * from client where client_id=@client_id)
begin
	select * from [client.possibilities] where possibilities_id=-1;
	return;
end

if not exists(select * from product where @product_id=product_id)
begin
	select * from [client.possibilities] where possibilities_id=-1;
	return;
end

if (select client_is_cooperate from client where client_id=@client_id)=0
begin
	select * from [client.possibilities] where possibilities_id=-1;
	return;
end

if (select product_is_available from product where product_id=@product_id)=0
begin
	select * from [client.possibilities] where possibilities_id=-1;
	return;
end

declare @product_type int;
declare @product_brand int;
set @product_brand =(select product_brand_id from product where product_id=@product_id)
set @product_type = (select product_type_id from product where product_id=@product_id)

if exists(select * from [client.possibilities]
where possibilities_client_id=@client_id and possibilities_brand_id=@product_brand and possibilities_type_id=@product_type)
begin
	if(select possibilities_is_available from [client.possibilities]
	where possibilities_client_id=@client_id and possibilities_brand_id=@product_brand and possibilities_type_id=@product_type)=0
	begin
		select * from [client.possibilities] where possibilities_id=-1;
		return;
	end
	select * from [client.possibilities]
	where possibilities_client_id=@client_id and possibilities_brand_id=@product_brand and possibilities_type_id=@product_type
	return
end

if exists(select * from [client.possibilities]
where possibilities_client_id=@client_id and possibilities_brand_id is null and possibilities_type_id=@product_type)
begin
	if(select possibilities_is_available from [client.possibilities]
	where possibilities_client_id=@client_id and possibilities_brand_id is null and possibilities_type_id=@product_type)=0
	begin
		select * from [client.possibilities] where possibilities_id=-1;
		return;
	end
	select * from [client.possibilities]
	where possibilities_client_id=@client_id and possibilities_brand_id is null and possibilities_type_id=@product_type
	return
end
select * from [client.possibilities] where possibilities_id=-1;
