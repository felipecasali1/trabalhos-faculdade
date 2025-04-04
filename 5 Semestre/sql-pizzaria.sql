-- CRIAÇÃO DE TABELAS E POPULAÇÃO FEITOS PELO PROFESSOR

-- CRIA BANCO DE DADOS
CREATE DATABASE trab_pizzaria;

-- CRIA TABELAS
CREATE TABLE tb_cliente(
id_cliente SERIAL PRIMARY KEY NOT NULL,
nome VARCHAR(100) NOT NULL
);

CREATE TABLE tb_sabor(
id_sabor SERIAL PRIMARY KEY NOT NULL,
nome VARCHAR(100) NOT NULL,
preco NUMERIC(12,2) NOT NULL
);

CREATE TABLE tb_pedido(
id_pedido SERIAL PRIMARY KEY NOT NULL,
id_cliente INTEGER NOT NULL,
data_pedido TIMESTAMP NOT NULL,
preco_entrega NUMERIC(12,2) NOT NULL,
FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente)
);

CREATE TABLE rl_pedido_pizza(
id_pedido INTEGER NOT NULL,
id_sabor_1 INTEGER NOT NULL,
id_sabor_2 INTEGER NOT NULL,
qntd INTEGER NOT NULL,
preco_pizza NUMERIC(12,2) NOT NULL,
PRIMARY KEY(id_pedido, id_sabor_1, id_sabor_2),
FOREIGN KEY(id_pedido) REFERENCES tb_pedido(id_pedido),
FOREIGN KEY(id_sabor_1) REFERENCES tb_sabor(id_sabor),
FOREIGN KEY(id_sabor_2) REFERENCES tb_sabor(id_sabor)
);

-- POPULA TABELAS
INSERT INTO tb_cliente(nome) VALUES
('JOSÉ'), ('MARIA'), ('JOÃO'), ('ANTÔNIA'), ('SÍLVIO'), ('MARCOS'), ('NEIDE'), ('FELIPE'), ('ANDRÉ'), ('CRISTIANE'), ('LUIZA'), ('MARGARIDA');

INSERT INTO tb_sabor(nome, preco) VALUES
('CALABRESA', 52.00), ('FRANGO CATUPIRY', 54.00), ('BAIANA', 52.00), ('PANTANEIRA', 57.00), ('BACON', 59.00), ('CALABACON', 58.00), 
('PAULISTA', 60.00), ('PORTUGUESA', 61.00), ('PEPPERONI', 27.00);

INSERT INTO tb_pedido(id_cliente, data_pedido, preco_entrega) VALUES
(1, '2025-03-25 19:45:00', 8.00), (2, '2025-03-25 19:47:15', 5.00), (3, '2025-03-25 20:20:20', 9.00), (4, '2025-03-25 20:22:21', 0.00), 
(5, '2025-03-25 20:25:14', 7.00), (6, '2025-03-30 20:00:12', 7.50), (2, '2025-03-30 20:31:15', 0.00), (4, '2025-03-30 21:45:42', 0.00);

INSERT INTO rl_pedido_pizza(id_pedido, id_sabor_1, id_sabor_2, qntd, preco_pizza) VALUES
(1, 1, 1, 1, 52.00), (1, 2, 2, 1,54.00), (2, 9, 6, 1, 54.00), (2, 1, 2, 1, 53.00), (2, 7, 8, 1, 61.00), (3, 3, 7, 1, 56.00), 
(4, 1, 2, 1, 53.00), (5, 1, 9, 1,53.00), (5, 2, 2, 1, 54.00), (6, 3, 3, 1, 52.00), (6, 9, 9, 1, 54.00), (7, 7, 7, 2, 120.00), 
(8, 1, 1, 3, 156.00);