-- 코드를 입력하세요
SELECT 
    i.REST_ID, 
    i.REST_NAME, 
    i.FOOD_TYPE, 
    i.FAVORITES, 
    i.ADDRESS, 
    round(avg(r.REVIEW_SCORE), 2) as SCORE 
from REST_REVIEW as r 
join REST_INFO as i 
    on i.REST_ID=r.REST_ID 
group by r.REST_ID 
having i.ADDRESS like "서울%" 
order by SCORE desc, 
    i.FAVORITES desc;