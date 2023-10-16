package com.nodebounty;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		List<DadosErroValidacao> dadosErroValidacaoList = erros.stream().map(DadosErroValidacao::new).collect(Collectors.toList());
		return ResponseEntity.badRequest().body(dadosErroValidacaoList);
	}
	
	private record DadosErroValidacao(String campo, String mensagem) {
		
		public DadosErroValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
		
	}
}
