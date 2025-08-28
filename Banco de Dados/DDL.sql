CREATE TABLE ECOMMERCE.cliente (
				cliente_id INT PRIMARY KEY GENERATED always as identity,
				nome_completo  TEXT NOT NULL,
				email  TEXT NOT NULL,
				senha  TEXT NOT NULL,
				telefone  TEXT NOT NULL,
				data_cadastro DATE NOT NULL
			
);


CREATE TABLE ECOMMERCE.categoria (
				categoria_id INT PRIMARY KEY GENERATED always as identity,
				nome_categoria TEXT NOT NULL,
				descricao TEXT NOT NULL
);

CREATE TABLE ECOMMERCE.produto (
				produto_id INT PRIMARY KEY GENERATED always as identity,
				categoria_id INT NOT NULL REFERENCES ECOMMERCE.categoria(categoria_id),
				descricao TEXT NOT NULL,
				preco NUMERIC (10,4),
				estoque_disponivel  INT NOT NULL,
				imagem_url TEXT NULL,
				nome_produto  TEXT NOT NULL
);

CREATE TABLE ECOMMERCE.pedido (
				pedido_id INT PRIMARY KEY GENERATED always as identity,
				cliente_id INT NOT NULL REFERENCES ECOMMERCE.cliente(cliente_id),
				data_pedido DATE NOT NULL,
				valor_total NUMERIC(10,4) NULL,
				status TEXT NOT NULL
);

create table ECOMMERCE.item_do_pedido(
				item_id INT PRIMARY key GENERATED always as identity,
				pedido_id INT NOT NULL references ECOMMERCE.pedido(pedido_id),
				produto_id INT NOT NULL references ECOMMERCE.produto(produto_id), 
				quantidade INT NOT NULL
);
create table ecommerce.pagamento(
				pagamento_id  INT PRIMARY key GENERATED always as identity,
				pedido_id INT NOT NULL references ecommerce.pedido(pedido_id),
				forma_pagamento TEXT NOT NULL,
				status TEXT NOT NULL,
				data_pagamento DATE NOT NULL
);

create table ecommerce.endereco_de_entrega(
				endereco_id INT primary key GENERATED always as identity,
				cliente_id INT NOT NULl references ecommerce.cliente(cliente_id),
				logradouro TEXT NOT NULL,
				numero INT NOT NULL,
				complemento TEXT NOT NULL,
				bairro TEXT NOT NULL,
				cidade TEXT NOT NULL,
				estado TEXT NOT NULL,
				cep TEXT NOT NULL

);

drop table ecommerce.endereco_de_entrega;
drop table ecommerce.pagamento;
drop table ECOMMERCE.item_do_pedido;
drop table ECOMMERCE.pedido;
drop table ECOMMERCE.produto;
drop table ECOMMERCE.cliente;
drop table ECOMMERCE.categoria;














-- É um comentário!
/*
 Comentário de multiplas linhas!
*/

-- DDL - Criar - Create (Schema, Tabela)
CREATE SCHEMA clinica;

-- CREATE TABLE <SCHEMA>.<NOME_DA_TABELA>
CREATE TABLE clinica.medico (
	-- Informar Colunas 
	-- NOME_DA_COLUNA TIPO_DE_DADO
	-- PRIMARY KEY - CHAVE PRIMÁRIA
	-- GENERATED ALWAYS AS IDENTITY - A CHAVE PRIMÁRIA
	-- É CRIADA AUTOMATICAMENTE
	id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	crm TEXT NOT NULL,
	especialidade TEXT NOT NULL
);

CREATE TABLE clinica.paciente (
	id_paciente INT PRIMARY KEY 
	GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	idade INT NOT NULL,
	data_nascimento DATE NOT NULL
);

CREATE TABLE clinica.clinica (
	id_clinica INT PRIMARY KEY 
	GENERATED ALWAYS AS IDENTITY,
	nome TEXT NOT NULL,
	descricao TEXT NOT NULL,
	endereco TEXT
);












CREATE TABLE clinica.consulta (
	id_consulta INT PRIMARY KEY
	GENERATED ALWAYS AS IDENTITY,
	data TIMESTAMPTZ NOT NULL,
	valor NUMERIC (10, 4),
	-- 000000.0000
	-- Maneira Extensa
	id_medico INT NOT NULL,
	FOREIGN KEY (id_medico) 
	REFERENCES clinica.medico(id_medico),
	-- Maneira Abreviada
	id_clinica INT NOT NULL 
	REFERENCES clinica.clinica(id_clinica),
	id_paciente INT NOT NULL
	REFERENCES clinica.paciente(id_paciente)
);

-- ALTER - Alterar Tabela
ALTER TABLE clinica.paciente 
ADD COLUMN cpf VARCHAR(14) UNIQUE;
-- UNIQUE - Impede que seja cadastrado
-- algo que já existe no banco

-- Apagar Coluna
ALTER TABLE clinica.paciente
DROP COLUMN cpf;

-- Renomear Tabela
ALTER TABLE clinica.novopaciente
RENAME TO paciente;

-- TRUNCATE - Limpa a Tabela
-- TRUNCATE TABLE clinica.consulta 
-- RESTART IDENTITY;
-- RESTART IDENTITY - Reinicia a Sequencia

-- Apagar Tabela - DROP
/*
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;
*/
