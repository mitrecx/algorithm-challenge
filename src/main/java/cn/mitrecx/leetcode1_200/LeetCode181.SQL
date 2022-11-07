-- 181. Employees Earning More Than Their Managers
-- Easy
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | name        | varchar |
-- | salary      | int     |
-- | managerId   | int     |
-- +-------------+---------+

-- 查询比自己 manager 工资高的员工
SELECT a.name AS Employee
FROM Employee a JOIN Employee b
    ON a.managerId = b.id
    AND a.salary > b.salary;

-- 考察 JOIN：
-- JOIN 是 INNER JOIN 的简写，把两个表连接起来。 （只取有 ON 条件成立的行，相当于两个表取交集）