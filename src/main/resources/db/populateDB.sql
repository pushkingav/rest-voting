DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM users;
DELETE FROM restaurants;
DELETE FROM MENU;
DELETE FROM votes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
                                                 ('User', 'user@yandex.ru', 'password'),
                                                 ('Admin','admin@gmail.com' ,'admin'),
																								 ('User1', 'user1@yandex.ru', 'password'),
																								 ('User2', 'user2@yandex.ru', 'password'),
																								 ('User3', 'user3@yandex.ru', 'password');

INSERT INTO user_roles (role, user_id) VALUES
                                              ('ROLE_USER', 100000),
																							('ROLE_ADMIN', 100001),
																							('ROLE_USER', 100002),
																							('ROLE_USER', 100003),
																							('ROLE_USER', 100004);
INSERT INTO restaurants (name)
VALUES  ('Петр Петрович'),
        ('Beerlin'),
        ('Столовая Полюшко');

INSERT INTO dishes (description)
VALUES ('Овсянка'), ('Омлет'), ('Салатик'), ('Стейк'),
       ('Гренки'), ('Борщ'), ('Цыпленок табака'), ('Пиво'), ('Тарелка овощная');

INSERT INTO votes (user_id, date, restaurant_id) values (100000, NOW, 100005),
																												(100001, NOW, 100005),
																												(100002, NOW, 100006),
																												(100003, NOW, 100007),
																												(100004, NOW, 100007);
