package com.nodebounty.domain.contacorrente;


import com.nodebounty.domain.cliente.Cliente;
import com.nodebounty.domain.plano.Plano;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "CONTACORRENTE")
public class Contacorrente {
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "IDCONTA")
	private String idConta;
	@OneToOne // Indica o relacionamento 1:1
	@JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE") // Cria a coluna no banco chamada "IDCLIENTE" e faz a referência ao id do Cliente
	private Cliente cliente; // Adiciona um campo para representar o Cliente em sua Conta Corrente
	@Column(name = "IDCARTAO")
	private String idCartao;

    @OneToOne // Indica o relacionamento 1:1, ou seja, uma conta corrente está associada a um único plano
    @JoinColumn(name = "PLANOSELECIONADO", referencedColumnName = "IDPLANO") // A referência precisa ser necessariamente o nome da tabela,
    																		  //  Neste caso "ID_PLANO", como está definida em @Column de Plano.java
    private Plano planosConta; // Alterado para o tipo Plano

	@Column(name = "SALDOCONTA")
	protected double saldoConta = 0.0;

	
	
	
	public void setPlanosConta(Plano planosConta) {
		this.planosConta = planosConta;
	}
	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}
	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}

/* Transações */
	
	public void sacar(double valor) {
        if (valor > 0 && valor <= saldoConta) {
            saldoConta -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso na conta.");
            System.out.println("Saldo atual da conta: " + saldoConta);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para saque.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldoConta += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta.");
            System.out.println("Saldo atual da conta: " + saldoConta);
        } else {
            throw new IllegalArgumentException("Valor inválido para depósito.");
        }
    }

    public void transferir(Contacorrente contaDestino, double valor) {
        if (valor > 0 && valor <= saldoConta) {
            saldoConta -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso da conta para a conta de destino.");
            System.out.println("Saldo atual da conta de origem: " + saldoConta);
        } else {
            throw new IllegalArgumentException("Não foi possível realizar a transferência devido a saldo insuficiente.");
        }
    }

}
