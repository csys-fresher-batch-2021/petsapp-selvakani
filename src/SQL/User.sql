CREATE TABLE userList (
	
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	email VARCHAR ( 255 ) PRIMARY KEY UNIQUE NOT NULL,
	mobileNumber varchar ( 10 ) UNIQUE NOT NULL,
	address varchar ( 50 ) NOT NULL,
	password VARCHAR ( 50 ) NOT NULL
);

INSERT INTO userList(username,email,mobileNumber,address,age,password) VALUES 
('Selva','sk22@gmail.com',7708540604,'Virudhunagar','Selva@123');

select email,password from userList;