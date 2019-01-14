INSERT INTO CUSTOMERS (customerId, name, surname) VALUES ('1', 'test', 'test');
INSERT INTO USERS (emailAddress, passw, customerId) VALUES ('user@gmail.com', 'pass', '1');
commit;