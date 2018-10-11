create table user (
  emailAddress varchar(50),
  passw varchar(50),
  customerId int,
  PRIMARY KEY (emailAddress),
  FOREIGN KEY (customerId) REFERENCES customer(customerId)
);
