package br.com.leogds.domain.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leogds.domain.destino.dto.DadosDestino;
import br.com.leogds.domain.destino.dto.DadosDestinoCompleto;
import br.com.leogds.domain.destino.dto.DadosDestinoId;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;

	@PostMapping
	public ResponseEntity<DadosDestino> criar(@RequestBody @Valid DadosDestino dadosDestino) {
		return ResponseEntity.status(HttpStatus.CREATED).body(destinoService.criar(dadosDestino));
	}

	@GetMapping
	public ResponseEntity<DadosDestinoCompleto> ler(@RequestBody @Valid DadosDestinoId dadosDestinoId) {
		return ResponseEntity.ok().body(destinoService.ler(dadosDestinoId));
	}

	@PutMapping
	public ResponseEntity<DadosDestino> atualizar(
			@RequestBody @Valid DadosDestinoCompleto dadosDestinoCompleto) {
		return ResponseEntity.ok().body(destinoService.atualizar(dadosDestinoCompleto));
	}

	@DeleteMapping
	public ResponseEntity<DadosDestino> excluir(@RequestBody @Valid DadosDestinoId dadosDestinoId) {
		return ResponseEntity.noContent().build();
	}


}
