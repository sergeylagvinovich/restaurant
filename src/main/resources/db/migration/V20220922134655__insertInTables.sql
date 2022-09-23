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