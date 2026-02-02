# Write your MySQL query statement below
SELECT product_name, year, price FROM Sales as s
LEFT JOIN Product as p
ON s.product_id = p.product_id;