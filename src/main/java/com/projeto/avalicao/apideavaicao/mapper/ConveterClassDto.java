package com.projeto.avalicao.apideavaicao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.projeto.avalicao.apideavaicao.Dto.CidadeDto;
import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.model.Cidade;
import com.projeto.avalicao.apideavaicao.model.Cliente;

@Configuration
public class ConveterClassDto {

	@Autowired
	private ModelMapper modelMapper;
	
	public ClienteDto converterClienteIsClienteDto(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDto.class);
	}
	
	public CidadeDto converterCidadeIsCidadeDto(Cidade cidade) {
		return modelMapper.map(cidade, CidadeDto.class);
	}
	
	public List<ClienteDto> conerterListClienteDto(List<Cliente> clientes){
		List<ClienteDto> clienteDtos = new ArrayList<>(); 		
		for(Cliente cliente : clientes) {
			clienteDtos.add(converterClienteIsClienteDto(cliente));
		}
		return clienteDtos;
	}
	public List<CidadeDto> conerterListCiadeDto(List<Cidade> cidades){
		List<CidadeDto> cidadeDtos = new ArrayList<>(); 		
		for(Cidade cidade: cidades) {
			cidadeDtos.add(converterCidadeIsCidadeDto(cidade));
		}
		return cidadeDtos;
	}
	
 }
