DELETE FROM user_roles;
DELETE FROM dishes;
DELETE FROM users;
DELETE FROM restaurants;
DELETE FROM MENU;
DELETE FROM votes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
                                                 ('User', 'user@yandex.ru', 'password'),
                                                 ('Admin','admin@gmail.com' ,'admin');

INSERT INTO user_roles (role, user_id) VALUES
                                              ('ROLE_USER', 100000),
                                              ('ROLE_ADMIN', 100001);
INSERT INTO restaurants (name)
VALUES  ('Петр Петрович'),
        ('Beerlin'),
        ('Столовая Полюшко');

INSERT INTO dishes (description, date, price, restaurant_id)
VALUES ('Овсянка', '2015-05-30', '70.00', 100004),
       ('Омлет', '2015-05-30', '85.00', 100004),
       ('Салатик', '2015-05-30', '60.00', 100004),
       ('Стейк', '2015-05-30', '1200.00', 100002),
       ('Гренки', '2015-05-30', '250.00', 100002),
       ('Борщ', '2015-05-30', '200.00', 100002),
       ('Цыпленок табака', '2015-05-30', '1000.00', 100003),
       ('Пиво', '2015-05-30', '150.00', 100003),
       ('Тарелка овощная', '2015-05-30', '350.00', 100003);
