create table categoria(
    id bigint primary key not null auto_increment,
    nome varchar(50) not null unique
);

create table produto(
    id bigint primary key not null auto_increment,
    nome varchar(100) not null,
    data_cadastro smalldatetime	 not null,
    descricao varchar(255),
    preco_unitario decimal(10,2) not null,
    categoria_id bigint not null foreign key references categoria(id)
);

create table cliente(
    id bigint primary key not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(14) not null unique
);

create table pedido(
    id bigint primary key not null auto_increment,
    cliente_id bigint not null foreign key references cliente(id),
    data_pedido smalldatetime not null,
    valor_total decimal(10,2) not null,
    status_pedido varchar(20) not null
);

create table item_pedido(
    id bigint primary key not null auto_increment,
    quantidade integer not null,
    pedido_id bigint not null foreign key references pedido(id),
    produto_id bigint not null foreign key references produto(id)
);