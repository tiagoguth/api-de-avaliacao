package com.projeto.avalicao.apideavaicao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;

import com.projeto.avalicao.apideavaicao.Dto.ClienteDto;
import com.projeto.avalicao.apideavaicao.mapper.ConveterClassDto;
import com.projeto.avalicao.apideavaicao.model.Cidade;
import com.projeto.avalicao.apideavaicao.model.Cliente;
import com.projeto.avalicao.apideavaicao.model.Estado;

public class CargaDados {
	
	@Autowired
	private ConveterClassDto conveterClassDto;
	
	public List<Cliente> lista() {
		List<Cliente> clientes = new ArrayList<>();
		Estado estado = new Estado();
		estado.setId(1L);
		estado.setNome("Santa  Catarina");
		
		Cidade cidade = new Cidade();
		cidade.setId(1l);
		cidade.setNome("Itapiranga");
		cidade.setEstado(estado);
		
		Cliente cliente = new Cliente();
		cliente.setCidade(cidade);
		cliente.setId(1l);
		cliente.setIdade(10);
		cliente.setNome("Luiz");
		cliente.setDataNascimento(new Date());
		String sx = "m";
		cliente.setSexo(sx.charAt(0));
		
		Cliente cliente2 = new Cliente();
		cliente2.setCidade(cidade);
		cliente2.setId(2l);
		cliente2.setIdade(11);
		cliente2.setNome("Luizinho");
		cliente2.setDataNascimento(new Date());
		cliente2.setSexo(sx.charAt(0));
		
		clientes.add(cliente);
		clientes.add(cliente2);
		
		return clientes;
	}
	
	public List<ClienteDto> clientedtolidt() {
		return conveterClassDto.conerterListClienteDto(lista());
		
	}
	
	public Optional<Cliente> cliente() {
		Estado estado = new Estado();
		estado.setId(1L);
		estado.setNome("Santa  Catarina");
		
		Cidade cidade = new Cidade();
		cidade.setId(1l);
		cidade.setNome("Itapiranga");
		cidade.setEstado(estado);
		
	
		Cliente cliente = new Cliente();
		cliente.setCidade(cidade);
		cliente.setId(1l);
		cliente.setIdade(10);
		cliente.setNome("Luiz");
		cliente.setDataNascimento(new Date());
		String sx = "m";
		cliente.setSexo(sx.charAt(0));
		
		Optional<Cliente> optional = Optional.ofNullable(cliente);
		return optional;
	}
	
	public ClienteDto clienteDtot() {
		return conveterClassDto.converterClienteIsClienteDto(cliente().get());
		
	}
}
