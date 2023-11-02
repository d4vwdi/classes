package com.nodebounty;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nodebounty.domain.cartao.Cartao;
import com.nodebounty.domain.cartao.CartaoRepository;
import com.nodebounty.domain.contacorrente.Contacorrente;
import com.nodebounty.domain.contacorrente.ContacorrenteRepository;
import com.nodebounty.domain.plano.Plano;
import com.nodebounty.domain.plano.PlanoRepository;

@Configuration
public class LoadDatabase {

	@Autowired
	CartaoRepository repositoryCartao;
	@Autowired
	PlanoRepository repositoryPlanos;
	@Autowired
	ContacorrenteRepository repositoryConta;

	@Bean
	CommandLineRunner initDatabase(PlanoRepository repository) {
		return args -> {
			// Salvando planos para testes
//			Plano Beauty = new Plano("Beauty", 5.00, "MAC, MakeB, Vult");
//			Plano Tech = new Plano("Tech", 5.00, "KaBum, Pichau, TeraByte Shop");
//			Plano Health = new Plano("Health", 5.00, "Growth, OficialFarma, Drogasil");
//


			
			Plano beauty = new Plano();
//			beauty.setIdPlano(null);
			beauty.setNomePlano("Beauty");
			beauty.setPorcentagemCashbackPlano(5.00);
			beauty.setParceriasPlano("MAC, MakeB, Vult");
			
			Plano health = new Plano();
//			health.setIdPlano(null);
			health.setNomePlano("Health");
			health.setPorcentagemCashbackPlano(5.00);
			health.setParceriasPlano("Growth, OficialFarma, Drogasil");
			
			Plano tech = new Plano();
//			tech.setIdPlano(null);
			tech.setNomePlano("Tech");
			tech.setPorcentagemCashbackPlano(5.00);
			tech.setParceriasPlano("KaBum, Pichau, TeraByte Shop");
			
		repositoryPlanos.saveAll(Arrays.asList(beauty, health, tech));
			
			// Salvando cartões para teste
			
			LocalDate validade1 = LocalDate.of(2023, 12, 31);
			LocalDate validade2 = LocalDate.of(2024, 6, 30);
			LocalDate validade3 = LocalDate.of(2024, 9, 15);

			Cartao cartao1 = new Cartao(null, "João Silva", validade1, "1234567890123456", (short) 123);
			Cartao cartao2 = new Cartao(null, "Maria Souza", validade2, "9876543210987654", (short) 456);
			Cartao cartao3 = new Cartao(null, "José Pereira", validade3, "5555666677778888", (short) 789);

		repositoryCartao.saveAll(Arrays.asList(cartao1, cartao2, cartao3));
		
		// ... Seu código existente para salvar planos e cartões

		Contacorrente conta1 = new Contacorrente();
		conta1.setSaldoConta(100.0);

		Contacorrente conta2 = new Contacorrente();
		conta2.setSaldoConta(200.0);

		Contacorrente conta3 = new Contacorrente();
		conta3.setSaldoConta(300.0);

		Contacorrente conta4 = new Contacorrente();
		conta4.setSaldoConta(400.0);
		
		Contacorrente conta5 = new Contacorrente();
		conta5.setSaldoConta(500.0);
		
		Contacorrente conta6 = new Contacorrente();
		conta6.setSaldoConta(600.0);
		// Remova a configuração manual do campo ordemCriacao

		// Salve as contas correntes no banco de dados
		repositoryConta.saveAll(Arrays.asList(conta1, conta2, conta3, conta4, conta5, conta6));


		};
	}

}
