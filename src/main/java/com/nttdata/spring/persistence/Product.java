package com.nttdata.spring.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Taller Spring - 2
 * 
 * Tabla Producto.
 * 
 * @author Rafael José
 *
 */

@Entity
@Table(name = "NTTDATA_PRODUCT")
public class Product implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** ID del producto (PK) */
	private Long productId;

	/** Nombre del producto */
	private String productName;

	/** PVP */
	private double erpPrice;

	/** Precio base */
	private double price;

	/** Pedido donde está el producto */
	private Order order;

	/**
	 * @return productId
	 */
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_Sequence")
	@SequenceGenerator(name = "product_id_Sequence", sequenceName = "PRODUCT_ID_SEQ")
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId to be set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return productName
	 */
	@Column(name = "PRODUCT_NAME")
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName to be set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return erpPrice
	 */
	@Column(name = "ERP_PRICE")
	// @Digits(integer = 3, fraction = 2)
	public double getErpPrice() {
		return erpPrice;
	}

	/**
	 * @param erpPrice to be set
	 */
	public void setErpPrice(double erpPrice) {
		this.erpPrice = erpPrice;
	}

	/**
	 * @return price
	 */
	@Column(name = "PRICE")
	// @Digits(integer = 3, fraction = 2)
	public double getPrice() {
		return price;
	}

	/**
	 * @param price to be set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the order
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order to be set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "\nProduct: \n\tProduct Id: " + productId + "\n\tProduct name: " + productName + "\n\tERP price: "
				+ erpPrice + "\n\tPrice:" + price + "\n\tOrder: " + order;
	}
}
