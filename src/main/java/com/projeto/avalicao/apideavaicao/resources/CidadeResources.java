package com.projeto.avalicao.apideavaicao.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.avalicao.apideavaicao.Dto.CidadeDto;
import com.projeto.avalicao.apideavaicao.model.Cidade;
import com.projeto.avalicao.apideavaicao.model.Estado;
import com.projeto.avalicao.apideavaicao.service.CidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cidade")
@Api(value = "Api Rest Cidade e Estado")
@CrossOrigin(origins = "*")
public class CidadeResources {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/listar")
	@ApiOperation(value = "Retornar uma lista de cidades")
	public List<CidadeDto> listaCliente(){		
		return cidadeService.listaCliente();	
	}
	
	@PostMapping("/salvarCidade")
	@ApiOperation(value = "Adiciona uma nova cidade")
	public Cidade salvarCidade(@Valid @RequestBody  Cidade cidade) {
		return cidadeService.salvarCidade(cidade);
		
	}
	
	@PostMapping("/salvarEstado")
	@ApiOperation(value = "Adiciona um novo Estado")
	public Estado salvarEstado(@Valid @RequestBody  Estado estado) {
		return cidadeService.salvarEstado(estado);
		
	}
	
	@GetMapping("/bucarCidadeNome/{nome}")
	@ApiOperation(value = "Burcar cidade pelo seu nome")
	public CidadeDto bucarCidadeNome(@PathVariable(value="nome") String nome) {
		return cidadeService.buscarCidadeNome(nome);
	}
	
	@GetMapping("/bucarCidadePorEstado/{estado}")
	@ApiOperation(value = "Buscar cidade pelo seu Estado")
	public List<CidadeDto> bucarCidadePorEstado(@PathVariable(value="estado") String estado) {
		return cidadeService.bucarCidadePorEstado(estado); 
	}
	
	
	
	
	
}
