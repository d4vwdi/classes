package com.nodebounty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/escolherplano")
@CrossOrigin(origins = "*")
public class ContaCorrenteController {
    @GetMapping
    public String getEscolherPlano() {
        return "cadastro"; // Isso corresponderá ao nome do seu arquivo HTML, por exemplo, "cadastro.html".
    }
}

