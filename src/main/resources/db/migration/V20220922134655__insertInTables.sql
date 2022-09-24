--Заполнение таблицы ролей
insert into roles(name) values ('USER');
insert into roles(name) values ('ADMIN');
insert into roles(name) values ('COOK');
insert into roles(name) values ('COURIER');


--Заполнение таблицы пользователей
insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','admin','+5555555555','adminAll');

insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','admin','+5555555555','adminView');

insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','user','+5555555555','user');

insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','cook','+5555555555','cookAll');
insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','cook','+5555555555','cookView');

insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','courier','+5555555555','courierAll');
insert into users(email,name,password,phone,user_name)
    values ('123@gmail.com','Пользователь 1','courier','+5555555555','courierView');
--Заполнение таблицы с ролями для пользователя
--adminAll
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (true,true,true,true,2,1);
--adminView
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (false,false,false,true,2,2);
--user
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (true,true,true,true,1,3);
--cookAll
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (true,true,true,true,3,4);
--cookView
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (false,false,false,true,3,5);
--courierAll
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (true,true,true,true,4,6);
--courierView
insert into user_roles(can_delete,can_insert, can_update, can_view, role_id, user_id)
    values (false,false,false,true,4,7);

--
insert into dish_types(name) values ('Салаты и закуски');
insert into dish_types(name) values ('Блюда из свинины');
insert into dish_types(name) values ('Детское');
insert into dish_types(name) values ('Блюда из птицы');
insert into dish_types(name) values ('Блюда из рыбы');
insert into dish_types(name) values ('Соусы');
insert into dish_types(name) values ('Супы');
insert into dish_types(name) values ('Напитки');
insert into dish_types(name) values ('Десерты');
--

insert into units(name) values ('кг.');
insert into units(name) values ('г.');
insert into units(name) values ('мг.');
insert into units(name) values ('л.');
insert into units(name) values ('мл.');

insert into products(name,unit_id) values ('Картошка',1);
insert into products(name,unit_id) values ('Капуста',1);
insert into products(name,unit_id) values ('Масло подсолнечное',4);
insert into products(name,unit_id) values ('Масло сливочное',1);
insert into products(name,unit_id) values ('Свинина',1);
insert into products(name,unit_id) values ('Курица',1);
insert into products(name,unit_id) values ('Рыба',1);
insert into products(name,unit_id) values ('Кола',4);

insert into dishes(name,price,dish_type_id) values ('Скумбрия на гриле',20.99,5);
insert into dishes(name,price,dish_type_id) values ('Филе хека с морковью',26.99,5);
insert into dishes(name,price,dish_type_id) values ('Свинина по-охотничьи',10.00,2);
insert into dishes(name,price,dish_type_id) values ('Котлета из свинины',5.99,2);

insert into dish_products(dish_id,product_id,order_num,text) values (1,7,1,'что делать');
insert into dish_products(dish_id,product_id,order_num,text) values (1,2,2,'что делать');

insert into dish_products(dish_id,product_id,order_num,text) values (2,7,1,'что делать');
insert into dish_products(dish_id,product_id,order_num,text) values (2,2,1,'что делать');

insert into dish_products(dish_id,product_id,order_num,text) values (3,5,1,'что делать');
insert into dish_products(dish_id,product_id,order_num,text) values (3,1,2,'что делать');

insert into dish_products(dish_id,product_id,order_num,text) values (4,5,1,'что делать');

insert into order_statuses(name) values ('Обработка');
insert into order_statuses(name) values ('Готовиться');
insert into order_statuses(name) values ('Доставка');
