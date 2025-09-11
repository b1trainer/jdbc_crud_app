INSERT INTO writers (firstName, lastName)
VALUES ('Ivan', 'Ivanov'),
       ('Pyotr', 'Petrov'),
       ('Maria', 'Sidorova'),
       ('Anna', 'Kuznetsova'),
       ('Sergey', 'Smirnov');

INSERT INTO posts (content, writerId)
VALUES ('My first post about programming in Java. I talk about the basics of OOP.', 1),
       ('Today I want to share my impressions of the new version of Spring Framework.', 1),
       ('The recipe for perfect coffee for a programmer: choosing beans, grind, and brewing.', 3),
       ('Review of the latest trends in web development for 2024.', 2),
       ('How I started learning Python and what came of it. Personal experience.', 4),
       ('SQL query optimization: best practices and common mistakes.', 5),
       ('Setting up Docker for local development: a detailed guide.', 2),
       ('Artificial intelligence in everyday life: what AI can do right now.', 4);

INSERT INTO post_status (id, status)
VALUES (1, 'ACTIVE'),
       (2, 'ACTIVE'),
       (3, 'ACTIVE'),
       (4, 'UNDER_REVIEW'),
       (5, 'ACTIVE'),
       (6, 'UNDER_REVIEW'),
       (7, 'ACTIVE'),
       (8, 'UNDER_REVIEW');

INSERT INTO labels (name)
VALUES ('Programming'),
       ('Java'),
       ('Spring'),
       ('Coffee'),
       ('Web Development'),
       ('Python'),
       ('SQL'),
       ('Docker'),
       ('AI'),
       ('Personal Experience'),
       ('Tutorial');

INSERT INTO posts_labels (post_id, label_id)
VALUES (1, 1),
       (1, 2),
       (1, 10),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 4),
       (4, 1),
       (4, 5),
       (5, 1),
       (5, 6),
       (5, 10),
       (6, 1),
       (6, 7),
       (6, 11),
       (7, 1),
       (7, 8),
       (7, 11),
       (8, 1),
       (8, 9);