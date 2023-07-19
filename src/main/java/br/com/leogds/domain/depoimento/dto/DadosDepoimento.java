package br.com.leogds.domain.depoimento.dto;

import br.com.leogds.domain.depoimento.Depoimento;
import jakarta.validation.constraints.NotBlank;

public record DadosDepoimento(
		@NotBlank String nome, 
		@NotBlank String depoimento, 
		@NotBlank String foto) {

	public DadosDepoimento(Depoimento depoimento) {
		this(depoimento.getNome(), depoimento.getDepoimento(), depoimento.getFoto());
	}
}
