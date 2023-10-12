package com.nodebounty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodebounty.service.CartaoService;

@RestController
@RequestMapping("/cartoes")
@CrossOrigin(origins = "*")
public class CartaoController {

	@Autowired
	private CartaoService service;

	/* Rota de GET para listar todos os cartões do banco. No projeto em si dificilmente será usada. No futuro sugiro remover */
	/* Estamos retornando uma resposta 200 (ok) com o body contendo a listagem de todos cartões */
	@GetMapping
	public ResponseEntity<Object> consultaTodos() {
		var cartoes = service.listarTodosCartoes();
		return ResponseEntity.ok(cartoes);
	}

}