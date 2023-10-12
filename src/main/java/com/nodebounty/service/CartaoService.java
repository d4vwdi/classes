package com.nodebounty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodebounty.domain.cartao.Cartao;
import com.nodebounty.domain.cartao.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	/*
	 * Método para listar todos os cartões do banco. Poderiamos usar o repository
	 * direto no controller e chamar o findAll() lá? Poderiamos, mas eu desconfio
	 * que eventualmente vamos precisar usar de fato uma classe de serviço pro
	 * cartão, então melhor deixar aqui mesmo
	 */

	/*
	 * TALVEZ O PROFESSOR RECLAME TAMBÉM, e a gente acabe tendo que criar um service
	 * pra todas as classes mesmo que possa usar o repository direto, vamos ver.
	 */

	public List<Cartao> listarTodosCartoes() {
		return repository.findAll();
	}
}
