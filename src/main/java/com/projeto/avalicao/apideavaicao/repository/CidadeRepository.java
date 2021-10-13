package com.projeto.avalicao.apideavaicao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.avalicao.apideavaicao.model.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	Cidade findByNome(String nome);
	
	List<Cidade> findByEstado_nome(String estado);

}
