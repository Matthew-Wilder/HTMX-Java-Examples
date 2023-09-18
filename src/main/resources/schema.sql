-- Begin Pizza Schema
CREATE TABLE `gender` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(500) NOT NULL,
    UNIQUE(`name`)
);


CREATE TABLE `person` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `age` INT NOT NULL,
    `gender_id` INT NOT NULL,
    FOREIGN KEY (`gender_id`) REFERENCES `gender`(`id`),
    UNIQUE(`name`)
);


CREATE TABLE `pizzeria` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    UNIQUE(`name`)
);


CREATE TABLE `pizza` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    UNIQUE(`name`)
);


CREATE TABLE `serves` (
    `pizzeria_id` INT NOT NULL,
    `pizza_id` INT NOT NULL,
    `price` NUMERIC(5, 2) NOT NULL,
    FOREIGN KEY (`pizzeria_id`) REFERENCES `pizzeria`(`id`),
    FOREIGN KEY (`pizza_id`) REFERENCES `pizza`(`id`)
);


CREATE TABLE `frequents` (
    `person_id` INT NOT NULL,
    `pizzeria_id` INT NOT NULL,
    FOREIGN KEY (`person_id`) REFERENCES `person`(`id`),
    FOREIGN KEY (`pizzeria_id`) REFERENCES `pizzeria`(`id`)
);


CREATE TABLE `eats` (
    `person_id` INT NOT NULL,
    `pizza_id` INT NOT NULL,
    FOREIGN KEY (`person_id`) REFERENCES `person`(`id`),
    FOREIGN KEY (`pizza_id`) REFERENCES `pizza`(`id`)
);
