package com.megaProject.OnlineFoodOrder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer map_id;

	private Integer menu_id;
	private Integer quantity;
	private String status;
	private double price;
	private double menu_price;

	private Integer order_number;

	public OrderDetails() {

	}

	public OrderDetails(Integer menu_id, Integer quantity, String status, double price, double menu_price,
			Integer order_number) {
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
		this.menu_price = menu_price;
		this.order_number = order_number;
	}

	public double getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(double menu_price) {
		this.menu_price = menu_price;
	}

	public OrderDetails(Integer menu_id, Integer quantity, String status, double price, Integer order_number) {
		super();

		this.menu_id = menu_id;
		this.quantity = quantity;
		this.status = status;
		this.price = price;
		this.order_number = order_number;
	}

	public Integer getMap_id() {
		return map_id;
	}

	public void setMap_id(Integer map_id) {
		this.map_id = map_id;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getOrder_number() {
		return order_number;
	}

	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}

}