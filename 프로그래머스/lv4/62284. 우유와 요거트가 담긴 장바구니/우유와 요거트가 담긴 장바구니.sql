-- 코드를 입력하세요
SELECT distinct
    cart_id 
from cart_products 
where name='Yogurt' 
and cart_id in (select 
                    cart_id 
                from cart_products 
                where name='Milk'
               )