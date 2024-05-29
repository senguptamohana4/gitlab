
CREATE TABLE Customers(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(100),
region VARCHAR(50)
);

SELECT * FROM customers
LEFT JOIN orders ON customers.customer_id = orders.customer_id
INNER JOIN(
SELECT DISTINCT customer_id
FROM customers
WHERE region = 'specified_region'
) AS specified_customers ON customers.customer_id = specified_customers.customer_id;