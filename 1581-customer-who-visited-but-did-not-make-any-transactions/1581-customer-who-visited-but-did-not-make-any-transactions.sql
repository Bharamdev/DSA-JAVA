# Write your MySQL query statement below
SELECT customer_id, COUNT(customer_id) as count_no_trans
FROM Visits AS v
LEFT JOIN Transactions AS t
ON v.visit_id = t.visit_id
WHERE t.visit_id IS NULL
GROUP BY v.customer_id;  