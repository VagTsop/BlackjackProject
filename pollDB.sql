create database poll;
 use poll;

create table poll_users(
   user_id int  not null  Auto_increment,
   role_id int not null ,
   user_firstname varchar(30) not null,
   user_lastname varchar (30) not null,
   username varchar (25) not null unique,
   email varchar (30) not  null unique,
   
   password varchar (60) not null,
   primary key (user_id) ,
   foreign key (role_id) REFERENCES roles(role_id)
);
create table roles(
   role_id int  not null  Auto_increment,
   role_name varchar (25),
   primary key (role_id)
);
create table votes(
   vote_id int not null auto_increment,
   voter int  not null  unique,
   canditate int (25) not null,
   rating int(5),
   primary key (vote_id),
   foreign key (voter) REFERENCES poll_users(user_id),
   foreign key (canditate) REFERENCES poll_users(user_id)
   
);
INSERT INTO poll_users
VALUES (1, 1, "john","Doe","jdo","grerd");

INSERT INTO poll_users
VALUES (2, 1, "george","Bates","gbl","gbl");

INSERT INTO poll_users
VALUES (3, 2, "Nick","Fury","nfone","nfor");

INSERT INTO poll_users
VALUES (4, 2, "Peter","Parker","pkk","pgjs");

INSERT INTO roles
VALUES (1, "voter");

INSERT INTO roles
VALUES (2,"canditate");

INSERT INTO votes
VALUES (1, 1, 3, 4);

INSERT INTO votes
VALUES (2, 2, 4, 3);

INSERT INTO votes
VALUES (3, 3, 4, 2);

INSERT INTO votes
VALUES (4, 4, 3, 1);






