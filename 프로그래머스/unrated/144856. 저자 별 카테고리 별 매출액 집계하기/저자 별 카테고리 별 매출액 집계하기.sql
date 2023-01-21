-- 코드를 입력하세요
select 
    b.author_id, 
    a.author_name, 
    b.category, 
    sum(b.price * s.sales) as total_sales 
from book as b 
join author as a 
    on b.author_id=a.author_id 
join book_sales as s 
    on b.book_id=s.book_id 
where s.sales_date like "2022-01%" 
group by author_name, category 
order by author_id asc, category desc