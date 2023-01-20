-- 코드를 입력하세요
SELECT 
    date_format(o.sales_date, "%Y") as year, 
    date_format(o.sales_date, "%m") as month, 
    gender, 
    count(distinct o.user_id) as users 
from user_info i 
join online_sale o 
    on i.user_id=o.user_id 
where gender is not null 
group by year, month, gender 
order by year asc, month asc, gender asc