# Write your MySQL query statement below
SELECT e.name AS Employee
FROM Employee as e
JOIN Employee as m
ON e.managerId = m.id
where e.salary > m.salary;