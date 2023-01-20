-- 코드를 입력하세요
SELECT 
    a.apnt_no, 
    p.pt_name, 
    a.pt_no, 
    a.mcdp_cd, 
    d.dr_name, 
    a.apnt_ymd 
from appointment as a 
join doctor as d on a.mddr_id=d.dr_id 
join patient as p on a.pt_no=p.pt_no 
where date_format(a.apnt_ymd, "%Y-%m-%d")="2022-04-13" 
    and a.apnt_cncl_yn="N" 
    and a.mcdp_cd="CS" 
order by a.apnt_ymd asc