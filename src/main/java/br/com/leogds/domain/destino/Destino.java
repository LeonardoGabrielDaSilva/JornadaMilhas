package br.com.leogds.domain.destino;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;

	@NotBlank
	private BigDecimal preco;	
	
	@NotBlank
	private String foto;
	
	
	public Destino(String nome, BigDecimal preco, String foto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.foto = foto;
	}
}
