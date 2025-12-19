# Write your MySQL query statement below
SELECT MAX(salary) as SecondHighestSalary FROM Employee
where salary < (SELECT MAX(Salary) FROM Employee);
