package com.nttdata.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Order;
import com.nttdata.spring.persistence.Product;

/**
 * Taller Spring - 2
 * 
 * Interfaz - Dos implementaciones (península e islas)
 * 
 * @author Rafael José
 *
 */

@Service
public interface OrderManagementI {

	// Métodos para implementar.
	public void createOrder(Order order, String addressee, String address, boolean peninsula);

	public void addProductToAnOrder(Order order, Product product);

	public double breakdownOrder(Order order);

	public void addOrder(Order order);

	public void deleteOrder(Order order);

	public List<Order> findByPeninsulaShipment(final boolean peninsulaShipment);
}