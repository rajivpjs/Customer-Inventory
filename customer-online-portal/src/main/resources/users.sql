create table users (
  emailAddress varchar(50),
  passw varchar(50),
  customerId varchar(255),
  PRIMARY KEY (emailAddress),
  FOREIGN KEY (customerId) REFERENCES customers(customerId)
);
