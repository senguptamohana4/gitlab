-- Subquery to find customers with orders above the average values
SELECT * FROM customers
WHERE customer_id IN(
SELECT customer_id
FROM orders
GROUP BY customer_id
HAVING AVG(order_value) > (
SELECT AVG(order_value)
FROM orders
)
)
UNION

-- Second query to fetch customers who have not placed
SELECT * FROM customers
WHERE customer_id NOT IN(
SELECT customer_id
FROM orders
SELECT customer_id
FROM orders
GROUP BY customer_id
HAVING AVG(order_value) > (
SELECT AVG(order_value)
FROM orders
)
);