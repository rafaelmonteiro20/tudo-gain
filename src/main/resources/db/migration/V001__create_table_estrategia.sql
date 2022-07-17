CREATE SEQUENCE IF NOT EXISTS seq_estrategia;

CREATE TABLE IF NOT EXISTS estrategia (
	id INT8 NOT NULL,
	descricao VARCHAR(100) NOT NULL,

	CONSTRAINT pk_estrategia PRIMARY KEY (id)
);

ALTER TABLE estrategia ALTER COLUMN id SET DEFAULT NEXTVAL('seq_estrategia');
