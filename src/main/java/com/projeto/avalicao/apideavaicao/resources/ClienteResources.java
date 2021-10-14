package com.projeto.avalicao.apideavaicao.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.Dto.RenomearClienteDto;
import com.projeto.avalicao.apideavaicao.model.Cliente;
import com.projeto.avalicao.apideavaicao.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
@Api(value = "Api Rest Cliente")
@CrossOrigin(origins = "*")
public class ClienteResources {
	
	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Retorna uma lista de clientes")
	@GetMapping("/listar")
	public List<ClienteDto> listar(){
		return clienteService.listar();
	}
	
	@GetMapping("/buscarClienteId/{id}")
	@ApiOperation(value = "Buscar cliente pelo seu ID")
	public ClienteDto buscarClienteId(@PathVariable(value="id") Long id) {
		return clienteService.buscarClienteId(id);
	} 
	
	@GetMapping("/buscarClienteNome/{nome}")
	@ApiOperation(value = "Buscar cliente pelo seu Nome")
	public List<ClienteDto> buscarClienteNome(@PathVariable(value="nome") String nome) {
		return clienteService.buscarClienteNome(nome);
	} 
	
	@DeleteMapping ("/remover/{id}")
	@Transactional
	@ApiOperation(value = "Remover cliente pelo Id")
	public void deletarCliente(@PathVariable(value="id") Long id) {
		 clienteService.deletarCliente(id);
		 
	} 
	@PutMapping("/renomearCliente")
	@ApiOperation(value = "Renomear o cliente")
	public ClienteDto renomearCliente(@RequestBody RenomearClienteDto renomearClienteDto ) {
		return clienteService.renomearCliente(renomearClienteDto);
		
	}
	
	@PostMapping("/salvarCliente")
	@ApiOperation(value = "Adicionar novo cliente")
	public ClienteDto salvarCliente(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
}
