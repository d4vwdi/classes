package com.nodebounty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nodebounty.domain.contacorrente.Contacorrente;
import com.nodebounty.domain.contacorrente.ContacorrenteRepository;

@Controller

public class TransacaoController {
	
    private final ContacorrenteRepository contacorrenteRepository;

    public TransacaoController(ContacorrenteRepository contacorrenteRepository) {
        this.contacorrenteRepository = contacorrenteRepository;
    }
    @GetMapping("/transacao")
    public String transacaoPage(Model model) {
        Contacorrente conta1 = new Contacorrente();
        conta1.setSaldoConta(180.00);
        
        model.addAttribute("conta1", conta1);
        
        return "transacao";
    }

}
