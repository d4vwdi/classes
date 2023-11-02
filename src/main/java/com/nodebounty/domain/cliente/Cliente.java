package com.nodebounty.domain.cliente;

import com.nodebounty.domain.contacorrente.Contacorrente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTES")
@Entity
@Getter
@EqualsAndHashCode(of = "idCliente") /* Seleciona a chave primária da tabela em questão */

public class Cliente {
	
	/* Indica que o id é gerado automaticamente e 
	 * não é um valor atribuido pelo usuário
	 */
	
	@Id @GeneratedValue(strategy = GenerationType.UUID) @Column(name = "IDCLIENTE")
	private String idCliente;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "ENDERECO")
	private String endereco;
	@Column(name = "CEP")
	private String cep;
	@Column(name = "NUMERO")
	private Integer numero;
	@Column(name = "RG")
	private String rg;
	@Column(name = "CPF")
	private String cpf;
	@Column(name = "DATANASCIMENTO")
	private String dataNascimento;
	@Column(name = "TELEFONE")
	private String telefone;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "SENHA")
	private String senha;
    @OneToOne(mappedBy = "cliente")
    private Contacorrente contaCorrente;



	
	/* Construtor para cadastrar novo cliente com base nos dados recebidos pelo controller */
	
	public Cliente(DadosCadastroCliente requestClientes) {
		this.nome = requestClientes.nome();
		this.endereco = requestClientes.endereco();
		this.cep = requestClientes.cep();
		this.numero = requestClientes.numero();
		this.rg = requestClientes.rg();
		this.cpf = requestClientes.cpf();
		this.dataNascimento = requestClientes.dataNascimento();
		this.telefone = requestClientes.telefone();
		this.email = requestClientes.email();
		this.senha = requestClientes.senha();
		this.contaCorrente = new Contacorrente();
	}
	
	/* Método para atualizar cliente com base nos dados recebidos pelo controller 
	 * Como todos os campos são opcionais, verifico primeiro se foi enviado algo. Se tiver sido, ai eu atualizo
	 * */
	
	public void atualizarDados(DadosAtualizacaoCliente data) {
		if (data.nome() != null) {
			this.nome = data.nome();
		}
		if (data.endereco() != null) {
			this.endereco = data.endereco();
		}
		if (data.cep() != null) {
			this.cep = data.cep();
		}
		if (data.numero() != null) {
			this.numero = data.numero();
		}
		if (data.telefone() != null) {
			this.telefone = data.telefone();
		}
		if (data.senha() != null) {
			this.senha = data.senha();
		}
	}
}
