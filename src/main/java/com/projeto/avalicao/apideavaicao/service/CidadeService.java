package com.projeto.avalicao.apideavaicao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avalicao.apideavaicao.Dto.CidadeDto;
import com.projeto.avalicao.apideavaicao.mapper.ConveterClassDto;
import com.projeto.avalicao.apideavaicao.model.Cidade;
import com.projeto.avalicao.apideavaicao.model.Estado;
import com.projeto.avalicao.apideavaicao.repository.CidadeRepository;
import com.projeto.avalicao.apideavaicao.repository.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ConveterClassDto conveterClassDto;
	
	public List<CidadeDto> listaCliente() {
		
		return conveterClassDto.conerterListCiadeDto(cidadeRepository.findAll());
		 
	}

	public Cidade salvarCidade(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public CidadeDto buscarCidadeNome(String nome) {
		return conveterClassDto.converterCidadeIsCidadeDto(cidadeRepository.findByNome(nome));
	}

	public List<CidadeDto> bucarCidadePorEstado(String estado) {
		return conveterClassDto.conerterListCiadeDto(cidadeRepository.findByEstado_nome(estado));
	}

	public Estado salvarEstado(Estado estado) {
		return estadoRepository.save(estado);
	}

}
