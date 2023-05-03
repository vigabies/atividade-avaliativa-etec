Create table Cliente (
    id int not null auto_increment primary key,
    nome varchar (100)
);

insert into cliente(nome) values('Nana Nenem');

--=====================

Create Table ContaPagar(
    id int not null auto_increment primary key,
    data date,
    datavenc date,
    valor decimal(16,2),
    idcliente int not null
);

Alter table ContaPagar add constraint FK_ContaPagar_Cliente foreign key (idcliente) REFERENCES cliente(id);

insert into ContaPagar(data, datavenc, valor, idcliente) values ('2023/02/01', '2023/02/12', 2000, 1);
insert into ContaPagar(data, datavenc, valor, idcliente) values ('2023/12/24', '2023/12/31', 1000, 1);
insert into ContaPagar(data, datavenc, valor, idcliente) values ('2023/09/11', '2023/09/18', 900, 1);
