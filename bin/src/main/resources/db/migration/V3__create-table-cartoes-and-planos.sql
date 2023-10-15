CREATE TABLE planos (
    idPlano BIGINT PRIMARY KEY AUTO_INCREMENT,
    nomePlano text,
    porcentagemCashbackPlano DOUBLE,
    parceriasPlano TEXT
);


CREATE TABLE cartoes (
	idCartao TEXT PRIMARY KEY UNIQUE NOT NULL,
	titularCartao TEXT NOT NULL,
	validadeCartao DATE NOT NULL,
	numeroCartao VARCHAR(16) NOT NULL UNIQUE,
	cvcCartao INT NOT NULL,
	planoNome TEXT,
    FOREIGN KEY (planoNome) REFERENCES planos (idPlano)
);

