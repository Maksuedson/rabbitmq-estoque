package com.microservico.estoquepreco.service;

import java.lang.runtime.ObjectMethods;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQService {
	
	@Autowired
	private RabbitTemplate tabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void enviarMensagem(String nomeFila, Object mensagem) {
		try {
			String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
			this.tabbitTemplate.convertAndSend(nomeFila, mensagemJson);
		} catch (Exception e) {
			e.getCause();
		}
	}

}
