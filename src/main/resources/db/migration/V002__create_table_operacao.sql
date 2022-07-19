CREATE SEQUENCE IF NOT EXISTS seq_operacao;

CREATE TABLE IF NOT EXISTS operacao (
	id INT8 NOT NULL,
	ativo VARCHAR(8) NOT NULL,
	data_abertura TIMESTAMP NOT NULL,
	data_fechamento TIMESTAMP NOT NULL,
	quantidade INT4 NOT NULL,
	preco_compra NUMERIC(11,2) NOT NULL,
	preco_venda NUMERIC(11,2) NOT NULL,
	tipo_operacao VARCHAR(10) NOT NULL,
	resultado NUMERIC(11,2) NOT NULL,
	resultado_pontos NUMERIC(11,2) NOT NULL,
	observacao VARCHAR(255),
	id_estrategia INT8,

	CONSTRAINT pk_operacao PRIMARY KEY (id),
	CONSTRAINT fk_operacao_estrategia FOREIGN KEY (id_estrategia) REFERENCES estrategia (id)
);

ALTER TABLE operacao ALTER COLUMN id SET DEFAULT NEXTVAL('seq_operacao');
