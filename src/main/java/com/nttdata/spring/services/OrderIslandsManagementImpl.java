package com.nttdata.spring.services;

import java.util.List;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.persistence.Order;
import com.nttdata.spring.persistence.Product;
import com.nttdata.spring.repository.OrderRepositoryI;

/**
 * Taller Spring - 2
 * 
 * Implementacion de Pedido (islas)
 * 
 * @author Rafael José
 *
 */

@Service("islandsService")
public class OrderIslandsManagementImpl implements OrderManagementI{
	
	@Autowired
	OrderRepositoryI orderRepo;

	@Override
	public void createOrder(Order order, String addressee, String address, boolean peninsula) {
		
		// Creamos un pedido sin productos asociados.
		order.setAddresseeName(addressee);
		order.setDeliveryAddress(address);
		order.setPeninsulaShipment(peninsula);
	}

	@Override
	public void addProductToAnOrder(Order order, Product product) {
		
		// Añadimos el producto a la lista del pedido.
		List<Product> products = order.getProductsList();
		products.add(product);
		order.setProductsList(products);
	}

	@Override
	public double breakdownOrder(Order order) {
		double totalPrice = 0;
		List<Product> products = order.getProductsList();
		for (Product product : products) {
			
			// Obtenemos el precio de cada producto, le añadimos el impuesto, redondeamos y sumamos al total.
			double productPrice = product.getPrice();
			double erpPrice = productPrice + (productPrice * 4 / 100);
			double roundedPrice = Precision.round(erpPrice, 2);
			product.setErpPrice(roundedPrice);
			totalPrice += erpPrice;
		}
		
		// Devolvemos el total de precios del pedido.
		return Precision.round(totalPrice, 2);
	}

	@Override
	public void addOrder(Order order) {
		orderRepo.save(order);
	}
	
	@Override
	public void deleteOrder(Order order) {
		orderRepo.delete(order);
	}

	@Override
	public List<Order> findByPeninsulaShipment(boolean peninsulaShipment) {
		return orderRepo.findByPeninsulaShipment(peninsulaShipment);
	}
}
