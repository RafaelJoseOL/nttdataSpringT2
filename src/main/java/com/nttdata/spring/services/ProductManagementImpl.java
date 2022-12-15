package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Order;
import com.nttdata.spring.persistence.Product;
import com.nttdata.spring.repository.ProductRepositoryI;

/**
 * Taller Spring - 2
 * 
 * Implementacion de Producto
 * 
 * @author Rafael José
 *
 */

@Service("product")
public class ProductManagementImpl implements ProductManagementI {

	@Autowired
	ProductRepositoryI productRepo;
	
	@Override
	public void createProduct(Product product, String name, double price) {
		product.setProductName(name);
		product.setPrice(price);
	}
	
	@Override public void setOrder(Product product, Order order) {
		product.setOrder(order);
	}

	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepo.delete(product);
	}

	@Override
	public List<Product> findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}
}
