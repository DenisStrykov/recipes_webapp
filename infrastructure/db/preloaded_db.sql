
-- CREATE
-- DATABASE recipessource
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

--        Надо ли подключаться?

chmod 777;

CONNECT TO recipessource;

CREATE TABLE event
(
    id        INT8 GENERATED BY DEFAULT AS IDENTITY,
    date      VARCHAR(255),
    location  VARCHAR(255),
    name      VARCHAR(255),
    photo_url VARCHAR(255),
    tradition VARCHAR(7500),
    recipe_id INT8 NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE recipes
(
    id                INT8 GENERATED BY DEFAULT AS IDENTITY,
    created_date_time TIMESTAMP,
    photo_url         VARCHAR(255),
    recipe_content    VARCHAR(7500),
    recipe_title      VARCHAR(255),
    update_date_time  TIMESTAMP,
    created_by        INT8 NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   INT8 GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id       INT8 GENERATED BY DEFAULT AS IDENTITY,
    email    VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
    user_id INT8 NOT NULL,
    role_id INT8 NOT NULL
);

ALTER TABLE IF EXISTS event ADD CONSTRAINT FKs0d4oegtq5sif4e0eoxxt9u5i FOREIGN KEY (recipe_id) REFERENCES recipes(id); -- recipes(id)

ALTER TABLE IF EXISTS recipes ADD CONSTRAINT FK562qxrf6asv465kol8skqtgx8 FOREIGN KEY (created_by) REFERENCES users(id);

ALTER TABLE IF EXISTS users_roles ADD CONSTRAINT FKj6m8fwv7oqv74fcehir1a9ffy FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE IF EXISTS users_roles ADD CONSTRAINT FK2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES users(id);


INSERT INTO roles(name)
VALUES ('admin');

INSERT INTO roles(name)
VALUES ('user');

INSERT INTO users (email, password, username)
VALUES ('admin', '$2a$10$8SxEj6gQjNmbsdWZ26AI/urvAc2W4iFjUcjJu6Lb/N5JWeJrNMx8O', 'admin');

INSERT INTO recipes (created_by, created_date_time, photo_url, recipe_content, recipe_title, update_date_time)
VALUES ('1', '2023-10-14 19:54:49.522580',
        'https://o-tendencii.com/uploads/posts/2022-03/1646158220_40-o-tendencii-com-p-appetitnie-blini-foto-45.jpg', 'Молоко - 0,5 л.
Яйца - 3 шт.
Масло растительное - 1 ст. ложка + для смазывания сковороды.
Мука - 250 г
Сахар - 1 ст. ложка.
Соль - 1 щепотка.
Масло сливочное - 1 ст. ложка.
1. Миксером взбить яйца с солью до пены. Продолжая взбивать, влить горячую воду, а затем холодное молоко.
2. Добавить просеянную муку, перемешать миксером и влить растительное масло. Убрать в холодильник на 30 минут.
3. Хорошо разогреть сковороду, слегка смазать ее топленым маслом и налить на нее столько теста, сколько нужно, чтобы получить тонкий блинчик. Жарить по 1–2 минуты с каждой стороны.',
        'Блины традиционные', '2023-10-14 19:54:49.522580'),
       ('1', '2023-10-14 20:04:41.589534', 'https://thebrilliantkitchen.com/wp-content/uploads/2022/08/Bloody-Mary.jpg', 'Водка - 250 мл.
Томатный сок - 1 л.
Вустерширский соус - 6 столовых ложек.
Лимон - по вкусу.
Сельдерей - 6 штук.
ИНСТРУКЦИЯ ПРИГОТОВЛЕНИЯ
1. Подготовить все ингредиенты.
2. Перемешать все ингредиенты и разлить по бокалам со льдом.
3. Украсить кусочками лимона, в каждый бокал положить по палочке сельдерея (для помешивания) и подавать.',
        'Коктейль «Кровавая Мэри»', '2023-10-14 20:04:41.589534'),
       ('1', '2023-10-14 20:07:21.833000',
        'https://mir-s3-cdn-cf.behance.net/project_modules/fs/a164bf91539421.5e34324a88257.jpg', 'Молоко - 300 мл.
Масло сливочное - 250 г.
Мука - 600 г (4 стакана объёмом 250 мл).
Сахар - 3 ст. ложки.
Соль - 1 ч. ложка.
Дрожжи сухие активные - 2 ч. ложки.
РЕЦЕПТ ПРИГОТОВЛЕНИЯ
1. В большой миске смешать сухие ингредиенты. Влить молоко. Замесить тесто.
Выложить тесто на доску, посыпанную мукой, и вымешивать 5-10 минут, до эластичности. Переложить в миску, накрыть и поставить в теплое место, чтобы тесто увеличилось в размерах вдвое.
2. В это время выложить размягченное сливочное масло между двумя листами пергаментной бумаги и раскатать его в прямоугольник толщиной примерно 7 мм. Охладить полученный прямоугольник масла.
3. Подошедшее тесто обмять и вымесить 1 минуту. Вынуть масло из холодильника, разделить на две части.
На посыпанной мукой поверхности раскатать тесто в прямоугольный пласт размером примерно 20х45 см.
Выложить одну часть масла на половину раскатанного теста (вдоль длинной стороны), накрыть второй половиной теста. Выложить сверху вторую часть масла. Завернуть короткие стороны получившегося прямоугольника теста с маслом к центру, прижимая. Раскатать в прямоугольный пласт. Сложить вчетверо. Завернуть в пленку и поместить в холодильник. Снова раскатать и сложить вчетверо. Повторить процесс раскатки теста еще два раза, охлаждая тесто в холодильнике.
Разрезать слоеное дрожжевое тесто на две части. Половину теста раскатать в пласт толщиной 7-8 мм (вторую половину теста завернуть в плёнку и поместить в холодильник, или заморозить впрок). Вырезать из теста треугольники с боковыми сторонами 20 см и основанием около 18 см (получилось шесть штук). Точно так же поступить со второй половиной теста.',
        'Круассан ', '2023-10-14 20:14:59.785689'),
       ('1', '2023-10-14 20:22:08.636814',
        'https://www.zipangprovisions.com/wp-content/uploads/2021/02/Health-advantages-of-consuming-cakes.jpg', 'Пшеничная мука - 530 г.
Сахар - 300 г.
Какао-порошок - 300 г.
Сода - 1 чайная ложка.
Разрыхлитель - 1,5 чайных ложек.
Соль - 1,5 чайных ложек.
Куриное яйцо - 4 штуки.
Пахта - 360 мл.
Вода - 360 мл.
Растительное масло - 120 мл.
Ванильный экстракт - 5 чайных ложек.
Сливочное масло - 340 г.
Сливочный сыр - 225 г.
Сахарная пудра - 600 г.
Молоко - 60 мл.
РЕЦЕПТ ПРИГОТОВЛЕНИЯ
1. Смешать муку, сахар, половину какао, соду, разрыхлитель и соль.
2. Добавить яйца, пахту, теплую воду, растительное масло и ваниль. Перемешать миксером на средней скорости до однородного состояния.
3. Смазать две формы диаметром 23 см сливочным маслом, затем просыпать их мукой либо проложить их пергаментом. Разделить тесто на две равные части и переложить в формы. Запекать при 180 градусах 30–35 минут.
4. Готовые коржи переложить на решетку и дать им остыть в течение 15 минут.
5. Для крема взбить размягченное сливочное масло со сливочным сыром до пышной массы. Добавить какао и ванильный экстракт, перемешать, затем постепенно вмешать сахарную пудру. Если крем получается слишком густым, можно добавить немного молока.
6. Собрать торт, смазав коржи кремом. Можно есть его сразу, но лучше оставить часа на три в холодильнике.',
        'Шоколадный торт', '2023-10-14 20:22:08.636814');

INSERT INTO event (date, location, name, photo_url, recipe_id, tradition)
VALUES ('56 дней от даты Пасхи', 'Россия', 'Масленица', 'https://volontermo.ru/b/c/25870.jpg', '1',
        'Масленица — один из самых известных старинных народных праздников, который продолжают отмечать до сих пор. Торжество длится целую неделю и предваряет Великий пост: в эти дни пекут блины и сжигают чучело, чтобы проводить зиму и встретить весну. «Лента.ру» рассказывает, когда масленичная неделя начнется в 2024 году, а также вспоминает историю и традиции праздника. Масленица отмечается в течение недели перед Великим постом. Сразу после масленичной недели наступает Чистый понедельник, который в 2024 году выпадает на 18 марта. Это начало Великого поста, который продлится 40 дней.'),
       ('каждый год 30 января', 'США', 'День круасана',
        'https://lp-cms-production.imgix.net/2022-07/GettyRF_1070622360.jpg?auto=format&q=75&w=1920', '3',
        'В Соединенных Штатах Национальный День Круассана отмечается каждый год 30 января. Круассаны - это масляные рулетики в форме полумесяца, которые хрустящие снаружи и мягкие внутри.'),
       ('каждый год 27 января', 'США', 'День шоколадного торта',
        'https://zbuzz.de/wp-content/uploads/2021/11/Lustige-Geburtstagssprüche-für-Frauen.jpeg', '4',
        'Национальный день шоколадного торта - неофициальный праздник, который отмечается 27 января каждого года. Этот день посвящен этому сладкому удовольствию, которое было частью американского общества около 252 лет.');
































