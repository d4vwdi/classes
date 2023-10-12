package com.nodebounty.domain.plano;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Os repository geralmente não tem nada dentro. Caso a gente precise buscar por um registro, utilizando outro campo diferente
 * do id, aí sim pode criar um método aqui. Por exemplo, o que estava aqui antes: findAllByNome(). O Spring automáticamente
 * Vai saber que vai ter esse método no repository, que vai querer buscar um registro no banco pelo nome, e vai criar uma query do tipo:
 * SELECT FROM PLANO WHERE NOME = 'NOME';
 * No momento, como o nome e o ID viraram a mesma coisa, então só usar o findById() mesmo
 */

@Repository
public interface PlanoRepository extends JpaRepository<Plano, String> {
}
