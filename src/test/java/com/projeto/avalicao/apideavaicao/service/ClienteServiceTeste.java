package com.projeto.avalicao.apideavaicao.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.avalicao.apideavaicao.CargaDados;
import com.projeto.avalicao.apideavaicao.Dto.CidadeDto;
import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.mapper.ConverterClass;
import com.projeto.avalicao.apideavaicao.model.Cidade;
import com.projeto.avalicao.apideavaicao.model.Cliente;
import com.projeto.avalicao.apideavaicao.repository.ClienteRepository;

@SpringBootTest
public class ClienteServiceTeste extends CargaDados{
	
	@InjectMocks
	private ClienteService clienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	@Mock
	private ConverterClass conveterClassDto;
	
	@Spy
	private ModelMapper modelMapper;
	
	public void init() {
		ModelMapper mapper = new ModelMapper();
		
		mapper.createTypeMap(Cliente.class, ClienteDto.class)
		.<String>addMapping(src -> src.getCidade().getNome(), ClienteDto::setCidade)
		.<String>addMapping(src -> src.getCidade().getEstado().getNome(), ClienteDto::setEstado);
		
		mapper.createTypeMap(Cidade.class, CidadeDto.class)
		.<String>addMapping(src -> src.getNome(), CidadeDto::setCidade)
		.<String>addMapping(src -> src.getEstado().getNome(), CidadeDto::setEstado);
		
	}
	
//	@Test
//	public void testaListar() {
//		
//		List<Cliente> clientes = lista();	
//		when(clienteRepository.findAll()).thenReturn(clientes);
//		when(conveterClassDto.conerterListClienteDto(clientes)).thenReturn(clientedtolidt());
//		Assert.assertEquals(clienteService.lista(), clientedtolidt());
//		
//	}
//	

//	@Test
//	public void testabusarClienteId() throws ErroDeBadRequest{
//		
//		Optional<Cliente> cr = null;
//		when(clienteRepository.findById(Mockito.anyLong())).thenReturn(cr);
//		
//		
//		
//	}
//	
}
