package org.rabbitmq.dto;

import java.io.Serializable;

public class PrecoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String codigoProduto;
	private Double preco;
	
	public PrecoDto() {
	}
	
	public PrecoDto(String codigoProduto, Double preco) {
		super();
		this.codigoProduto = codigoProduto;
		this.preco = preco;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
