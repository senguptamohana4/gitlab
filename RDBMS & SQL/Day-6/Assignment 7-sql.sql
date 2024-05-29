INSERT INTO Authors (author_id, author_name)
VALUES (1, 'Mohana'),
       (2, 'Komal'),
       (3, 'Payel');
       
       -- insert into books table
       INSERT INTO Books (book_id, title, author_id, publication_year, genre, ISBN)
       VALUES (1, 'Harry potter & the Sorcerer', 's Stone', 1, 1997, 'Fantasy', '1234567'),
			  (2, '1984', 2, 1949, 'Dystopian', '12345677889'),
              (3, 'pride & prejuidice', 3, 1813, 'Romance', '123456789');
              
		-- insert into members table
        INSERT INTO Members (member_id, member_name, member_email, date_of_birth, address)
        VALUES (1, 'Siya', 'siyapatel@gmail.com', '2000-11-05', 'west bengal'),
        
   UPDATE Books
   SET publication_year = 1998
   WHERE book_id = 1;
   
   UPDATE Members
   SET member_email = 'siyapatel@gmail.com'
   WHERE member_id = 2;
   
   -- DELETE A BOOK
   DELETE FROM Books
   WHERE book_id = 2;
        
               
               