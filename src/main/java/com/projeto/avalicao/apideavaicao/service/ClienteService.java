package com.projeto.avalicao.apideavaicao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.Dto.RenomearClienteDto;
import com.projeto.avalicao.apideavaicao.erroTratamento.ErroDeBadRequest;
import com.projeto.avalicao.apideavaicao.mapper.ConverterClass;
import com.projeto.avalicao.apideavaicao.model.Cliente;
import com.projeto.avalicao.apideavaicao.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ConverterClass conveterClassDto;

	public List<ClienteDto> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		return conveterClassDto.converterEmListaClienteDto(clientes);
	}

	public ClienteDto buscarClienteId(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			String msg = String.format("Cliente id: %s não existe", id);
			throw new ErroDeBadRequest(msg);		
		}			
		return conveterClassDto.converterClienteEmClienteDto(clienteOptional.get());		
		
	}

	public List<ClienteDto> buscarClienteNome(String nome) {	
		List<Cliente> clientes = clienteRepository.findByNome(nome);
		return conveterClassDto.converterEmListaClienteDto(clientes);
	}

	public void deletarCliente(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			String msg = String.format("Cliente id: %s não existe", id);
			throw new ErroDeBadRequest(msg);		
		}
			Cliente cliente = clienteOptional.get();
			clienteRepository.delete(cliente);
	}

	public ClienteDto renomearCliente(RenomearClienteDto renomearClienteDto) {

		Optional<Cliente> clienteOptional = clienteRepository.findById(renomearClienteDto.id);
		if (clienteOptional.isPresent()) {

			Cliente cliente = clienteOptional.get();
			cliente.setNome(renomearClienteDto.nome);
			return conveterClassDto.converterClienteEmClienteDto(clienteRepository.save(cliente));
		}
		String msg = String.format("Cliente id: %s não existe", renomearClienteDto.id);
		throw new ErroDeBadRequest(msg);

	}

	public ClienteDto salvarCliente(Cliente cliente) {	
		return conveterClassDto.converterClienteEmClienteDto(clienteRepository.save(cliente));		
	}
 
}
