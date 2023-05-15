create procedure returnNotAvailable
@client_id bigint, @brand_id int, @type_id  int
AS
if (@brand_id is null)
	begin
		select product_type_name +' недоступно для продажу клієнту '+client.client_bussiness_name as response
		from client 
		inner join [client.possibilities] as cp
		on cp.possibilities_client_id = client_id
		inner join [product.type] as pt
		on pt.product_type_id = cp.possibilities_type_id
		where possibilities_client_id=@client_id and possibilities_type_id=@type_id
		return;
	end

select product_type_name +' '+ brand_name +' недоступно для продажу клієнту '+client.client_bussiness_name as response
from client 
inner join [client.possibilities] as cp
on cp.possibilities_client_id = client_id
inner join [product.type] as pt
on pt.product_type_id = cp.possibilities_type_id
inner join brand as b
on b.brand_id = cp.possibilities_brand_id
where possibilities_client_id=@client_id and possibilities_brand_id=@brand_id and possibilities_type_id=@type_id