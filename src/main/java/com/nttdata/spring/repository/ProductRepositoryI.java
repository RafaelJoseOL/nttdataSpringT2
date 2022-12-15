package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.persistence.Product;

/**
 * Taller Spring - 2
 * 
 * Repositorio de productos.
 * 
 * @author Rafael José
 *
 */

@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Long> {

	/**
	 * Búsqueda de productos por nombre.
	 * 
	 * @param productName
	 * @return List<Product>
	 */
	public List<Product> findByProductName(final String productName);
}