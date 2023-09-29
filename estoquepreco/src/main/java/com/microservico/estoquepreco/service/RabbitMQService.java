package com.microservico.estoquepreco.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
	
	@Autowired
	RabbitTemplate tabbitTemplate;
	
	public void enviarMensagem(String nomeFila, Object mensagem) {
		this.tabbitTemplate.convertAndSend(nomeFila, mensagem);
	}

}
