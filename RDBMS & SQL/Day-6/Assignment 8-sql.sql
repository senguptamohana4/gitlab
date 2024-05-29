DESC student;

SELECT * FROM student;

START TRANSACTION;

SAVEPOINT initial;

INSERT INTO student VALUES(7, 'mohana', 8.8, 'BCA');

SAVEPOINT updation;

UPDATE student SET sname = '' WHERE id = 2;

SAVEPOINT insertAfterUpdation;

INSERT INTO student VALUES(8, 'Diya', 7.8, 'BTECH');

ROLLBACK TO initial;

SELECT * FROM student;

ROLLBACK TO insertionAfterUpdation;

SELECT * FROM student;

COMMIT;

