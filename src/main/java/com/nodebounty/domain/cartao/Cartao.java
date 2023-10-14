package com.nodebounty.domain.cartao;

import java.time.LocalDate;

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

/* Nenhuma mudança relevante. Apenas mudou o tipo do id pra String, pra deixar igual o da classe Cliente, um id do tipo UUID.
 * Como o H2 vai salvar as propriedades tudo em maiúsculo, preciso dizer que no BD a propriedade 'titularCartao' vai ser 'TITULARCARTAO'
 * Por isso uso o @Column em todas. O @Table faz o mesmo mas com a tabela em si. */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "CARTOES")
public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "IDCARTAO")
	private String idCartao;
	@Column(name = "TITULARCARTAO")
	private String titularCartao;
	@Column(name = "VALIDADECARTAO")
	private LocalDate validadeCartao;
	@Column(name = "NUMEROCARTAO")
	private String numeroCartao;
	@Column(name = "CVCCARTAO")
	private Short cvcCartao;

//	@OneToOne // Indica o relacionamento 1:1
//	@JoinColumn(name = "PLANONOME", referencedColumnName = "IDPLANO") // Cria a coluna no banco chamada "plano_nome" e faz a referência ao id do plano
//	private Plano plano; // Adiciona um campo para representar o Plano atrelado ao cartão
	
}