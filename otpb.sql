SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Itinerary;
DROP TABLE IF EXISTS Rating;
DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS City;
DROP TABLE IF EXISTS Message;
DROP TABLE IF EXISTS questionType;
DROP TABLE IF EXISTS userAccount;




/* Create Tables */

CREATE TABLE City
(
	cityId int NOT NULL AUTO_INCREMENT,
	cityName varchar(100) NOT NULL,
	locationType enum('DOMESTIC','INTERNATIONAL') NOT NULL,
	region varchar(100) NOT NULL,
	website varchar(200),
	detail text NOT NULL,
	PRIMARY KEY (cityId)
);


CREATE TABLE Comment
(
	commentId int NOT NULL AUTO_INCREMENT,
	customerId int NOT NULL,
	productId int NOT NULL,
	message text NOT NULL,
	date datetime NOT NULL,
	PRIMARY KEY (commentId)
);


CREATE TABLE hotel
(
	hotelId int NOT NULL AUTO_INCREMENT,
	cityId int NOT NULL,
	hotelName varchar(200) NOT NULL,
	PRIMARY KEY (hotelId)
);


CREATE TABLE Itinerary
(
	itineraryId int NOT NULL AUTO_INCREMENT,
	productId int NOT NULL,
	title varchar(200) NOT NULL,
	detail varchar(200) NOT NULL,
	dayNo int DEFAULT 0 NOT NULL,
	PRIMARY KEY (itineraryId)
);


CREATE TABLE Message
(
	messageId int NOT NULL AUTO_INCREMENT,
	questionTypeId int NOT NULL,
	name varchar(100),
	email varchar(100),
	messageText text,
	date datetime NOT NULL,
	PRIMARY KEY (messageId)
);


CREATE TABLE product
(
	productId int NOT NULL AUTO_INCREMENT,
	userAccountId int NOT NULL,
	hotelId int NOT NULL,
	photo varchar(50),
	title varchar(150) NOT NULL,
	location varchar(100),
	day int DEFAULT 0 NOT NULL,
	night int DEFAULT 0 NOT NULL,
	groupSize varchar(50) NOT NULL,
	amount int DEFAULT 0 NOT NULL,
	type enum('Budget','Standard','Premium') NOT NULL,
	meals varchar(255),
	photoone varchar(50),
	photoTwo varchar(50),
	photoThree varchar(50),
	photoFour varchar(50),
	detail text,
	travelDate datetime NOT NULL,
	ticket int NOT NULL,
	PRIMARY KEY (productId)
);


CREATE TABLE questionType
(
	questionTypeId int NOT NULL AUTO_INCREMENT,
	question varchar(200) NOT NULL,
	PRIMARY KEY (questionTypeId)
);


CREATE TABLE Rating
(
	ratingId int NOT NULL AUTO_INCREMENT,
	customerId int NOT NULL,
	productId int NOT NULL,
	rating int DEFAULT 0 NOT NULL,
	date datetime NOT NULL,
	PRIMARY KEY (ratingId)
);


CREATE TABLE sale
(
	saleId int NOT NULL AUTO_INCREMENT,
	userAccountId int,
	customerId int NOT NULL,
	productId int NOT NULL,
	voucherCode varchar(100) NOT NULL,
	qty int,
	unitPrice int DEFAULT 0 NOT NULL,
	amount int NOT NULL,
	paymentType varchar(100),
	status enum('CONFIRM','APPROVED','DELETE') NOT NULL,
	date datetime NOT NULL,
	modifiedDate datetime NOT NULL,
	PRIMARY KEY (saleId)
);


CREATE TABLE userAccount
(
	userAccountId int NOT NULL AUTO_INCREMENT,
	profileName varchar(100) NOT NULL,
	phone varchar(100),
	userType enum('ADMIN','CUSTOMER'),
	email varchar(100) NOT NULL,
	password varchar(199) NOT NULL,
	-- 0 is inactive.
	-- 1 is active.
	status int DEFAULT 0 NOT NULL COMMENT '0 is inactive.
1 is active.',
	PRIMARY KEY (userAccountId),
	UNIQUE (email)
);



/* Create Foreign Keys */

ALTER TABLE hotel
	ADD FOREIGN KEY (cityId)
	REFERENCES City (cityId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product
	ADD FOREIGN KEY (hotelId)
	REFERENCES hotel (hotelId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Comment
	ADD FOREIGN KEY (productId)
	REFERENCES product (productId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Itinerary
	ADD FOREIGN KEY (productId)
	REFERENCES product (productId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Rating
	ADD FOREIGN KEY (productId)
	REFERENCES product (productId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sale
	ADD FOREIGN KEY (productId)
	REFERENCES product (productId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Message
	ADD FOREIGN KEY (questionTypeId)
	REFERENCES questionType (questionTypeId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Comment
	ADD FOREIGN KEY (customerId)
	REFERENCES userAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE product
	ADD FOREIGN KEY (userAccountId)
	REFERENCES userAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Rating
	ADD FOREIGN KEY (customerId)
	REFERENCES userAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sale
	ADD FOREIGN KEY (userAccountId)
	REFERENCES userAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sale
	ADD FOREIGN KEY (customerId)
	REFERENCES userAccount (userAccountId)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



