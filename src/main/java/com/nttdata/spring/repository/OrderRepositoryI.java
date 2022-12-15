package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.spring.persistence.Order;

/**
 * Taller Spring - 2
 * 
 * Repositorio de pedidos.
 * 
 * @author Rafael José
 *
 */

@Repository
public interface OrderRepositoryI extends JpaRepository<Order, Long> {

	/**
	 * Búsqueda de pedidos enviados a la Península.
	 * 
	 * @param peninsulaShipment
	 * @return List<Order>
	 */
	public List<Order> findByPeninsulaShipment(final boolean peninsulaShipment);
}
