package com.nodebounty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nodebounty.domain.contacorrente.Transacao;


@SpringBootApplication
public class NodebountyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NodebountyApplication.class, args);
		
		Transacao transacao = new Transacao();
        transacao.TesteSaque();
	}

}
