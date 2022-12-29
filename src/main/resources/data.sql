INSERT INTO categoria (id, nome) VALUES(1, 'Computadores');
INSERT INTO categoria (id, nome) VALUES(2, 'Livros');

INSERT INTO produto (id, nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES (1, 'Ideapad S145', '2022-12-29 16:07:00', 'Notebook de uso pessoal da lenovo', 3000.00, 1);
INSERT INTO produto (id, nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES (2, 'Acer Nitro 5', '2022-12-29 16:07:00', 'Notebook gamer da Acer', 5000.00, 1);
INSERT INTO produto (id, nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES (3, 'Akira vol 1', '2022-12-29 16:07:00', 'Mangá', 60.00, 2);
INSERT INTO produto (id, nome, data_cadastro, descricao, preco_unitario, categoria_id)
    VALUES (4, 'Akira vol 2', '2022-12-29 16:07:00', 'Mangá', 60.00, 2);

INSERT INTO cliente (id, nome, cpf) VALUES (1, 'Fulano', '111.111.111-11');
INSERT INTO cliente (id, nome, cpf) VALUES (2, 'Cicrano', '123.456.789-10');

INSERT INTO pedido (id, cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (1, 1, '2022-12-29 16:14:00', 3000.00, 'APROVADO');
INSERT INTO pedido (id, cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (2, 1, '2022-12-29 16:12:00', 3000.00, 'CANCELADO');
INSERT INTO pedido (id, cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (3, 2, '2022-12-29 16:05:00', 120.00, 'ENVIADO');
INSERT INTO pedido (id, cliente_id, data_pedido, valor_total, status_pedido)
    VALUES (4, 2, '2022-12-19 16:05:00', 10000.00, 'CONCLUIDO');

INSERT INTO item_pedido (id, quantidade, pedido_id, produto_id)
    VALUES (1, 1, 1, 1);
INSERT INTO item_pedido (id, quantidade, pedido_id, produto_id)
    VALUES (2, 1, 2, 1);
INSERT INTO item_pedido (id, quantidade, pedido_id, produto_id)
    VALUES (3, 1, 3, 3);
INSERT INTO item_pedido (id, quantidade, pedido_id, produto_id)
    VALUES (4, 1, 3, 4);
INSERT INTO item_pedido (id, quantidade, pedido_id, produto_id)
    VALUES (5, 2, 4, 2);


