package br.com.leogds.domain.destino.dto;

import java.math.BigDecimal;

import br.com.leogds.domain.destino.Destino;
import jakarta.validation.constraints.NotBlank;

public record DadosDestino(
		@NotBlank String nome, 
		@NotBlank BigDecimal preco, 
		@NotBlank String foto) {

	public DadosDestino(Destino destino) {
		this(destino.getNome(), destino.getPreco(), destino.getFoto());
	}
}
