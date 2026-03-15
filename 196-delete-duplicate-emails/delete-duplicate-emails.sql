# Write your MySQL query statement below
DELETE p1
FROM Person p1
JOIN Person p2
ON P1.email=P2.email
WHERE P1.Id>P2.Id;