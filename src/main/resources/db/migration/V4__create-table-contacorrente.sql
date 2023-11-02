CREATE TABLE contacorrente (
    idCliente VARCHAR(255),
    idConta TEXT PRIMARY KEY UNIQUE NOT NULL,
    ordemCriacao BIGINT AUTO_INCREMENT,
    idCartao VARCHAR(255),
    planoSelecionado VARCHAR(255),
    saldoConta DOUBLE
);
