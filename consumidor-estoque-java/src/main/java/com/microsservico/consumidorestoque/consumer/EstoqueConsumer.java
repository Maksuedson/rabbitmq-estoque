package com.microsservico.consumidorestoque.consumer;

import org.rabbitmq.contantes.RabbitMQConstantes;
import org.rabbitmq.dto.EstoqueDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

  @RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
  private void consumidor(EstoqueDto estoqueDto){
    System.out.println(estoqueDto.getCodigoProduto());
    System.out.println(estoqueDto.getQuantidade());
    System.out.println("------------------------------------");
  }
}
