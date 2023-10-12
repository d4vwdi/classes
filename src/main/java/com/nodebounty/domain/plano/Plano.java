package com.nodebounty.domain.plano;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Setter
@Table(name = "PLANOS")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPLANO")
    private Long idPlano;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PORCENTAGEMCASHBACK")
    private double porcentagemCashback;

    @Column(name = "PARCERIAS")
    private String parcerias;


}


