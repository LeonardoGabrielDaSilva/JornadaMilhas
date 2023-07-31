package br.com.leogds.domain.destino;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> buscarDestinoPorNome(@RequestParam String nome) {
		List<Optional<Destino>> destinos = destinoService.buscarDestinoPorNome(nome);
		if (destinos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum destino foi encontrado");
		}
		List<DadosDestino> destinosDto = destinos.stream()
				.map(d -> new DadosDestino(d.get().getNome(), d.get().getPreco(), d.get().getFoto()))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(destinosDto);
	}

	@GetMapping
	public ResponseEntity<DadosDestinoCompleto> ler(@RequestBody @Valid DadosDestinoId dadosDestinoId) {
		return ResponseEntity.ok().body(destinoService.ler(dadosDestinoId));
	}

	@PutMapping
	public ResponseEntity<DadosDestino> atualizar(@RequestBody @Valid DadosDestinoCompleto dadosDestinoCompleto) {
		return ResponseEntity.ok().body(destinoService.atualizar(dadosDestinoCompleto));
	}

	@DeleteMapping
	public ResponseEntity<DadosDestino> excluir(@RequestBody @Valid DadosDestinoId dadosDestinoId) {
		return ResponseEntity.noContent().build();
	}

}
