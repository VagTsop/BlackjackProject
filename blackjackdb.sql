create database blackjack;
 use blackjack;

create table blackjack_players(
   player_id int  not null  Auto_increment,
   role_id int not null ,
   firstname varchar(30) not null,
   lastname varchar (30) not null,
   username varchar (25) not null unique,
   email varchar (30) not  null unique,
   password varchar (60) not null,
   profile_photo_name varchar(45) ,
   profile_photo_data longblob ,
   balance decimal(13,2),
   active bit(1) not null default 0,

   primary key (player_id) ,
   foreign key (role_id) REFERENCES roles(role_id)
     );
   create table roles(
   role_id int  not null  Auto_increment,
   role varchar (25),
   primary key (role_id)
   
);

   
   
   DELETE FROM `blackjack_players` WHERE player_id=21;
   
   drop table confirmation_token;