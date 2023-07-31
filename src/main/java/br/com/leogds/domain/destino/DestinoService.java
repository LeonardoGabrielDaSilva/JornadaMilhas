package br.com.leogds.domain.destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leogds.domain.destino.dto.DadosDestino;
import br.com.leogds.domain.destino.dto.DadosDestinoCompleto;
import br.com.leogds.domain.destino.dto.DadosDestinoId;
import jakarta.validation.Valid;

@Service
public class DestinoService {

	@Autowired
	public DestinoRepository destinoRepository;

	public DadosDestino criar(@Valid DadosDestino dadosDestino) {
		Destino destino = new Destino(dadosDestino.nome(), dadosDestino.preco(),
				dadosDestino.foto());
		destinoRepository.save(destino);
		return dadosDestino;
	}

	public DadosDestino atualizar(@Valid DadosDestinoCompleto dadosDestinoCompleto) {
		Destino destino = destinoRepository.findById(dadosDestinoCompleto.id()).get();
		destino.setNome(dadosDestinoCompleto.nome());
		destino.setPreco(dadosDestinoCompleto.preco());
		destino.setFoto(dadosDestinoCompleto.foto());
		destinoRepository.save(destino);
		return new DadosDestino(destino);
	}

	public DadosDestinoCompleto ler(@Valid DadosDestinoId dadosDestinoId) {
		Destino destino = destinoRepository.findById(dadosDestinoId.id()).get();
		return new DadosDestinoCompleto(destino);	
	}

	public void excluir(@Valid DadosDestinoId dadosDestinoId) {
		destinoRepository.deleteById(dadosDestinoId.id());
	}

}
