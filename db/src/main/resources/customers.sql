create table customers_seq (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY
);

create table customers (
  customerId int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name varchar(50),
  surname varchar(50),
  emailAddress varchar(30)
);

delimiter $$
create trigger generate_customer_id
before insert ON customers
for each row
begin
  insert into customers_seq VALUES (NULL);
  SET NEW.id = CONCAT('CUST', LPAD(LAST_INSERT_ID(), 3, '0'));
end$$;
delimiter;