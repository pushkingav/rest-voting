DELETE FROM menu;
DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM users;
DELETE FROM restaurants;

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

-- Prices are given in kopecks/cents
INSERT INTO menu (restaurant_id, dish_id, date, price) VALUES (100005, 100008, NOW, 5000),
																															(100005, 100009, NOW, 7550),
																															(100005, 100010, NOW, 10000),
																															(100005, 100011, NOW, 50000),
																															(100006, 100012, NOW, 9550),
																															(100006, 100013, NOW, 8350),
																															(100006, 100014, NOW, 25000),
																															(100006, 100015, NOW, 15000),
																															(100007, 100016, NOW, 11000),
																															(100007, 100008, NOW, 7550),
																															(100007, 100009, NOW, 9050),
																															(100007, 100011, NOW, 65000);


INSERT INTO votes (user_id, date, restaurant_id) VALUES (100000, NOW, 100005),
																												(100001, NOW, 100005),
																												(100002, NOW, 100006),
																												(100003, NOW, 100007),
																												(100004, NOW, 100007);
