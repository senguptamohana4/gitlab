CREATE INDEX idx_employee_last_name ON employees(last_name);

 -- improvement in query performance
 
SELECT * FROM employees WHERE last_name = 'Mohana';

DROP INDEX idx_employee_last_name ON employees;

 -- imapact on query execution, after dropping the index queries that previously benefited from the index involves filtering 
 -- or sorting by 'last_name' column
 SELECT * FROM employees WHERE last_name = 'Mohana';


