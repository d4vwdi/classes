package com.nodebounty;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
	
	/* Aqui é pra tratar erro de validação. Por padrão, uma exception dessas traz VAAAAARIOS DADOS, mas pra ficar melhor 
	 * Pra cada um dos erros, eu vou filtrar eles usando o DTO abaixo e retornando apenas os campos de mensagem e campo em si*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
	}
	
	/* DTO Para definir quais dados devem ser retornados dos objetos de erros por validação. No caso só a mensagem e o campo tá bom */
	private record DadosErroValidacao(String campo, String mensagem) {
		
		public DadosErroValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
		
	}
	
}
