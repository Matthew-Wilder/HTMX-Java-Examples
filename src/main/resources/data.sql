INSERT INTO `gender`
(`id`,`name`)
VALUES
    (1, 'Male'),
    (2, 'Female'),
    (3, 'Prefer not to say');

INSERT INTO `person`
(`id`, `name`, `age`, `gender_id`)
VALUES
    (1, 'Amy', 16, 2),
    (2, 'Ben', 21, 1),
    (3, 'Cal', 33, 1),
    (4, 'Dan', 13, 1),
    (5, 'Eli', 45, 1),
    (6, 'Fay', 21, 2),
    (7, 'Gus', 24, 1),
    (8, 'Hil', 30, 2),
    (9, 'Ian', 18, 1);

INSERT INTO `pizzeria`
(`id`, `name`)
VALUES
    (1, 'Chicago Pizza'),
    (2, 'Dominos'),
    (3, 'Little Caesars'),
    (4, 'New York Pizza'),
    (5, 'Pizza Hut'),
    (6, 'Straw Hat');

INSERT INTO `pizza`
(`id`, `name`)
VALUES
    (1, 'cheese'),
    (2, 'supreme'),
    (3, 'mushroom'),
    (4, 'pepperoni'),
    (5, 'sausage');

INSERT INTO `serves`
(`pizzaria_id`, `pizza_id`, `price`)
VALUES
    (1, 1, 7.75),
    (1, 2, 8.5),
    (2, 1, 9.75),
    (2, 3, 11),
    (3, 1, 7),
    (3, 3, 9.25),
    (3, 4, 9.75),
    (3, 5, 9.5),
    (4, 1, 7),
    (4, 4, 8),
    (4, 2, 8.5),
    (5, 1, 9),
    (5, 4, 12),
    (5, 5, 12),
    (5, 2, 12),
    (6, 1, 9.25),
    (6, 4, 8),
    (6, 5, 9.75);

INSERT INTO `frequents`
(`person_id`, `pizzaria_id`)
VALUES
    (1, 5),
    (2, 1),
    (2, 5),
    (3, 4),
    (3, 6),
    (4, 4),
    (4, 6),
    (5, 1),
    (5, 6),
    (6, 2),
    (6, 3),
    (7, 1),
    (7, 5),
    (8, 2),
    (8, 5),
    (8, 6),
    (9, 2),
    (9, 4),
    (9, 6);

INSERT INTO `eats`
(`person_id`, `pizza_id`)
VALUES
    (1, 3),
    (1, 4),
    (2, 1),
    (2, 4),
    (3, 2),
    (4, 1),
    (4, 2),
    (4, 3),
    (4, 4),
    (4, 5),
    (5, 1),
    (5, 2),
    (6, 3),
    (7, 1),
    (7, 2),
    (7, 3),
    (8, 1),
    (8, 2),
    (9, 2),
    (9, 4);
