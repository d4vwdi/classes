package com.nodebounty.domain.plano;

import com.nodebounty.domain.plano.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    // Consulta personalizada para buscar planos por nome
    @Query("SELECT p FROM Plano p WHERE p.nomePlano = :nomes")
    Plano findByNomePlano(@Param("nomes") String nome);
}
