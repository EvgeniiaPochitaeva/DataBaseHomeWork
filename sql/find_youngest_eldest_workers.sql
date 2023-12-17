SELECT 'YOUNGEST' AS TYPE, name AS NAME, birthday AS BIRTHDAY
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)

UNION

SELECT 'OLDEST' AS TYPE, name AS NAME, birthday AS BIRTHDAY
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker);