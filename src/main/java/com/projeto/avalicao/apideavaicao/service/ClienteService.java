package com.projeto.avalicao.apideavaicao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.Dto.RenomearClienteDto;
import com.projeto.avalicao.apideavaicao.erroTratamento.ErroDeBadRequest;
import com.projeto.avalicao.apideavaicao.mapper.ConveterClassDto;
import com.projeto.avalicao.apideavaicao.model.Cliente;
import com.projeto.avalicao.apideavaicao.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ConveterClassDto conveterClassDto;

	public List<ClienteDto> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return conveterClassDto.conerterListClienteDto(clientes);
	}

	public ClienteDto busarClienteId(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			String msg = String.format("Cliente id: %s não exixte", id);
			throw new ErroDeBadRequest(msg);		
		}			
		return conveterClassDto.converterClienteIsClienteDto(clienteOptional.get());		
		
	}

	public List<ClienteDto> busarClienteNome(String nome) {	
		List<Cliente> clientes = clienteRepository.findByNome(nome);
		return conveterClassDto.conerterListClienteDto(clientes);
	}

	public void deletarCliente(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
			String msg = String.format("Cliente id: %s não exixte", id);
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
			return conveterClassDto.converterClienteIsClienteDto(clienteRepository.save(cliente));
		}
		String msg = String.format("Cliente id: %s não exixte", renomearClienteDto.id);
		throw new ErroDeBadRequest(msg);

	}

	public ClienteDto addCliente(Cliente cliente) {	
		return conveterClassDto.converterClienteIsClienteDto(clienteRepository.save(cliente));		
	}
 
}
