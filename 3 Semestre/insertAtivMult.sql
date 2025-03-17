INSERT INTO ESTADO (nome) VALUES
('São Paulo'),
('Rio de Janeiro'),
('Minas Gerais'),
('Bahia'),
('Paraná'),
('Mato Grosso do Sul'),
('Mato Grosso'),
('Santa Catarina'),
('Rio Grande do Norte'),
('Acre'),
('Espirito Santo');

INSERT INTO CIDADE (nome, estadoId) VALUES
('São Paulo', 1),
('Rio de Janeiro', 2),
('Belo Horizonte', 3),
('Contagem', 3),
('Salvador', 4),
('Itabuna', 4),
('Curitiba', 5),
('Campo Grande', 6),
('Dourados', 6),
('Florianopolis', 7),
('Joinville', 7),
('Natal', 8),
('Rio Branco', 9),
('Cruzeiro do Sul', 9),
('Vitória', 10);

INSERT INTO BAIRRO (nome, cidadeId) VALUES
('Bairro 1', 1),
('Bairro 2', 2),
('Bairro 3', 3),
('Bairro 4', 4),
('Bairro 5', 5),
('Bairro 6', 6),
('Bairro 7', 7),
('Bairro 8', 8),
('Bairro 9', 9),
('Bairro 10', 10),
('Bairro 11', 11),
('Bairro 12', 12),
('Bairro 13', 13),
('Bairro 14', 14),
('Bairro 15', 15),
('Bairro 16', 6),
('Bairro 17', 7),
('Bairro 18', 8),
('Bairro 19', 9),
('Bairro 20', 10);

INSERT INTO ADMIN (cpf, rg, nome) VALUES
('123.456.789-09', '12345678-9', 'Joao'),
('433.456.789-11', '22345678-9', 'Bruna'),
('113.444.789-44', '32345678-9', 'Rodolfo'),
('111.456.789-09', '42345678-9', 'Carlos'),
('222.456.789-09', '52345678-9', 'Silvia'),
('999.456.789-09', '62345678-9', 'Jose'),
('998.456.789-11', '72345678-9', 'Carla'),
('988.444.789-44', '82345678-9', 'Silvana'),
('977.456.789-09', '92345678-9', 'Ruan'),
('978.456.789-09', '15545678-9', 'Lucas');

INSERT INTO FUNCIONARIO (cpf, rg, nome) VALUES
('845.456.789-09', '77745678-9', 'Rodrigo'),
('173.456.789-11', '88845678-9', 'Leticia'),
('553.444.789-44', '42245678-9', 'Felipe'),
('941.456.789-09', '66645678-9', 'Marcos'),
('001.456.789-09', '74745678-9', 'Adriana'),
('125.456.789-09', '12188449-9', 'Juliano'),
('472.456.789-11', '76123418-9', 'Laura'),
('842.444.789-44', '24167943-9', 'Pedro'),
('001.456.789-09', '07841231-9', 'Roger'),
('435.456.789-09', '89697412-9', 'Beatriz');

INSERT INTO CLIENTE (descricao, status, dataCadastro) VALUES
('Cliente 1', 'Ativo', '2024-03-01'),
('Cliente 2', 'Inativo', '2022-02-02'),
('Cliente 3', 'Ativo', '2024-01-03'),
('Cliente 4', 'Inativo', '2023-04-04'),
('Cliente 5', 'Ativo', '2022-05-05'),
('Cliente 6', 'Ativo', '2023-06-11'),
('Cliente 7', 'Inativo', '2022-06-22'),
('Cliente 8', 'Ativo', '2024-02-13'),
('Cliente 9', 'Inativo', '2022-02-24'),
('Cliente 10', 'Ativo', '2021-01-15'),
('Cliente 11', 'Ativo', '2024-03-01'),
('Cliente 12', 'Inativo', '2022-02-02'),
('Cliente 13', 'Ativo', '2024-01-03'),
('Cliente 14', 'Inativo', '2022-04-04'),
('Cliente 15', 'Ativo', '2023-05-05'),
('Cliente 16', 'Ativo', '2023-06-11'),
('Cliente 17', 'Inativo', '2024-06-22'),
('Cliente 18', 'Ativo', '2024-02-13'),
('Cliente 19', 'Inativo', '2022-02-24'),
('Cliente 20', 'Ativo', '2021-01-15');

INSERT INTO ENDERECO (rua, numero, clienteId, bairroId) VALUES
('Rua A1', '123', 1, 1),
('Rua B1', '456', 2, 2),
('Rua C1', '789', 3, 3),
('Rua D1', '101', 4, 4),
('Rua E1', '112', 5, 5),
('Rua F1', '634', 6, 6),
('Rua G1', '675', 7, 7),
('Rua H1', '214', 8, 8),
('Rua I1', '111', 9, 9),
('Rua J1', '776', 10, 10),
('Rua K1', '123', 11, 11),
('Rua L1', '456', 12, 12),
('Rua M1', '789', 13, 13),
('Rua N1', '101', 14, 14),
('Rua O1', '112', 15, 15),
('Rua P1', '634', 16, 16),
('Rua Q1', '675', 17, 17),
('Rua R1', '214', 18, 18),
('Rua S1', '111', 19, 19),
('Rua T1', '776', 20, 20);

INSERT INTO ENDERECO (rua, numero, adminId, bairroId) VALUES
('Rua A2', '123', 1, 1),
('Rua B2', '456', 2, 2),
('Rua C2', '789', 3, 3),
('Rua D2', '101', 4, 4),
('Rua E2', '112', 5, 5),
('Rua F2', '634', 6, 6),
('Rua G2', '675', 7, 7),
('Rua H2', '214', 8, 8),
('Rua I2', '111', 9, 9),
('Rua J2', '776', 10, 10);

INSERT INTO ENDERECO (rua, numero, funcionarioId, bairroId) VALUES
('Rua A3', '123', 1, 1),
('Rua B3', '456', 2, 2),
('Rua C3', '789', 3, 3),
('Rua D3', '101', 4, 4),
('Rua E3', '112', 5, 5),
('Rua F3', '634', 6, 6),
('Rua G3', '675', 7, 7),
('Rua H3', '214', 8, 8),
('Rua I3', '111', 9, 9),
('Rua J3', '776', 10, 10);

INSERT INTO EMPRESA (cnpj, nome, clienteId) VALUES
('12.345.678/0001-00', 'Empresa 1', 1),
('23.456.789/0001-11', 'Empresa 2', 2),
('34.567.890/0001-22', 'Empresa 3', 3),
('45.678.901/0001-33', 'Empresa 4', 4),
('56.789.012/0001-44', 'Empresa 5', 5),
('78.345.678/0001-00', 'Empresa 6', 6),
('73.456.789/0001-11', 'Empresa 7', 7),
('74.567.890/0001-22', 'Empresa 8', 8),
('55.678.901/0001-33', 'Empresa 9', 9),
('11.789.012/0001-44', 'Empresa 10', 10);

INSERT INTO PESSOA (cpf, rg, nome, clienteId) VALUES
('845.456.789-09', '11111111-9', 'Pessoa 1', 11),
('080.344.556-67', '22222222-9', 'Pessoa 2', 12),
('978.455.667-78', '33333333-9', 'Pessoa 3', 13),
('215.566.778-89', '44444444-9', 'Pessoa 4', 14),
('767.677.889-90', '55555555-9', 'Pessoa 5', 15),
('323.456.789-09', '66666666-9', 'Pessoa 6', 16),
('242.344.556-67', '77777777-9', 'Pessoa 7', 17),
('525.455.667-78', '88888888-9', 'Pessoa 8', 18),
('262.566.778-89', '99999999-9', 'Pessoa 9', 19),
('363.677.889-90', '00000000-9', 'Pessoa 10', 20);

INSERT INTO REUNIAO (status, horario, dataagendada, clienteId, funcionarioId) VALUES
('Agendada', '0800', '2024-07-20', 1, 1),
('Agendada', '1000', '2024-09-25', 2, 2),
('Agendada', '0730', '2024-06-22', 3, 3),
('Realizada', '0900', '2023-05-20', 4, 4),
('Realizada', '1100', '2024-05-11', 5, 5),
('Realizada', '1500', '2024-02-08', 6, 1),
('Agendada', '0800', '2024-07-12', 7, 2),
('Realizada', '1400', '2023-04-23', 8, 3),
('Agendada', '1400', '2024-06-27', 9, 4),
('Realizada', '1000', '2024-03-26', 10, 5);

INSERT INTO TELEFONE (numero, clienteId) VALUES
('112345-6789', 1),
('123456-7890', 2),
('134567-8901', 3),
('145678-9012', 4),
('156789-0123', 5),
('112345-6789', 6),
('123456-7890', 7),
('134567-8901', 8),
('145678-9012', 9),
('156789-0123', 10);

INSERT INTO TELEFONE (numero, adminId, funcionarioid) VALUES
('212345-6789', 1, NULL),
('223456-7890', 2, NULL),
('234567-8901', 3, NULL),
('245678-9012', 4, NULL),
('256789-0123', 5, NULL),
('312345-6789', NULL, 1),
('323456-7890', NULL, 2),
('334567-8901', NULL, 3),
('345678-9012', NULL, 4),
('356789-0123', NULL, 5);

INSERT INTO VENDA (dataVenda, clienteId, funcionarioId) VALUES
('2024-03-11', 2, 1),
('2024-02-02', 3, 2),
('2024-05-23', 5, 3),
('2024-05-04', 6, 3),
('2024-03-05', 9, 5),
('2024-03-05', 9, 2),
('2024-03-05', 9, 7),
('2023-03-05', 13, 8),
('2023-03-05', 18, 9),
('2024-02-02', 1, 2),
('2024-05-23', 5, 3),
('2024-05-04', 6, 3),
('2023-03-05', 15, 8),
('2023-03-05', 19, 9),
('2024-02-02', 3, 2),
('2024-05-23', 5, 3),
('2023-04-11', 10, 9);

INSERT INTO JUSTIFICATIVA (nome) VALUES
('Lead inativo nos ultimos 6 meses'),
('Lead com nformacoes incorretas'),
('Fim do projeto'),
('Lead sem orcamento'),
('Lead duplicado'),
('Lead sem orcamento'),
('Negócio fechado com concorrente'),
('Fora do perfil ideal'),
('Solicitação do próprio'),
('Lead nao interessado');

INSERT INTO CATEGORIACONVERSAO (nome) VALUES
('Referencia ou Indicacao'),
('Compra de produto'),
('Redes sociais'),
('Inscricao em evento'),
('Teste gratuito'),
('Cliente recorrente'),
('Convertido através do download de materiais'),
('Convertido ao agendar uma consulta ou reunião'),
('Convertido ao participar de um programa de fidelidade'),
('Convertido através de uma indicação de um cliente atual.');

INSERT INTO LEAD (dataCadastro, status, categoriaId, clienteId, funcionarioId, justificativaId) VALUES
('2023-05-01', 'Ativo', 1, 1, 1, NULL),
('2023-03-02', 'Ativo', 2, 5, 9, NULL),
('2022-01-30', 'Inativo', 3, 2, 3, 3),
('2024-02-04', 'Ativo', 4, 6, 4, NULL),
('2024-02-05', 'Inativo', 5, 10, 10, 5),
('2023-05-01', 'Ativo', 2, 1, 1, NULL),
('2023-03-02', 'Ativo', 2, 5, 2, NULL),
('2022-01-30', 'Inativo', 3, 2, 8, 3),
('2024-02-04', 'Ativo', 4, 6, 4, NULL),
('2024-02-05', 'Inativo', 5, 10, 4, 5),
('2023-05-01', 'Ativo', 5, 1, 1, NULL),
('2023-03-02', 'Ativo', 3, 8, 7, NULL);

INSERT INTO RELATORIO (leadsAprovados, leadsInativados, novosLeads, dataGeracao, leadId) VALUES
(11, 5, 8, '2023-06-01', 1),
(26, 3, 17, '2023-04-02', 2),
(8, 6, 9, '2022-02-03', 3),
(13, 5, 12, '2024-03-04', 4),
(7, 9, 11, '2024-04-05', 5),
(11, 5, 8, '2023-06-01', 7),
(26, 3, 17, '2023-04-02', 8),
(8, 6, 9, '2022-02-03', 10),
(13, 5, 12, '2024-03-04', 11),
(7, 9, 11, '2024-04-05', 9);

INSERT INTO OBSERVACOES (dataCadastro, descricao, leadId) VALUES
('2023-05-01', 'O lead demonstrou interesse no servico', 1),
('2023-03-02', 'O lead possui um orçamento estimado de R$60000', 2),
('2022-01-30', 'O lead mencionou que enfrenta desafios específicos relacionados a demandas', 3),
('2024-02-04', 'O lead mencionou estar considerando outras opções', 4),
('2024-02-05', 'O lead deu um feedback positivo/negativo sobre o servico', 5),
('2024-02-05', 'O lead mencionou restrições de tempo', 6),
('2023-02-05', 'O lead prefere comunicações mais detalhadas e resumidas', 7),
('2023-02-05', 'O lead expressou satisfação com o atendimento', 8),
('2023-02-05', 'O lead foi recomendado por um dos clientes', 9),
('2024-02-05', 'Durante a reunião com o lead, foi discutido o orçamento', 10);