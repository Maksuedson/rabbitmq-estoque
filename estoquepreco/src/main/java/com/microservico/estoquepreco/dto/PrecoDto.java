package com.microservico.estoquepreco.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PrecoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String codigoProduto;
	private Double preco;
}
