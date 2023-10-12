package com.nodebounty.domain.cartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Aqui eu removi o findAllByIdCartao pois já existe o findById().
 * Mudei o tipo de id pra UUID, igual o da Eloah, portanto o id agora é uma string
 */

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
}