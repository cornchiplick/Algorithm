-- 코드를 입력하세요
select 
    food_type, 
    rest_id, 
    rest_name, 
    favorites 
from (
    select 
    food_type, 
    rest_id, 
    rest_name, 
    favorites, 
    rank() over (partition by food_type order by favorites desc) as r 
    from rest_info 
) as i 
where r=1 
order by food_type desc 