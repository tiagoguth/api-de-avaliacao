package com.projeto.avalicao.apideavaicao.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projeto.avalicao.apideavaicao.Dto.CidadeDto;
import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.model.Cidade;
import com.projeto.avalicao.apideavaicao.model.Cliente;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		
		mapper.createTypeMap(Cliente.class, ClienteDto.class)
		.<String>addMapping(src -> src.getCidade().getNome(), ClienteDto::setCidade)
		.<String>addMapping(src -> src.getCidade().getEstado().getNome(), ClienteDto::setEstado);
		
		mapper.createTypeMap(Cidade.class, CidadeDto.class)
		.<String>addMapping(src -> src.getNome(), CidadeDto::setCidade)
		.<String>addMapping(src -> src.getEstado().getNome(), CidadeDto::setEstado);
		
		return mapper;
	}
}
