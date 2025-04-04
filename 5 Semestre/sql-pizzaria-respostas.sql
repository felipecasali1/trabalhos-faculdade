select * from tb_cliente;
select * from tb_pedido;
select * from rl_pedido_pizza;
select * from tb_sabor;

-- QUESTÃO 1 (VIEW) - MOSTRA OS SABORES, QUANTIDADE DE PEDIDOS POR SABOR E O VALOR UNITÁRIO

CREATE OR REPLACE VIEW vw_mostrar_itens AS
SELECT 
	sabor1.nome AS nome_sabor1, 
	sabor2.nome AS nome_sabor2, 
	SUM(pizza.qntd) AS qntd_pizzas_vendidas, 
	AVG((sabor1.preco + sabor2.preco)/2) AS preco_por_pizza
FROM rl_pedido_pizza pizza
INNER JOIN tb_sabor sabor1 ON pizza.id_sabor_1 = sabor1.id_sabor
INNER JOIN tb_sabor sabor2 ON pizza.id_sabor_2 = sabor2.id_sabor
GROUP BY nome_sabor1, nome_sabor2
ORDER BY qntd_pizzas_vendidas DESC;

select * from vw_mostrar_itens;

-- QUESTÃO 2 (FUNCTION) - RETORNA O FATURAMENTO DO DIA ESPECIFICADO

CREATE OR REPLACE FUNCTION fn_valor_faturado_data(IN data TIMESTAMP)
RETURNS FLOAT AS $$
DECLARE
	total FLOAT DEFAULT 0;
BEGIN
	SELECT 
	SUM(pizza.preco_pizza) + SUM(DISTINCT tb_pedido.preco_entrega)
	INTO total
	FROM tb_pedido
	INNER JOIN rl_pedido_pizza AS pizza ON pizza.id_pedido = tb_pedido.id_pedido
	WHERE DATE(tb_pedido.data_pedido) = DATE(data);
	
	RETURN total;
END;
$$ LANGUAGE plpgsql;

select fn_valor_faturado_data('2025-03-25');

-- QUESTÃO 3 (STORED PROCEDURE) - REALIZA PEDIDOS, CALCULA E FAZ VERIFICAÇÕES

CREATE OR REPLACE PROCEDURE sp_realizar_pedido(IN nome_cliente VARCHAR(100), IN valor_entrega FLOAT, IN nome_sabor_1 VARCHAR(100), IN nome_sabor_2 VARCHAR(100), IN qntd_pedido INTEGER)
AS $$
DECLARE
	saborExiste INTEGER;
	clienteId INTEGER;
	pedidoId INTEGER;
	sabor1Id INTEGER;
	sabor2Id INTEGER;
	totalPizzas FLOAT;
BEGIN
	IF qntd_pedido IS NULL OR qntd_pedido < 1 THEN
    	RAISE EXCEPTION 'Erro: Quantidade de pedidos inválida!';
	END IF;

	IF valor_entrega IS NULL OR valor_entrega < 0 THEN
		RAISE EXCEPTION 'Erro: Valor da entrega inválido!';
	END IF;
	
	SELECT COUNT(*) INTO saborExiste
	FROM tb_sabor
	WHERE UPPER(tb_sabor.nome) = UPPER(nome_sabor_1) OR tb_sabor.nome = UPPER(nome_sabor_2);
		
	IF saborExiste < 2 THEN
		RAISE EXCEPTION 'Erro: Sabor inexistente!';
	END IF;
	
	IF EXISTS (SELECT 1 FROM tb_cliente WHERE tb_cliente.nome = nome_cliente) THEN
		SELECT id_cliente INTO clienteId FROM tb_cliente WHERE tb_cliente.nome = nome_cliente;
	ELSE 
		INSERT INTO tb_cliente(nome) VALUES (nome_cliente) RETURNING id_cliente INTO clienteId;
	END IF;

	INSERT INTO tb_pedido(id_cliente, data_pedido, preco_entrega) VALUES (clienteId, NOW(), valor_entrega) RETURNING id_pedido INTO pedidoId;
	
	SELECT id_sabor INTO sabor1Id FROM tb_sabor WHERE UPPER(tb_sabor.nome) = UPPER(nome_sabor_1);
	SELECT id_sabor INTO sabor2Id FROM tb_sabor WHERE UPPER(tb_sabor.nome) = UPPER(nome_sabor_2);
	SELECT SUM(tb_sabor.preco/2) * qntd_pedido INTO totalPizzas FROM tb_sabor WHERE tb_sabor.id_sabor = sabor1Id OR tb_sabor.id_sabor = sabor2Id;
	
	INSERT INTO rl_pedido_pizza(id_pedido, id_sabor_1, id_sabor_2, qntd, preco_pizza) VALUES (pedidoId, sabor1Id, sabor2Id, qntd_pedido, totalPizzas);
END;
$$ LANGUAGE plpgsql;
 
CALL sp_realizar_pedido('FELIPE', 14, 'FRANGO CATUPIRY', 'CALABACON', 2);

-- EXTRA (TESTES)

select tb_cliente.nome, tb_pedido.data_pedido, tb_pedido.preco_entrega, pizza.id_pedido, pizza.qntd, pizza.preco_pizza, (tb_pedido.preco_entrega + pizza.preco_pizza) AS total from rl_pedido_pizza AS pizza
inner join tb_pedido on tb_pedido.id_pedido = pizza.id_pedido
inner join tb_cliente on tb_pedido.id_cliente = tb_cliente.id_cliente
where tb_cliente.nome = 'FELIPE';

DELETE FROM rl_pedido_pizza AS pizza
USING tb_pedido
WHERE pizza.id_pedido = tb_pedido.id_pedido
AND pizza.qntd = 0;
