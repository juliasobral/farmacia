package com.farmacia.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.model.Categoria;

@Repository
public interface CategoriaFarmaciaRepository extends JpaRepository<Categoria, Long> {

	Object findAll = null;

	public List<Categoria> findAllByMarca(String marca);

	public List<Categoria> findAll();
	
}
