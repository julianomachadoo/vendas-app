INSERT INTO categoria (nome) VALUES('COMPUTADORES');
INSERT INTO categoria (nome) VALUES('LIVROS');

INSERT INTO produto (nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES ('Ideapad S145', '2022-12-29 16:07:00', 'Notebook de uso pessoal da lenovo', 3000.00, 1);
INSERT INTO produto (nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES ('Acer Nitro 5', '2022-12-29 16:07:00', 'Notebook gamer da Acer', 5000.00, 1);
INSERT INTO produto (nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES ('Akira vol 1', '2022-12-29 16:07:00', 'Mangá', 60.00, 2);
INSERT INTO produto (nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES ('Akira vol 2', '2022-12-29 16:07:00', 'Mangá', 60.00, 2);

INSERT INTO cliente (nome, cpf, ativo) VALUES ('Fulano', '111.111.111-11', 1);
INSERT INTO cliente (nome, cpf, ativo) VALUES ('Cicrano', '123.456.789-10', 1);

INSERT INTO pedido (cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (1, '2022-12-29 16:14:00', 3000.00, 'APROVADO');
INSERT INTO pedido (cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (1, '2022-12-29 16:12:00', 3000.00, 'CANCELADO');
INSERT INTO pedido (cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (2, '2022-12-29 16:05:00', 120.00, 'ENVIADO');
INSERT INTO pedido (cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (2, '2022-12-19 16:05:00', 10000.00, 'CONCLUIDO');

INSERT INTO item_pedido (quantidade, pedido_id, produto_id)
    VALUES (1, 1, 1);
INSERT INTO item_pedido (quantidade, pedido_id, produto_id)
    VALUES (1, 2, 1);
INSERT INTO item_pedido (quantidade, pedido_id, produto_id)
    VALUES (1, 3, 3);
INSERT INTO item_pedido (quantidade, pedido_id, produto_id)
    VALUES (1, 3, 4);
INSERT INTO item_pedido (quantidade, pedido_id, produto_id)
    VALUES (2, 4, 2);


