package br.com.leogds.domain.depoimento;

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

import br.com.leogds.domain.depoimento.dto.DadosDepoimento;
import br.com.leogds.domain.depoimento.dto.DadosDepoimentoCompleto;
import br.com.leogds.domain.depoimento.dto.DadosDepoimentoId;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

	@Autowired
	private DepoimentoService depoimentoService;

	@PostMapping
	public ResponseEntity<DadosDepoimento> criar(@RequestBody @Valid DadosDepoimento dadosDepoimento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(depoimentoService.criar(dadosDepoimento));
	}

	@GetMapping
	public ResponseEntity<DadosDepoimentoCompleto> ler(@RequestBody @Valid DadosDepoimentoId dadosDepoimentoId) {
		return ResponseEntity.ok().body(depoimentoService.ler(dadosDepoimentoId));
	}

	@PutMapping
	public ResponseEntity<DadosDepoimento> atualizar(@RequestBody @Valid DadosDepoimentoCompleto dadosDepoimentoCompleto) {
		return ResponseEntity.ok().body(depoimentoService.atualizar(dadosDepoimentoCompleto));
	}

	@DeleteMapping
	public ResponseEntity<DadosDepoimento> excluir(@RequestBody @Valid DadosDepoimentoId dadosDepoimentoId) {
		return ResponseEntity.noContent().build();
	}
	
	
}
