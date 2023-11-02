package com.nodebounty.domain.transacao;

import com.nodebounty.domain.contacorrente.Contacorrente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "TRANSACAO")
public class Transacao {
	/* Definição dos atributos pertencentes à entidade Transação */
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "IDTRANSACAO")
	private String idTransacao;
    @ManyToOne
    @JoinColumn(name = "IDCONTA")
    private Contacorrente contacorrente;
	@Column(name = "DATATRANSACAO")
	private String dataTransacao;
	@Column(name = "HORATRANSACAO")
	private String horaTransacao;
	@Column(name = "VALORTRANSACAO")
	private String valorTransacao;
	
	
	

    public void TesteSaque() {
    	// Cria duas instâncias da classe ContaCorrente e define o saldo inicial de cada uma para fins de teste
    	// Futuramente, precisamos dar um jeito de automatizar isso e chamar pelo ID, baseado no login realizado pelo
    	// cliente.
        Contacorrente conta1 = new Contacorrente();
        conta1.setSaldoConta(180.00);

        Contacorrente conta2 = new Contacorrente();
        conta2.setSaldoConta(100.00);

        // As linhas abaixos exibem o saldo inicial das contas, para que a gente não se perca no teste
        System.out.println("Saldo da conta 1: " + conta1.getSaldoConta());
        System.out.println("Saldo da conta 2: " + conta2.getSaldoConta());

        //Operações de saque e depósito definidas anteriormente na classe ContaCorrente
        conta1.sacar(50.00);
        
        
        conta2.depositar(50.00);

        //Operação de transferência definida enteriormente na classe ContaCorrente
        conta1.transferir(conta2, 30.00);

        System.out.println("Saldo da conta 1 após transferência: " + conta1.getSaldoConta());
        System.out.println("Saldo da conta 2 após transferência: " + conta2.getSaldoConta());
    }
}

