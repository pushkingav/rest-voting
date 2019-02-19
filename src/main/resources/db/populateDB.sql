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

INSERT INTO dishes (description)
VALUES ('Овсянка'), ('Омлет'), ('Салатик'), ('Стейк'),
       ('Гренки'), ('Борщ'), ('Цыпленок табака'), ('Пиво'), ('Тарелка овощная');
