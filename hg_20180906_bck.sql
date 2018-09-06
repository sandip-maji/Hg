CREATE TABLE DateTime(
ID INT PRIMARY KEY AUTO_INCREMENT, 
date VARCHAR(45),
time VARCHAR(45));

INSERT DateTime (id,date,time) VALUES (1,'09/11/2018','00:10');
INSERT DateTime (id,date,time) VALUES (2,'15/11/2018','00:09');

INSERT DateTime (id,date,time) VALUES (3,'','00:10');
INSERT DateTime (id,date,time) VALUES (4,'','00:10');


CREATE TABLE GuestInfo(
ID INT PRIMARY KEY AUTO_INCREMENT, 
noOfPax VARCHAR(45),
paxInfo VARCHAR(45));


INSERT GuestInfo (id,noOfPax,paxInfo) VALUES (1,'2','1,2');

CREATE TABLE User(
ID INT PRIMARY KEY AUTO_INCREMENT, 
mainUser Boolean,
initial VARCHAR(45),
fname VARCHAR(45),
mname VARCHAR(45),
lname VARCHAR(45),
age VARCHAR(45),
dob VARCHAR(45),
address VARCHAR(100),
contact VARCHAR(45),
econtact VARCHAR(45),
others VARCHAR(45),
interest VARCHAR(45),
foodType VARCHAR(45),
maritalStatus VARCHAR(45),
religion VARCHAR(45),
email VARCHAR(45),
gender VARCHAR(45),
title VARCHAR(45));



INSERT user (id,
mainUser,
initial,
fname,
mname,
lname,
age,
dob,
address,
contact,
econtact,
others,
interest,
foodType,
maritalStatus,
religion,
email,
gender,
title) VALUES (1,true,'','Lionel','Andres','Messi','31','24/06/1987',
'Avinguda de Bellamar 08860 Castelldefels, Barcelona, Spain','+34 93 496 36 00',
'premsa@fcbarcelona.cat','','Football','Non-Veg','Married','Devout Catholic','leomessi@fcb.com','M','Cuccittini');


INSERT user (id,
mainUser,
initial,
fname,
mname,
lname,
age,
dob,
address,
contact,
econtact,
others,
interest,
foodType,
maritalStatus,
religion,
email,
gender,
title) VALUES (2,true,'','Antonella','','Roccuzzo','30','26/02/1988',
'Avinguda de Bellamar 08860 Castelldefels, Barcelona, Spain','+34 93 496 36 00',
'premsa@fcbarcelona.cat','','Football','Non-Veg','Married','Devout Catholic','leomessi@fcb.com','F','');



CREATE TABLE Hotel(
ID INT PRIMARY KEY AUTO_INCREMENT, 
starRate VARCHAR(45),
amenity VARCHAR(45),
hotelId VARCHAR(45),
name VARCHAR(45),
address VARCHAR(100),
contact VARCHAR(45),
email VARCHAR(45),
hotelCheckedIn boolean,
checkInRefId VARCHAR(45),
webCheckedIn boolean,
feedbackEnabled boolean,
checkedOut boolean,
defaultCheckIn VARCHAR(45),
defaultCheckOut VARCHAR(45),
userCheckIn VARCHAR(45),
userCheckOut VARCHAR(45));

INSERT Hotel (id,starRate,amenity,hotelId,name,address,contact,
email,hotelCheckedIn,checkInRefId,webCheckedIn,checkedOut,
defaultCheckIn,defaultCheckOut,userCheckIn,userCheckOut) VALUES (1,'5','WIFI,Pool,Spa,Parking,Restaurant','001','TAJ',
'Apollo Bunder Mumbai Maharashtra India 400 001','+91 22 6665 3366, +91 22 6665 0300','tmhbc.bom@tajhotels.com',false,'',false,false,false,'3','4','1','2');



CREATE TABLE Hg(
ID INT PRIMARY KEY AUTO_INCREMENT, 
bookingId VARCHAR(45),
hotelDetails VARCHAR(45),
guestInfo VARCHAR(45));

INSERT Hg (id,bookingId,hotelDetails,guestInfo) VALUES (4,'AZRPM7646Q','1','1');