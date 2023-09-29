package com.microservico.estoquepreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservico.estoquepreco.constantes.RabbitMQConstantes;
import com.microservico.estoquepreco.dto.EstoqueDto;
import com.microservico.estoquepreco.service.RabbitMQService;

@RestController
@RequestMapping ("estoque")
public class EstoqueController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@PutMapping
	private ResponseEntity alterarEstoque(@RequestBody EstoqueDto estoqueDto) {
		System.out.println(estoqueDto.getCodigoProduto());
		
		this.rabbitMQService.enviarMensagem(RabbitMQConstantes.FILA_ESTOQUE, estoqueDto);
		return new ResponseEntity(HttpStatus.OK);
	}

}
