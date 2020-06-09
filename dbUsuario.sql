create database dbUsuario;

use dbUsuario;

create table tbUsuario(
nome varchar(100),
email varchar(100),
mobile varchar(9));

insert into tbUsuario(nome,email,mobile)values("Maria","maria@hotmail.com","98989-8585");
insert into tbUsuario(nome,email,mobile)values("Antonio","antonio@hotmail.com","98988-5858");

select * from tbUsuario;