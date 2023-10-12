package com.nodebounty.domain.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/* NotBlank não permite valores null e nem valores vazios como: '' *
/* Como o ID é um valor que o back-end vai gerar, não precisa nem inserir nos dados de cadastro, mesmo que seja opcional */

public record DadosCadastroCliente(
	@NotBlank(message="Esse campo é obrigatório")	 String nome, 
	@NotBlank(message="Esse campo é obrigatório")	 String endereco, 
	@NotBlank(message="Esse campo é obrigatório")	 String cep,
	@NotNull(message="Esse campo é obrigatório")	 Integer numero,
	@NotBlank(message="Esse campo é obrigatório")	 String rg,
	@NotBlank(message="Esse campo é obrigatório")	 String cpf,
	@NotBlank(message="Esse campo é obrigatório")	 String dataNascimento,
	@NotBlank(message="Esse campo é obrigatório")	 String telefone,
	@NotBlank(message="Esse campo é obrigatório") @Email(message="E-mail inválido")	 String email,
	@NotBlank(message="Esse campo é obrigatório")	 String senha,
	@NotBlank(message="Esse campo é obrigatório")	 String planoSelecionado
){

}

