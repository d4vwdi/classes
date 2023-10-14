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

            //Esta linha verifica se a variável planoSelecionado não é nula (null) e se não está vazia.
            // Em outras palavras, estamos verificando se o usuário selecionou algum plano antes de continuar com o processamento.
        if (planoSelecionado != null && !planoSelecionado.isEmpty()) {

            // Nesta linha, estamos usando o planoRepository (um repositório JPA) para buscar um objeto Plano com base no nome do plano selecionado.
            // O método findByNomePlano é personalizado no repositório e permite encontrar um plano com o nome correspondente ao planoSelecionado.
            Plano plano = planoRepository.findByNomePlano(planoSelecionado);

            // Aqui estamos criando uma nova instância da classe Contacorrente.
            // Esta instância representará a conta corrente que será associada ao plano selecionado.
            Contacorrente contaCorrente = new Contacorrente();
            // Nesta linha, estamos associando o plano selecionado à conta corrente que acabamos de criar.
            // Isso significa que a conta corrente será vinculada ao plano escolhido pelo usuário.
            contaCorrente.setPlanosConta(plano);

            // Por fim, estamos usando o contacorrenteRepository para salvar a conta corrente no banco de dados.
            // Isso efetivamente cria um registro de conta corrente no banco de dados com o plano selecionado pelo usuário.
            contacorrenteRepository.save(contaCorrente);
        }
        return null;
    }

}


