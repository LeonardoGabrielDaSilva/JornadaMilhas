package br.com.leogds.domain.depoimento.dto;

import br.com.leogds.domain.depoimento.Depoimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDepoimentoCompleto(
		@NotNull Long id, 
		@NotBlank String nome, 
		@NotBlank String depoimento,
		@NotBlank String foto) {

	public DadosDepoimentoCompleto(Depoimento depoimento) {
		this(depoimento.getId(), depoimento.getNome(), depoimento.getDepoimento(), depoimento.getFoto());
	}
}
