CREATE TABLE gasto (
	id INT auto_increment NOT NULL,
	nome_pessoa varchar(100) NOT NULL,
	descricao varchar(200) NOT NULL,
	data_hora DATETIME NOT NULL,
	valor DECIMAL(16,2) NOT NULL,
	tags varchar(200) NOT NULL,
	PRIMARY KEY (id)
);