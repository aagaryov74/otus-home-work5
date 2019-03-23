DROP TABLE IF EXISTS writers;
CREATE TABLE writers(
  ID INT PRIMARY KEY,
   NAME VARCHAR(255)
);
DROP TABLE IF EXISTS books;
CREATE TABLE books(
  ID INT PRIMARY KEY,
  writer_id INT,
  genre_id INT,
  NAME VARCHAR(255)
);
DROP TABLE IF EXISTS genre;
create table genre
(
  id int,
  name varchar(255) not null,
  constraint genre_pk
    primary key (id)
);


