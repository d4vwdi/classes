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
	private double saldoConta;


	
	
	
	public void setPlanosConta(Plano planosConta) {
		this.planosConta = planosConta;
	}
	public void setSaldo(double saldo) {
		this.saldoConta = saldoConta;
	}
	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}


}
