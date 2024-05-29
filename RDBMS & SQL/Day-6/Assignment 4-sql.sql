CREATE TABLE Authors (
author_id INT PRIMARY KEY,
author_name VARCHAR(100) NOT NULL
);

-- create books table
CREATE TABLE Books(
book_id INT PRIMARY KEY,
title VARCHAR(255) not null,
author_id int,
publication_year INT,
genre Varchar(50),
ISBN VARCHAR(13) UNIQUE,
FOREIGN KEY (author_id) REFERENCEs Authors(author_id)
);

-- create members table
CREATE TABLE Members(
member_id INT PRIMARY KEY,
member_name VARCHAR(100) NOT NULL,
member_email VARCHAR(100),
date_of_birth DATE,
address VARCHAR(255)
);

-- create borrowing table

CREATE TABLE Borrowings(
borrowing_id INT PRIMARY KEY,
book_id INT,
member_id INT,
borrowing_date DATE NOT NULL,
due_date DATE NOT NULL,
return_date DATE,
FOREIGN KEY (book_id) References Books(book_id),
FOREIGN KEY (member_id) REFERENCES Members(member_id),
CHECK (return_date IS NULL OR return_date >= borrowing_date)
);
CREATE TABLE Reservations(
reservation_id INT PRIMARY KEY,
book_id INT,
member_id INT,
reservation_date DATE NOT NULL,
FOREIGN KEY(book_id) REFERENCES Books(book_id),
FOREIGN KEY(member_id) REFERENCES Members(member_id)
);

CREATE TABLE Authors_Books(
author_id INT,
book_id INT,
PRIMARY KEY (author_id, book_id),
FOREIGN KEY (author_id) REFERENCES Authors(author_id),
FOREIGN KEY (book_id) REFERENCES Books(book_id)
);

ALTER TABLE Books
ADD COLUMN language VARCHAR(50);

-- DROP statement to get a reduntdant table
DROP TABLE Authors_Books;