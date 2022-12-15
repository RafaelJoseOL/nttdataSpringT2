package com.nttdata.spring.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Taller Spring - 2
 * 
 * Tabla Pedido.
 * 
 * @author Rafael José
 *
 */

@Entity
@Table(name = "NTTDATA_ORDER")
public class Order implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** ID del pedido (PK) */
	private Long orderId;

	/** Nombre del destinatario */
	private String addresseeName;

	/** Direccion de entrega */
	private String deliveryAddress;

	/** Entrega en península o en islas */
	private boolean peninsulaShipment;

	/** Lista de productos del pedido */
	private List<Product> productsList = new ArrayList<>();

	/**
	 * @return orderId
	 */
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_Sequence")
	@SequenceGenerator(name = "order_id_Sequence", sequenceName = "ORDER_ID_SEQ")
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId to be set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return addresseeName
	 */
	@Column(name = "ADDRESSEE")
	public String getAddresseeName() {
		return addresseeName;
	}

	/**
	 * @param addresseeName to be set
	 */
	public void setAddresseeName(String addresseeName) {
		this.addresseeName = addresseeName;
	}

	/**
	 * @return deliveryAddress
	 */
	@Column(name = "DELIVERY_ADDRESS")
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress to be set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return peninsulaShipment
	 */
	@Column(name = "PENINSULA_SHIPMENT")
	public boolean getPeninsulaShipment() {
		return peninsulaShipment;
	}

	/**
	 * @param peninsulaShipment to be set
	 */
	public void setPeninsulaShipment(boolean peninsulaShipment) {
		this.peninsulaShipment = peninsulaShipment;
	}

	/**
	 * @return productsList
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	@Column(name = "PRODUCTS_LIST")
	public List<Product> getProductsList() {
		return productsList;
	}

	/**
	 * @param productsList to be set
	 */
	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nOrder: \n\tOrder Id: " + orderId + "\n\tAddressee name: " + addresseeName + "\n\tDelivery address: "
				+ deliveryAddress + "\n\tPeninsula shipment:" + peninsulaShipment + "\n\tProducts list:");
		for (int i = 0; i < productsList.size(); i++) {
			sb.append("\n\t\t" + productsList.get(i).getProductName());
		}
		return sb.toString();
	}
}
