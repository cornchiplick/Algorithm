-- 코드를 입력하세요
select 
    date_format(start_date, "%m") as month, 
    car_id, 
    count(*) as records 
from car_rental_company_rental_history 
where month(start_date) between 8 and 10 
    and car_id in (
        select
            car_id 
        from car_rental_company_rental_history 
        where month(start_date) between 8 and 10 
        group by car_id 
        having count(*) >= 5
    )
group by month, car_id 
order by month asc, car_id desc