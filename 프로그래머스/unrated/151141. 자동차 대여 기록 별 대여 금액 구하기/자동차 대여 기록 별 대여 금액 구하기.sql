with con as (
    select 
        h.car_id, 
        (datediff(h.end_date, h.start_date) + 1) as diff, 
        c.daily_fee, 
        c.car_type, 
        h.history_id, 
      (case
        when (datediff(h.end_date, h.start_date) + 1) < 7 then '할인 없음' 
        when (datediff(h.end_date, h.start_date) + 1) < 30 then '7일 이상'  
        when (datediff(h.end_date, h.start_date) + 1) < 90 then '30일 이상' 
        else '90일 이상' 
      end) as duration
    from car_rental_company_rental_history as h 
    join car_rental_company_car as c 
        on h.car_id=c.car_id 
    where c.car_type='트럭'
)

select 
    con.history_id, 
    round(case
        when con.duration="할인 없음" then con.diff * con.daily_fee 
        else con.diff * con.daily_fee * (1-p.discount_rate/100) 
    end) as fee 
from con
left outer join car_rental_company_discount_plan as p 
    on con.car_type=p.car_type and con.duration=p.duration_type
order by fee desc, history_id desc