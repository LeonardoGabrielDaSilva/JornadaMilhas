package br.com.leogds.domain.depoimento;

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
public class Depoimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;

	@NotBlank
	private String depoimento;	
	
	@NotBlank
	private String foto;
	
	
	public Depoimento(String nome, String depoimento, String foto) {
		super();
		this.nome = nome;
		this.depoimento = depoimento;
		this.foto = foto;
	}
}
