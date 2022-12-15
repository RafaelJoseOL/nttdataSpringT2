package com.nttdata.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.persistence.Order;
import com.nttdata.spring.persistence.Product;
import com.nttdata.spring.services.OrderManagementI;
import com.nttdata.spring.services.ProductManagementI;

/**
 * Taller Spring - 2
 * 	
 * Clase principal
 * 
 * @author Rafael José
 *
 */
@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {
	
	/** Servicio de pedidos */
	@Autowired
	private OrderManagementI orderService;
	
	/** Servicio Pedido Península */
	@Autowired
	@Qualifier("peninsulaService")
	private OrderManagementI peninsulaService;

	/** Servicio Pedido islas */
	@Autowired
	@Qualifier("islandsService")
	private OrderManagementI islandsService;
	
	/** Servicio de productos */
	@Autowired
	private ProductManagementI productService;
	
	private static final Logger LOG = LoggerFactory.getLogger(NTTDataMain.class);
	
	/**
	 * 
	 * Metodo principal.
	 * @param args
	 */
	public static void main(String[] args){
		SpringApplication.run(NTTDataMain.class, args);
	}

	/**
	 * Metodo para gestionar inserciones y búsquedas en la BBDD.
	 */
	public void run(String... args) throws Exception {	
		
		// Creación de pedidos
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		orderService.createOrder(order1, "Rafael", "Calle Piruleta S/N", true);
		orderService.createOrder(order2, "Maria", "Calle Tortilla 13", false);
		orderService.createOrder(order3, "Marta", "Calle Patata 2", true);

		// Creación de productos y asignación de pedidos.
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();
		Product product5 = new Product();
		Product product6 = new Product();		
		createProduct(product1, "Mistborn book", 14.99, order1);
		createProduct(product2, "God of War Ragnarok PS4", 69.99, order1);
		createProduct(product3, "Kindle Paperwhite", 99.99, order1);
		createProduct(product4, "LG TV 4k", 249.95, order2);
		createProduct(product5, "FireStick TV", 24.95, order2);
		createProduct(product6, "Dog food 10kg", 22.99, order3);
		
		// Asignación de productos a los pedidos.
		orderService.addProductToAnOrder(order1, product1);
		orderService.addProductToAnOrder(order1, product2);
		orderService.addProductToAnOrder(order1, product3);
		orderService.addProductToAnOrder(order2, product4);
		orderService.addProductToAnOrder(order2, product5);
		orderService.addProductToAnOrder(order3, product6);
				
		// Inserción en la BBDD.
		orderService.addOrder(order1);
		orderService.addOrder(order2);
		orderService.addOrder(order3);
		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);
		productService.addProduct(product4);
		productService.addProduct(product5);
		productService.addProduct(product6);
		
		// Búsquedas en la BBDD y asignación a las listas.
		List<Order> peninsulaOrders = orderService.findByPeninsulaShipment(true);
		List<Product> dogFoodProducts = productService.findByProductName("Dog food 10kg");	
		
		// Cálculo de los pedidos.
		LOG.info("Total pedido 1: {}€", orderService.breakdownOrder(order1));
		LOG.info("Total pedido 2: {}€", orderService.breakdownOrder(order2));	
		LOG.info("Total pedido 3: {}€", orderService.breakdownOrder(order3));	
		
		// Resultados de las búsquedas mediante logger.
		LOG.info("Peninsula shipments: ");
		for (int i = 0; i < peninsulaOrders.size(); i++) {
			LOG.info("Order ID: {}", peninsulaOrders.get(i).getOrderId());
		}
		LOG.info("Dog food products: ");
		for (int i = 0; i < dogFoodProducts.size(); i++) {
			LOG.info("Product name: {}", dogFoodProducts.get(i).getProductName());
		}
	}
	
	/**
	 * 
	 * Metodo para creacion de nuevos productos.
	 * @param product
	 * @param name
	 * @param price
	 * @param order
	 */
	public void createProduct(Product product, String name, double price, Order order) {
		product.setProductName(name);
		product.setPrice(price);
		product.setOrder(order);
	}
}