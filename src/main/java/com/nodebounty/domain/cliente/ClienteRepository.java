package com.nodebounty.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

	/* Aqui se adiciona qual é a entidade e o tipo da chave primária dessa entidade */
}
