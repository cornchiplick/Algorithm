-- 코드를 입력하세요
SELECT 
    f.FLAVOR 
from FIRST_HALF f 
left outer join (
    select FLAVOR, SUM(TOTAL_ORDER) as TOTAL_ORDER 
    from JULY
    group by FLAVOR
    ) a 
    on a.FLAVOR=f.FLAVOR 
order by (f.TOTAL_ORDER + a.TOTAL_ORDER) desc 
limit 3