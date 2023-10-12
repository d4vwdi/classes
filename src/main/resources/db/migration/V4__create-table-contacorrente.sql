CREATE TABLE contacorrente (
idConta TEXT PRIMARY KEY UNIQUE NOT NULL,
planosConta VARCHAR(255),
saldo DOUBLE,
idCartao VARCHAR(255)

);