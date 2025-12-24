# Write your MySQL query statement below
SELECT 
    CASE
      WHEN id%2=1 AND id < (SELECT MAX(id) FROM Seat) THEN id+1
      WHEN id%2=0 THEN id-1
      ELSE id
    END AS id,
    student
FROM Seat
ORDER BY id ;

-- CASE
--     WHEN condition1 THEN result1
--     WHEN condition2 THEN result2
--     ELSE default_result
-- END