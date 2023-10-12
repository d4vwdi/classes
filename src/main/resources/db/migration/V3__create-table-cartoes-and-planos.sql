CREATE TABLE planos (
    idPlano BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome text,
    porcentagemCashback DOUBLE,
    parcerias TEXT
);


CREATE TABLE cartoes (
	id TEXT PRIMARY KEY UNIQUE NOT NULL,
	titularCartao TEXT NOT NULL,
	validadeCartao DATE NOT NULL,
	numeroCartao VARCHAR(16) NOT NULL UNIQUE,
	cvcCartao INT NOT NULL,
	planoNome TEXT,
    FOREIGN KEY (planoNome) REFERENCES planos (idPlano)
);

