CREATE TABLE breedList (

	breedName varchar (30) UNIQUE NOT NULL,
	count int NOT NULL,
	cost bigint NOT NULL

);

INSERT INTO breedList(breedName,count,cost) VALUES 
('Pomeranian',5,10000);
INSERT INTO breedList(breedName,count,cost) VALUES 
('German Shepherd',4,18000);
INSERT INTO breedList(breedName,count,cost) VALUES 
('Shitzu',7,35000);
INSERT INTO breedList(breedName,count,cost) VALUES 
('Chippiparai',5,8000);


SELECT * FROM breedList;