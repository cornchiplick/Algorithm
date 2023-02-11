-- 코드를 입력하세요
select distinct h.car_id 
from car_rental_company_rental_history as h 
join car_rental_company_car as c 
    on h.car_id = c.car_id 
where c.car_type = '세단' 
    and h.start_date like '2022-10%' 
order by h.car_id desc