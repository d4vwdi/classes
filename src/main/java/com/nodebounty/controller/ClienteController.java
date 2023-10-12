package com.nodebounty.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodebounty.domain.cliente.Cliente;
import com.nodebounty.domain.cliente.ClienteRepository;
import com.nodebounty.domain.cliente.DadosAtualizacaoCliente;
import com.nodebounty.domain.cliente.DadosCadastroCliente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")

/*
 * RequestMapping mostra por qual endpoint esse controller é responsável.
 * RestController define um controller
 * CrossOrigin desativa restrições de CORS. Declara aqui pra não precisar ficar declarando em todos os métodos
 */

public class ClienteController {
	@Autowired /* Injeção de dependência */
	private ClienteRepository repository;

	@GetMapping

	/*
	 * GetMapping Indica que esse método abaixo é responsável por cuidar das
	 * requisições que baterem no /Clientes e sejam do método get
	 */

	public ResponseEntity<?> GetAllClientes() {
		var allClientes = repository.findAll();
		return ResponseEntity.ok(allClientes);
		/*
		 * ResponseEntity é o tipo de classe utilizada para a manipulação de dados
		 * retornados
		 */
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> registerClientes(@RequestBody @Valid DadosCadastroCliente data) {
		Cliente newCliente = new Cliente(data);
		repository.save(newCliente);
		System.out.print(data);
		return ResponseEntity.ok().build();
		/*
		 * RequestBody indica que ele quer buscar os valores mostrados através da
		 * requisição feita O valid vai fazer a validação do body que chegou via
		 * requisição pelo record requestclientes Exemplo: precisa vir um nome que é uma
		 * string e um endereço que também é uma string.
		 */

		/*
		 * o método ok() sem parâmetros é retornado um objeto do tipo BodyBuilder, mas o
		 * método ok(...) com parâmetros já devolve direto um objeto ResponseEntity.
		 */
	}

	@PutMapping /* putmapping é o método para atualizar */
	@Transactional
	public ResponseEntity<?> updateCliente(@RequestBody @Valid DadosAtualizacaoCliente data) {
		Optional<Cliente> optionalCliente = repository.findById(data.id());

		if (optionalCliente.isPresent()) {
			Cliente cliente = optionalCliente.get();
			cliente.atualizarDados(data);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
