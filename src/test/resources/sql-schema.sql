DROP TABLE IF EXISTS customers;

CREATE TABLE IF NOT EXISTS customers (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

