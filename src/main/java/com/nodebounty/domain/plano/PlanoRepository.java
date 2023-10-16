package com.nodebounty.domain.plano;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository //Esta anotação é usada para indicar que a interface PlanoRepository é um componente gerenciado pelo Spring, especificamente um repositório de dados.
            // Os repositórios são usados para acessar e manipular dados do banco de dados de maneira conveniente.


// Esta é a declaração da interface PlanoRepository, que estende JpaRepository. O JpaRepository é parte do Spring Data JPA e fornece
// métodos convenientes para realizar operações de banco de dados, como salvar, buscar, atualizar e excluir registros.
// Neste caso, ele está sendo usado para trabalhar com entidades do tipo Plano com identificadores do tipo Long.
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    // Consulta personalizada para buscar planos por nome
    @Query("SELECT p FROM Plano p WHERE p.nomePlano = :nomes")//@Query é usada para definir uma consulta personalizada em JPQL (Java Persistence Query Language).
    //Neste caso, a consulta seleciona todos os registros da entidade Plano onde o atributo nomePlano corresponde ao parâmetro :nomes.
    // O :nomes é um parâmetro nomeado que será vinculado ao parâmetro do método a seguir.

    // Este é um método de consulta personalizado que corresponde à consulta JPQL definida anteriormente.
    // Ele recebe um parâmetro String chamado nome, que será correspondido ao parâmetro nomeado :nomes na consulta.
    // O método retornará um objeto Plano com base no resultado da consulta. O nome do método segue uma convenção de
    // nomenclatura especial do Spring Data JPA que usa a palavra "findBy" seguida pelo nome do atributo da entidade (nomePlano no caso)
    // que está sendo consultado.
    Plano findByNomePlano(@Param("nomes") String nome);
}