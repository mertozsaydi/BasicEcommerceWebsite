
CREATE TABLE COLOR(
        ID INTEGER NOT NULL PRIMARY KEY,
        COLOR VARCHAR(12));

CREATE TABLE TYPEOF(
        ID INTEGER NOT NULL PRIMARY KEY,
        TYPEOF VARCHAR(20));

CREATE TABLE CATEGORY(
        ID INTEGER NOT NULL PRIMARY KEY, 
        CATEGORY VARCHAR(27));

CREATE TABLE MANUF(
        ID INTEGER NOT NULL PRIMARY KEY,
        MANUF VARCHAR(20));

CREATE TABLE PRODUCT(
        ID INTEGER NOT NULL PRIMARY KEY,
        NAMEOF VARCHAR(200),
        TYPEID INTEGER REFERENCES TYPEOF(ID) ON DELETE CASCADE,
        MANUFID INTEGER REFERENCES MANUF(ID) ON DELETE CASCADE,
        PRICE DOUBLE,
        PHOTO VARCHAR(200));

CREATE TABLE INFO(
        PID INTEGER REFERENCES PRODUCT(ID) ON DELETE CASCADE,
        CATID INTEGER REFERENCES CATEGORY(ID) ON DELETE CASCADE,
        COLORID INTEGER REFERENCES COLOR(ID) ON DELETE CASCADE,
        SIZEOF VARCHAR(200),
        SPECK VARCHAR(200),
        STOCK INTEGER,
        PRIMARY KEY(PID,CATID));

CREATE TABLE CITY(
        ID INTEGER NOT NULL PRIMARY KEY,
        CITY VARCHAR(20));

CREATE TABLE USERS(
        ID INTEGER NOT NULL PRIMARY KEY,
        MAIL VARCHAR(30),PASSWORD VARCHAR(30),
        NAMEOF VARCHAR(30),
        SURNAME VARCHAR(30),
        CITYID INTEGER REFERENCES CITY(ID) ON DELETE CASCADE,
        ADDRESS VARCHAR(200));

CREATE TABLE ORDERS(
        ID INTEGER,
        PID INTEGER REFERENCES PRODUCT(ID) ON DELETE CASCADE,
        USERID INTEGER REFERENCES USERS(ID) ON DELETE CASCADE,
        ODATE VARCHAR(50),
        PRIMARY KEY(ID,PID));

INSERT INTO COLOR(ID,COLOR) VALUES 

(1,'Black'),(2,'White'),(3,'Red'),
(4,'Blue'),(5,'Yellow'),(6,'Green'),
(7,'Orange'),(8,'Purple'),(9,'Brown'),
(10,'Grey'),(11,'Pink'),(12,'Transparent');

INSERT INTO TYPEOF(ID,TYPEOF) VALUES 

(1,'Iphone 4/4S'),
(2,'Iphone 5/5C/5S'),
(3,'Galaxy S3'),
(4,'Galaxy S3 mini'),
(5,'Galaxy S4'),
(6,'Galaxy S4 mini'),
(7,'Galaxy S5'),
(8,'Galaxy S6'),
(9,'Galaxy Note 3'),
(10,'Galaxy Note 4'),
(11,'LG G2'),
(12,'LG G3'),
(13,'LG G4'),
(14,'LG G5'),
(15,'Google Nexus 5'),
(16,'Google Nexus 6'),
(17,'All Phones');

INSERT INTO CATEGORY(ID,CATEGORY) VALUES

(1,'Battery'),
(2,'PhoneCover'),
(3,'Charging-ConnectionCable'),
(4,'Headphone'),
(5,'CarAccesory'),
(6,'ScreenProtector'),
(7,'PhoneStand'),
(8,'PortableSpeaker'),
(9,'ArmBand');

INSERT INTO MANUF(ID,MANUF) VALUES

(1,'Samsung'),
(2,'Apple'),
(3,'Google'),
(4,'LG'),
(5,'Case Logic'),
(6,'Nokia'),
(7,'Philips'),
(8,'Itech'),
(9,'Motorola'),
(10,'Sony'),
(11,'Casemate'),
(12,'Sennheiser'),
(13,'Ttec'),
(14,'Goldmaster'),
(15,'Powercase'),
(16,'Beats'),
(17,'Panasonic'),
(18,'Sound Logic');

INSERT INTO CITY(ID,CITY) VALUES 

(1,'Adana'),(2,'Adiyaman'),(68,'Aksaray'),
(75,'Ardahan'),(3,'Afyon'),(4,'Agri'),
(5,'Amasya'),(6,'Ankara'),(7,'Antalya'),
(8,'Artvin'),(9,'Aydin'),(10,'Balikesir'),
(74,'Bartin'),(72,'Batman'),(69,'Bayburt'),
(11,'Bilecik'),(12,'Bingol'),(13,'Bitlis'),
(14,'Bolu'),(15,'Burdur'),(16,'Bursa'),
(17,'Canakkale'),(18,'Cankiri'),(19,'Corum'),
(20,'Denizli'),(21,'Diyarbakir'),(81,'Duzce'),
(22,'Edirne'),(23,'Elazig'),(24,'Erzincan'),
(25,'Erzurum'),(26,'Eskisehir'),(27,'Gaziantep'),
(28,'Giresun'),(29,'Gumushane'),(30,'Hakkari'),
(31,'Hatay'),(76,'Igdir'),(32,'Isparta'),
(33,'Mersin'),(34,'Istanbul'),(35,'Izmir'),
(78,'Karabuk'),(70,'Karaman'),(36,'Kars'),
(37,'Kastamonu'),(38,'Kayseri'),(71,'Kirikkale'),
(39,'Kirklareli'),(40,'Kirsehir'),(79,'Kilis'),
(41,'Kocaeli'),(42,'Konya'),(43,'Kutahya'),
(44,'Malatya'),(45,'Manisa'),(46,'Kahramanmaras'),
(47,'Mardin'),(48,'Mugla'),(49,'Mus'),
(50,'Nevsehir'),(51,'Nigde'),(52,'Ordu'),
(80,'Osmaniye'),(53,'Rize'),(54,'Sakarya'),
(55,'Samsun'),(56,'Siirt'),(57,'Sinop'),
(58,'Sivas'),(73,'Sirnak'),(59,'Tekirdag'),
(60,'Tokat'),(61,'Trabzon'),(62,'Tunceli'),
(63,'Sanliurfa'),(64,'Usak'),(65,'Van'),
(77,'Yalova'),(66,'Yozgat'),(67,'Zonguldak');


INSERT INTO USERS(ID, MAIL, PASSWORD, NAMEOF, SURNAME, CITYID, ADDRESS) VALUES

(1,'efemertyilmaz@mega.com','1450575459', 'Efe', 'Yilmaz', 34,'Bahcelievler'), --Password:123456
(2,'alperozaydin@mega.com','1450575459', 'Alper', 'Ozaydin', 34, 'Besiktas'),
(3,'mertozsaydi@mega.com','1450575459', 'Mert', 'Ozsaydi', 01, 'Seyhan'),
(4,'gulcebasar@mega.com','1450575459', 'Gulce', 'Basar', 34, 'Kadikoy'),
(5,'tolgaovatman@mega.com','1450575459', 'Tolga', 'Ovatman', 16, 'Inegol'),
(6,'cuneydtantug@mega.com','1450575459', 'Cuneyd', 'Tantug', 01, 'Cukurova');

INSERT INTO PRODUCT(ID, NAMEOF, TYPEID, MANUFID, PRICE, PHOTO) VALUES

(1, 'Iphone 4 Battery',1, 2, 30, 'http://i.hizliresim.com/zAYWbY.jpg'),
(2, 'Iphone 5 Battery',2, 2, 40, 'http://i.hizliresim.com/zAYWbY.jpg'),
(3, 'Galaxy S3 Mini Battery',4, 13, 30, 'http://i.hizliresim.com/n72vnV.jpg'),
(4, 'Galaxy S4 Battery',5, 13, 40, 'http://i.hizliresim.com/EYp7oZ.jpg'),
(5, 'Google Nexus 6 Battery',16, 3, 40, 'http://i.hizliresim.com/PqBRL5.jpg'),

(6, 'Iphone 4/4S Case',1, 2, 10, 'http://i.hizliresim.com/PqBRLO.jpg'),
(7, 'Iphone 5/5S Case',2, 2, 15, 'http://i.hizliresim.com/GY5q8r.jpg'),
(8, 'Galaxy S6 Case',8, 1, 15, 'http://i.hizliresim.com/og9LGX.jpg'),
(9, 'LG G5 Case',14, 4, 15, 'http://i.hizliresim.com/n72v1M.jpg'),
(10, 'Google Nexus 5 Case',15, 3, 20, 'http://i.hizliresim.com/OqBWQ4.jpg'),

(11, 'Iphone 4/4S Cable',1, 2, 20, 'http://i.hizliresim.com/94E6MZ.jpg'),
(12, 'Iphone 5/5S Cable',2, 2, 30, 'http://i.hizliresim.com/94E6MZ.jpg'),
(13, 'Galaxy Note 3 Cable',9, 1, 25, 'http://i.hizliresim.com/LaEJJ0.jpg'),
(14, 'Galaxy S5 Cable',7, 1, 25, 'http://i.hizliresim.com/LaEJJV.jpg'),
(15, 'LG G6 Cable',16, 4, 30, 'http://i.hizliresim.com/Am6QQq.jpg'),

(16, 'Sennheiser cx300',17, 12, 30, 'http://i.hizliresim.com/l7r22g.png'),
(17, 'Beats solo',17, 3, 200, 'http://i.hizliresim.com/pg8q4n.jpg'),
(18, 'Panasonic rphjek200',17, 17, 10, 'http://i.hizliresim.com/JYkrdW.jpg'),
(19, 'Sony MDRZX110',17, 3, 25, 'http://i.hizliresim.com/a5MJP7.jpg'),
(20, 'Philips SHS3200BK',17, 7, 12, 'http://i.hizliresim.com/VVX5yy.jpg'),

(21, '11 inch Long Cable Car Charger Adapter',2, 7, 13, 'http://i.hizliresim.com/b5MA4G.jpg'),
(22, 'Mobile Phone Holder Mount Clip Buckle Socket ',3, 7, 20, 'http://i.hizliresim.com/mP7j8Y.jpg'),
(23, 'Car Charger Usb and Stand ',5, 14, 20, 'http://i.hizliresim.com/3DjBjO.jpg'),
(24, 'Multipurpose Car SUV Organizer ',17, 10, 30, 'http://i.hizliresim.com/Pq64Y6.jpg'),
(25, 'Multi-function Car Kit Mp3 Player Wireless',17, 17, 25, 'http://i.hizliresim.com/rQ8BZB.jpg'),

(26, 'Iphone 5/5S/5C Screen Protector',2, 2, 15, 'http://i.hizliresim.com/Nqg6AP.jpg'),
(27, 'Google Nexus 5 Screen Protector',15, 3, 13, 'http://i.hizliresim.com/1yDmdD.jpg'),
(28, 'Iphone 4/4S Screen Protector',1, 2, 11, 'http://i.hizliresim.com/0qNjD9.jpg'),
(29, 'LG G3 Screen Protector',16, 4, 12, 'http://i.hizliresim.com/ZDQgYZ.jpg'),
(30, 'Galaxy S5 Screen Protector',7,1,10, 'http://i.hizliresim.com/qY81ED.jpg'),

(31, 'Iphone 4/4S Phone Stand',1, 2, 10, 'http://i.hizliresim.com/0qNjGB.jpg'),
(32, 'Iphone 5/5S Phone Stand',2, 2, 15, 'http://i.hizliresim.com/pg8qGa.jpg'),
(33, 'Selfie Stick for All Phones',17, 10, 35, 'http://i.hizliresim.com/ZDQgOG.jpg'),
(34, 'VonHaus Portable Stand for All Phones',17,7,10, 'http://i.hizliresim.com/5dmrDL.jpg'),
(35, 'Cell Phone Holder',17, 9, 15, 'http://i.hizliresim.com/mP7j20.jpg'),

(36, 'SoundLogic XT Mobile Speaker Base White',17, 18, 10, 'http://i.hizliresim.com/JYkrDJ.jpg'),
(37, 'SoundLogic XT Mobile Speaker Base Black',17, 18, 15, 'http://i.hizliresim.com/QAYELy.jpg'),
(38, 'Iphone 4/4S Portable Speaker',1, 2, 15, 'http://i.hizliresim.com/3DjB60.jpg'),

(39, 'Iphone 5/5S Armband',2, 2, 10, 'http://i.hizliresim.com/a5MJg2.jpg'),
(40, 'Best running armband for Galaxy S5',7, 1, 15, 'http://i.hizliresim.com/VVX5BB.jpg'),
(41, 'Iphone 4/4S Armband',1, 2, 5, 'http://i.hizliresim.com/94q8bZ.jpg');


INSERT INTO INFO(PID, CATID, COLORID, SIZEOF, SPECK, STOCK) VALUES

(1, 1,1 ,'0.9 x 2.1. x 4.3 mm', 'Special design,High quality electric cell ', 20),
(2, 1,1 ,'1.1 x 3.1. x 5.3 mm', 'Top quality, made from only Premium materials battery', 20),
(3, 1,2 ,'0.8 x 2.0. x 5.6 mm', 'This battery is equipped with an NFC antenna', 20),
(4, 1,2 ,'0.9 x 2.6. x 5.9 mm', '2100mAh battery allows you to store power necessary to keep your device charged', 20),
(5, 1,1 ,'1.1 x 2.4. x 5.4 mm', 'Perfect replacement or spare! ', 20) ,

(6, 2,5 ,'118.2 x 58.9. x 9.6 mm', ' High quality PU leather; Extreme Protection from drops and scratches', 10),
(7, 2,6 ,'118.9 x 59.6. x 10.6 mm', 'Designed Specifically for iPhone 5/5S Compatible with All Carriers', 10),
(8, 2,11 ,'108.7 x 60.9. x 8.9 mm', ' Access to all the controls and features', 10),
(9, 2,7 ,'128.9 x 62.4. x 9.5 mm', ' Specially designed for LG G5, elastic silicone rubber materials provide extreme drop protection', 10),
(10, 2,1 ,'104.2 x 63.5. x 9.6 mm', ' Ultra slim and lightweight case' , 10),

(11, 3,1 ,'1.5 m', ' Perfect Fit & Compact' , 20),
(12, 3,2 ,'3.0 m', ' Complete charge and sync compatibility with iPhone 5s / 5c / 5 ' , 18),
(13, 3,1 ,'1.5 m', '  Worlds #1 charging brand', 10),
(14, 3,2 ,'3.0 m', ' Extra Cable, Extra Durable', 8),
(15, 3,1 ,'1.5 m', ' Fits into virtually all case cutouts, big or small' , 5),

(16,4,1,'200m','80 db 12 ohman d sound isolation', 40),
(17,4,2,'200m','90 db 40 ohm', 40),
(18,4,3,'200m','110 db 12 ohm', 40),
(19,4,4,'200m','120 db 150 ohm', 40),
(20,4,5,'200m','90 db 12 ohm and sound isolation', 40),

(21,5,1,'20cmx80cmx100cm','Strong charger adapter', 40),
(22,5,1,'20cmx50cmx90cm','Mobile Phone Holder With Mount Clip Buckle Socke', 40),
(23,5,10,'20cmx80cmx100cm','3 Ports 29w Cup Sentey Ls-2240 Smart High Capacity', 40),
(23,7,10,'20cmx80cmx100cm','3 Ports 29w Cup Sentey Ls-2240 Smart High Capacity', 40),
(24,5,1,'30cmx80cmx100cm','very durable', 40),
(25,5,10,'20cmx100cmx120cm','very durable', 40),

(26,6,12,'4 inch','3-pack of clear screen protectors for iPhone 5, 5S, and 5C with 95% HD clarity', 40),
(27,6,12,'5 inch','Protects against dirt, dust, and scratches; easy, bubble-free placement', 40),
(28,6,12,'3.8 inch','Easy to replace-no residue left behind', 40),
(29,6,12,'4 inch','Precisely cut to fit devices screen', 40),
(30,6,12,'5 inch','Very durable and thin and includes cloth, detailed instructions, and screen protector', 40),


(31,7,1,'Standart Size','Handsfree phone view everywhere conveniently enjoy watching your phone screen hands free', 40),
(32,7,2,'Standart Size','Handsfree phone view everywhere conveniently enjoy watching your phone screen hands free', 50),
(33,7,1,'Up to 5 inches','Compatible with most Android and IOS Smartphone', 40),
(34,7,2,'Standart Size','Suitable for any iPad, iPad Mini, iPhone as well as most tablet computers and android smartphones', 40),
(35,7,1,'Standart Size','#1 QUALITY Heavy Duty and sturdy Holder, tight and bendy arm, secures your smartphone and other electronic devices tightly to prevent the unit from falling or moving around', 40),
(36,7,2,'NULL','Portable speakers are great for listening to music on the go that is when they stay where they are supposed to', 40),
(37,7,1,'NULL','Portable speakers are great for listening to music on the go that is when they stay where they are supposed to', 40),

(36,8,2,'NULL','Portable speakers are great for listening to music on the go that is when they stay where they are supposed to', 40),
(37,8,1,'NULL','Portable speakers are great for listening to music on the go that is when they stay where they are supposed to', 40),
(38,8,6,'NULL','Portable speakers are great for listening to music on the go that is when they stay where they are supposed to', 40),

(39,9,1,'NULL',' Protects and keeps your phone safe from moisture while working out', 20),
(40,9,2,'NULL',' Protects and keeps your phone safe from moisture while working out', 20),
(41,9,1,'NULL',' Protects and keeps your phone safe from moisture while working out', 20);








