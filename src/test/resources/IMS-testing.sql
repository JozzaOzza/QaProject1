CREATE DATABASE IF NOT EXISTS IMS_Test;

USE IMS_Test;

SET FOREIGN_KEY_CHECKS=0; DROP TABLE IF EXISTS customers; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE IF EXISTS items; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE IF EXISTS orderItems; SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0; DROP TABLE IF EXISTS orders; SET FOREIGN_KEY_CHECKS=1;



CREATE TABLE customers (
  id int NOT NULL AUTO_INCREMENT,
  firstName varchar(255) NOT NULL,
  surname varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE items (
  itemId int NOT NULL AUTO_INCREMENT,
  itemName varchar(255) NOT NULL,
  price DOUBLE(9, 2) NOT NULL,
  PRIMARY KEY (itemId)
);

CREATE TABLE orders (
  orderId int NOT NULL AUTO_INCREMENT,
  fkCustId int NOT NULL,
  PRIMARY KEY (orderId),
  FOREIGN KEY (fkCustId) REFERENCES Customers (id) ON DELETE CASCADE
);

CREATE TABLE orderItems (
  orderItemId int NOT NULL AUTO_INCREMENT,
  fkItemId int NOT NULL,
  fkOrderId int NOT NULL,
  PRIMARY KEY (orderItemId),
  FOREIGN KEY (fkItemId) REFERENCES items (itemId) ON DELETE CASCADE,
  FOREIGN KEY (fkOrderId) REFERENCES Orders (orderId) ON DELETE CASCADE
);

INSERT INTO customers (firstName, surname)
VALUES
  ("Lucian","Shelton"),
  ("Lane","O'connor");
  
INSERT INTO items (itemName,price)
VALUES
  ("FIFA 22",50),
  ("Rocket League",25);
  
INSERT INTO Orders (fkCustId)
VALUES
  (1),
  (2);
  
INSERT INTO OrderItems (fkItemId, fkOrderId)
VALUES
  (1, 2),
  (2, 1);