-- 182. Duplicate Emails
-- Easy

-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | email       | varchar |
-- +-------------+---------+

-- 找出重复的邮箱
with x as (
    select email, count(email) as cnt
    from Person
    group by email
)
select email from x
where cnt > 1;

-- 或者
select email from Person
group by email
having count(email) > 1;