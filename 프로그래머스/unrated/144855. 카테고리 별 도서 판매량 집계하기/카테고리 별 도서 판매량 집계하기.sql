-- 코드를 입력하세요
select 
    b.category, 
    sum(s.sales) as total_sales 
from book_sales as s 
join book as b 
    on s.book_id=b.book_id 
where date_format(s.sales_date, "%Y-%m")="2022-01" 
group by category 
order by category asc