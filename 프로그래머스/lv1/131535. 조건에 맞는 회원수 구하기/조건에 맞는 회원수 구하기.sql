-- 코드를 입력하세요
SELECT count(*) as USERS from USER_INFO where DATE_FORMAT(JOINED, "%Y")="2021" and AGE>=20 and AGE<=29;