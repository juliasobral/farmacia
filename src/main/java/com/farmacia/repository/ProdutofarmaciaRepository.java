package com.farmacia.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.model.Produto;

public interface ProdutofarmaciaRepository extends JpaRepository<Produto, Long> {

	Object findAll = null;

	public List<Produto> findAllByValor(String valor);

	public List<Produto> findAll();

}
