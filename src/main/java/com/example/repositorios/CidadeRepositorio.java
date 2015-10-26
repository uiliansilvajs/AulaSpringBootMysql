package com.example.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entidades.Cidade;

public interface CidadeRepositorio extends CrudRepository<Cidade, Long> {
	@Query("from Cidade order by nome")
	public List<Cidade> findAllOrderByNome();
}
