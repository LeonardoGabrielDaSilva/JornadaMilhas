package br.com.leogds.domain.destino.dto;

import java.math.BigDecimal;

import br.com.leogds.domain.destino.Destino;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDestinoCompleto(
		@NotNull Long id, 
		@NotBlank String nome, 
		@NotBlank BigDecimal preco,
		@NotBlank String foto) {

	public DadosDestinoCompleto(Destino destino) {
		this(destino.getId(), destino.getNome(), destino.getPreco(), destino.getFoto());
	}
}
