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
public interface ProductManagementI {

	// Métodos para implementar.
	public void createProduct(Product product, String name, double price);
	public void setOrder(Product product, Order order);
	public void addProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> findByProductName(final String productName);
}
