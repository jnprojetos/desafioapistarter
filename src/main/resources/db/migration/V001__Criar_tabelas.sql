 CREATE TABLE perfil
 (
	id bigint(20) not null auto_increment primary key,
    nome varchar(50) not null
 );

 CREATE TABLE categoria
 (
	id bigint not null auto_increment primary key,
    descricao varchar(255) not null,
    tecnologia varchar(255) not null
 );

 CREATE TABLE usuario
 (
	id bigint not null auto_increment primary key,
    email varchar(255) not null,
    nome varchar(255) not null,
    senha varchar(255) not null,
    perfil_id bigint(20) not null,
    foreign key (perfil_id) references perfil(id)
 );

 CREATE TABLE starter
 (
	id bigint not null auto_increment primary key,
    nome varchar(255) not null,
    cpf varchar(11) not null,
    quatro_letras varchar(4) not null,
    email varchar(255) not null,
    imagem blob,
    categoria_id bigint(20) not null,
    foreign key (categoria_id) references categoria(id)
 );