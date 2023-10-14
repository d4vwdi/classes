package com.nodebounty.controller;

import ch.qos.logback.core.model.Model;
import com.nodebounty.domain.contacorrente.Contacorrente;
import com.nodebounty.domain.contacorrente.ContacorrenteRepository;
import com.nodebounty.domain.plano.Plano;
import com.nodebounty.domain.plano.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/escolherplano")
@CrossOrigin(origins = "*")
public class ContaCorrenteController {

    @Autowired
    private ContacorrenteRepository contacorrenteRepository;
    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping
    public String getEscolherPlano() {
        return "escolherplano"; // Isso corresponderá ao nome do arquivo HTML, no caso, "escolherplano.html".
    }

    @PostMapping
    public String processarEscolhaPlano(@RequestParam(name = "plano", required = false) String planoSelecionado) {
        if (planoSelecionado != null && !planoSelecionado.isEmpty()) {
            // Aqui você pode buscar o objeto Plano correspondente ao plano selecionado
            Plano plano = planoRepository.findByNomePlano(planoSelecionado);

            // Crie uma instância de ContaCorrente e associe o plano selecionado
            Contacorrente contaCorrente = new Contacorrente();
            contaCorrente.setPlanosConta(plano);

            // Salve a ContaCorrente no banco de dados
            contacorrenteRepository.save(contaCorrente);
        }
        return null;
    }

}


