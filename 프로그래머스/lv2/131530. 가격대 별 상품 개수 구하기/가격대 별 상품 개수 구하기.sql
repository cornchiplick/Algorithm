-- 코드를 입력하세요
SELECT (
    case
        when PRICE < 10000 then 0
        else truncate(price, -4)
        end) as PRICE_GROUP, 
    count(*) as PRODUCTS 
from PRODUCT 
group by PRICE_GROUP 
order by PRICE_GROUP