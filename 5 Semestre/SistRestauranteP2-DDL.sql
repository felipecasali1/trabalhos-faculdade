CREATE DATABASE bancorestaurante;

CREATE TABLE bairro (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(100) NOT NULL
);

CREATE TABLE taxa_entrega (
	id SERIAL PRIMARY KEY NOT NULL,
	taxa FLOAT NOT NULL,
	entrega_id INTEGER NOT NULL,
	FOREIGN KEY (entrega_id) REFERENCES entrega(id)
);

CREATE TABLE endereco (
	id SERIAL PRIMARY KEY NOT NULL,
	rua varchar(100) NOT NULL,
	cep varchar(9) NOT NULL,
	bairro_id INTEGER NOT NULL,
	distancia FLOAT NOT NULL,
	FOREIGN KEY (bairro_id) REFERENCES bairro(id)
);

CREATE TABLE delivery (
	id SERIAL PRIMARY KEY NOT NULL,
	numero varchar(10) NOT NULL,
	complemento varchar(50) NOT NULL,
	endereco_id INTEGER NOT NULL,
	FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE login (
	id SERIAL PRIMARY KEY NOT NULL,
	usuario varchar(50) NOT NULL,
	senha varchar(255) NOT NULL
);

CREATE TABLE telefone (
	id SERIAL PRIMARY KEY NOT NULL,
	numero varchar(20) NOT NULL,
	ddd char(2) NOT NULL,
	cliente_id INTEGER,
	funcionario_id INTEGER,
	FOREIGN KEY (cliente_id) REFERENCES cliente(id),
	FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);

CREATE TABLE funcionario (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(100) NOT NULL,
	cpf varchar(14) NOT NULL,
	rg varchar(12) NOT NULL,
	login_id INTEGER NOT NULL,
	FOREIGN KEY (login_id) REFERENCES login(id),
);

CREATE TABLE cliente (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(100) NOT NULL
);

CREATE TABLE status_pedido (
	id SERIAL PRIMARY KEY NOT NULL,
	status varchar(50) NOT NULL
);

CREATE TABLE ingrediente_remover (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(50) NOT NULL,
	ing_escolha_id INTEGER NOT NULL,
	FOREIGN KEY (ing_escolha_id) REFERENCES ingrediente_escolha(id)
);

CREATE TABLE ingrediente_adicionar (
	id SERIAL PRIMARY KEY NOT NULL,
	nome varchar(50) NOT NULL,
	valor NUMERIC(10,2) NOT NULL,
	ing_escolha_id INTEGER NOT NULL,
	FOREIGN KEY (ing_escolha_id) REFERENCES ingrediente_escolha(id)
);

CREATE TABLE ingrediente_escolha (
	id SERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE produto (
	id SERIAL PRIMARY KEY NOT NULL,
	valor NUMERIC(10,2) NOT NULL,
	nome varchar(50) NOT NULL
);

CREATE TABLE carrinho (
	id SERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE carrinho_produto (
	id SERIAL PRIMARY KEY NOT NULL,
	carrinho_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    ing_escolha_id INTEGER,
    FOREIGN KEY (carrinho_id) REFERENCES carrinho(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    FOREIGN KEY (ing_escolha_id) REFERENCES ingrediente_escolha(id)
);

CREATE TABLE reembolso (
	id SERIAL PRIMARY KEY NOT NULL,
	motivo varchar(100) NOT NULL
);

CREATE TABLE pedido (
	id SERIAL PRIMARY KEY NOT NULL,
	data TIMESTAMP NOT NULL,
	cliente_id INTEGER NOT NULL,
	carrinho_id INTEGER NOT NULL,
	status_pedido_id INTEGER NOT NULL,
	reembolso_id INTEGER,
	FOREIGN KEY (cliente_id) REFERENCES cliente(id),
	FOREIGN KEY (carrinho_id) REFERENCES carrinho(id),
	FOREIGN KEY (status_pedido_id) REFERENCES status_pedido(id),
	FOREIGN KEY (reembolso_id) REFERENCES reembolso(id)
);

CREATE TABLE entrega (
	id SERIAL PRIMARY KEY NOT NULL,
	cliente_id INTEGER NOT NULL,
	delivery_id INTEGER NOT NULL,
	pedido_id INTEGER NOT NULL,
	tipo varchar(30) NOT NULL,
	FOREIGN KEY (cliente_id) REFERENCES cliente(id),
	FOREIGN KEY (delivery_id) REFERENCES delivery(id),
	FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);

CREATE TABLE cupom (
	id SERIAL PRIMARY KEY NOT NULL,
	porcentagem FLOAT NOT NULL,
	codigo varchar(25) NOT NULL,
	validade TIMESTAMP NOT NULL,
	ativo BOOLEAN NOT NULL
);

CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL,
    chave_pix VARCHAR(100),
    tipo_cartao VARCHAR(10),
    valor_recebido NUMERIC(10,2),
    valor_troco NUMERIC(10,2),
    cupom_id INTEGER,
    pedido_id INTEGER NOT NULL,
    FOREIGN KEY (cupom_id) REFERENCES cupom(id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
