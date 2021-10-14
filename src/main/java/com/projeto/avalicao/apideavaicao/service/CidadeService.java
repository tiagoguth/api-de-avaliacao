package com.projeto.avalicao.apideavaicao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avalicao.apideavaicao.Dto.CidadeDto;
import com.projeto.avalicao.apideavaicao.mapper.ConverterClass;
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
	private ConverterClass conveterClassDto;
	
	public List<CidadeDto> listaCidade() {
		
		return conveterClassDto.converterParaListaCidadeDto(cidadeRepository.findAll());
		 
	}

	public Cidade salvarCidade(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	public CidadeDto buscarCidadeNome(String nome) {
		return conveterClassDto.converterCidadeEmCidadeDto(cidadeRepository.findByNome(nome));
	}

	public List<CidadeDto> buscarCidadePorEstado(String estado) {
		return conveterClassDto.converterParaListaCidadeDto(cidadeRepository.findByEstado_nome(estado));
	}

	public Estado salvarEstado(Estado estado) {
		return estadoRepository.save(estado);
	}

}
