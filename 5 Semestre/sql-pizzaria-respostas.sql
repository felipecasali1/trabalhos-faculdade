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

-- QUESTÃO 3 (STORED PROCEDURE) - 


