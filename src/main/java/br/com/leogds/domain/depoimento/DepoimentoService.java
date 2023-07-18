package br.com.leogds.domain.depoimento;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.leogds.domain.depoimento.dto.DadosDepoimento;
import br.com.leogds.domain.depoimento.dto.DadosDepoimentoCompleto;
import br.com.leogds.domain.depoimento.dto.DadosDepoimentoId;
import jakarta.validation.Valid;

public class DepoimentoService {

	@Autowired
	public DepoimentoRepository depoimentoRepository;

	public DadosDepoimento criar(@Valid DadosDepoimento dadosDepoimento) {
		Depoimento depoimento = new Depoimento(dadosDepoimento.nome(), dadosDepoimento.foto());
		depoimentoRepository.save(depoimento);
		return dadosDepoimento;
	}

	public DadosDepoimento atualizar(@Valid DadosDepoimentoCompleto dadosDepoimentoCompleto) {
		Depoimento depoimento = depoimentoRepository.findById(dadosDepoimentoCompleto.id()).get();
		depoimento.setNome(dadosDepoimentoCompleto.nome());
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

}
