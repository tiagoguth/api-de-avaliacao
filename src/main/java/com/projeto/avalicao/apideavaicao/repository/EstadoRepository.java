package com.projeto.avalicao.apideavaicao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.avalicao.apideavaicao.model.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Estado findByNome(String estado);

}
