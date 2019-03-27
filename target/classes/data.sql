insert into writers
  (id, name)
values (1, 'А. С. Пушкин');
insert into writers
  (id, name)
values (2, 'М. Ю. Лермонтов');

insert into genres
  (id,name)
values (1,'Драма');
insert into genres
(id,name)
values (2,'Сказки');


insert into books
  (id, writer_id,
   genre_id,name)
      values (1, 1, 1, 'Капитанская дочка');
insert into books
  (id, writer_id,
   genre_id, name)
 values (2, 1, 2,'Сказки');

