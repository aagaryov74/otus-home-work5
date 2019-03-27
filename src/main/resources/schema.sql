DROP TABLE IF EXISTS writers;
CREATE TABLE writers(
  ID BIGINT  AUTO_INCREMENT PRIMARY KEY,
   NAME VARCHAR(255) not null,
  constraint writers_pk
    primary key (id)
);
DROP TABLE IF EXISTS books;
CREATE TABLE books(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  writer_id INT,
  genre_id INT,
  NAME VARCHAR(255)
);
DROP TABLE IF EXISTS genres;
create table genres
(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) not null,
  constraint genres_pk
    primary key (id)
);


