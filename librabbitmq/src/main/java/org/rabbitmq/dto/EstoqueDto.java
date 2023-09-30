package org.rabbitmq.dto;

import java.io.Serializable;

public class EstoqueDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String codigoProduto;
	private Integer quantidade;
	
	public EstoqueDto() {
	}
	
	public EstoqueDto(String codigoProduto, Integer quantidade) {
		super();
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
	}
	
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
