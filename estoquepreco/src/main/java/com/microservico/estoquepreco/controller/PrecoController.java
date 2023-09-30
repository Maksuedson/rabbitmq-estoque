package com.microservico.estoquepreco.controller;

import org.rabbitmq.contantes.RabbitMQConstantes;
import org.rabbitmq.dto.PrecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservico.estoquepreco.service.RabbitMQService;

@RestController
@RequestMapping
public class PrecoController {
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	private ResponseEntity alterarPreco(@RequestBody PrecoDto precoDto) {
		System.out.println(precoDto.getCodigoProduto());
		this.rabbitMQService.enviarMensagem(RabbitMQConstantes.FILA_ESTOQUE, precoDto);
		return new ResponseEntity(HttpStatus.OK);
	}

}
