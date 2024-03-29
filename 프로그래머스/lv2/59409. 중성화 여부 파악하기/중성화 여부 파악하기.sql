-- 코드를 입력하세요
SELECT 
    ANIMAL_ID, 
    name, 
    (case  
        when (sex_upon_intake like "%Neutered%" 
        or sex_upon_intake like "%Spayed%") then "O" 
        else "X" 
    end) as 중성화
from animal_ins 
order by animal_id