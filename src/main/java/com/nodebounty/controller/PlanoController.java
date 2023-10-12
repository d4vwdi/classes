package com.nodebounty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodebounty.domain.plano.PlanoRepository;

@RestController
@RequestMapping("/planos")
@CrossOrigin(origins = "*")
public class PlanoController {
	
	/* A classe de plano não vai ser muito manipulada né. Só tem esse método de listagem mesmo, então acho que
	 * Não tem necessidade de criar uma classe de serviço. Melhor usar o repository direto igual na classe Cliente
	 */
	
	@Autowired
	private PlanoRepository repository;

	/* Rota de GET para listar todos os planos do banco. */
	/* Estamos retornando uma resposta 200 (ok) com o body contendo a listagem de todos os planos */
	@GetMapping
	public ResponseEntity<Object> consultaTodos(){
		var planos = repository.findAll();
		return ResponseEntity.ok(planos);
	}
	
}
