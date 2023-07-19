package br.com.leogds.domain.depoimento;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.leogds.domain.depoimento.dto.DadosDepoimento;
import br.com.leogds.domain.depoimento.dto.DadosDepoimentoCompleto;
import br.com.leogds.domain.depoimento.dto.DadosDepoimentoId;
import jakarta.validation.Valid;

public class DepoimentoService {

	@Autowired
	public DepoimentoRepository depoimentoRepository;

	public DadosDepoimento criar(@Valid DadosDepoimento dadosDepoimento) {
		Depoimento depoimento = new Depoimento(dadosDepoimento.nome(), dadosDepoimento.depoimento(),
				dadosDepoimento.foto());
		depoimentoRepository.save(depoimento);
		return dadosDepoimento;
	}

	public DadosDepoimento atualizar(@Valid DadosDepoimentoCompleto dadosDepoimentoCompleto) {
		Depoimento depoimento = depoimentoRepository.findById(dadosDepoimentoCompleto.id()).get();
		depoimento.setNome(dadosDepoimentoCompleto.nome());
		depoimento.setDepoimento(dadosDepoimentoCompleto.depoimento());
		depoimento.setFoto(dadosDepoimentoCompleto.foto());
		depoimentoRepository.save(depoimento);
		return new DadosDepoimento(depoimento);
	}

	public DadosDepoimentoCompleto ler(@Valid DadosDepoimentoId dadosDepoimentoId) {
		Depoimento depoimento = depoimentoRepository.findById(dadosDepoimentoId.id()).get();
		return new DadosDepoimentoCompleto(depoimento);
	}

	public void excluir(@Valid DadosDepoimentoId dadosDepoimentoId) {
		depoimentoRepository.deleteById(dadosDepoimentoId.id());
	}

	public List<DadosDepoimento> ler3DepoimentosAleatorios() {
		List<Depoimento> depoimentosAleatorios = depoimentoRepository.find3Random();
		List<DadosDepoimento> depoimentosAleatoriosDto = depoimentosAleatorios.stream()
				.map(d -> new DadosDepoimento(d.getNome(), d.getDepoimento(), d.getFoto()))
				.collect(Collectors.toList());
		return depoimentosAleatoriosDto;
	}

}
