package com.microservico.estoquepreco.connections;

import org.rabbitmq.contantes.RabbitMQConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
	
	private static final String NOME_EXCHANGE = "amq.direct";
	private AmqpAdmin amqpAdmin;
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}

	private Queue fila(String nomeFila) {
		return new Queue(nomeFila, true, false, false);
	}
	
	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
	}
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
	}
	
	@PostConstruct
	private void adicionar() {
	Queue filaEstoque = this.fila(RabbitMQConstantes.FILA_ESTOQUE);
	Queue filaPreco = this.fila(RabbitMQConstantes.FILA_PRECO);
	
	DirectExchange troca = this.trocaDireta();
	
	Binding ligacao = this.relacionamento(filaEstoque, troca);
	
	this.amqpAdmin.declareQueue(filaEstoque);
	this.amqpAdmin.declareQueue(filaPreco);
	
	this.amqpAdmin.declareExchange(troca);
	this.amqpAdmin.declareBinding(ligacao);
	}
}
