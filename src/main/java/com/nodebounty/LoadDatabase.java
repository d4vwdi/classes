package com.nodebounty;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nodebounty.domain.cartao.Cartao;
import com.nodebounty.domain.cartao.CartaoRepository;
import com.nodebounty.domain.contacorrente.ContacorrenteRepository;
import com.nodebounty.domain.plano.Plano;
import com.nodebounty.domain.plano.PlanoRepository;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(
        PlanoRepository repositoryPlanos, CartaoRepository repositoryCartao, ContacorrenteRepository repositoryConta
    ) {
        return args -> {

            Plano beauty = new Plano();
            beauty.setNomePlano("Beauty");
            beauty.setPorcentagemCashbackPlano(5.00);
            beauty.setParceriasPlano("MAC, MakeB, Vult");

            Plano health = new Plano();
            health.setNomePlano("Health");
            health.setPorcentagemCashbackPlano(5.00);
            health.setParceriasPlano("Growth, OficialFarma, Drogasil");

            Plano tech = new Plano();
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
        };
    }
}

