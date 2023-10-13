CREATE TABLE contacorrente (
idconta TEXT PRIMARY KEY UNIQUE NOT NULL,
planoselecionado VARCHAR(255),
saldo DOUBLE,
idCartao VARCHAR(255)
);
