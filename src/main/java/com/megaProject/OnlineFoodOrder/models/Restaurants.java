package com.megaProject.OnlineFoodOrder.models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer restaurant_id;
	
	String restaurant_name;
	double restaurant_latitude;
	double restaurant_longitude;
	String restaurant_city;
	String restaurant_address;
	LocalTime open_time;
	LocalTime close_time;
	Integer avg_delivery_time;
	Integer min_order_cost;
	Integer avg_order_cost;
	String phone_number;
	String payment;
	String menu_image;
	
	
	
	public Restaurants(String restaurant_name, double restaurant_latitude, double restaurant_longitude,
			String restaurant_city, String restaurant_address, LocalTime open_time, LocalTime close_time,
			Integer avg_delivery_time, Integer min_order_cost, Integer avg_order_cost, String phone_number,
			String payment, String restaurant_image,String menu_image) {
		this.restaurant_name = restaurant_name;
		this.restaurant_latitude = restaurant_latitude;
		this.restaurant_longitude = restaurant_longitude;
		this.restaurant_city = restaurant_city;
		this.restaurant_address = restaurant_address;
		this.open_time = open_time;
		this.close_time = close_time;
		this.avg_delivery_time = avg_delivery_time;
		this.min_order_cost = min_order_cost;
		this.avg_order_cost = avg_order_cost;
		this.phone_number = phone_number;
		this.payment = payment;
		this.restaurant_image = restaurant_image;
		this.menu_image=menu_image;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRestaurant_image() {
		return restaurant_image;
	}
	public void setRestaurant_image(String restaurant_image) {
		this.restaurant_image = restaurant_image;
	}

	String restaurant_image;
	
	public Restaurants(String restaurant_name, double restaurant_latitude, double restaurant_longitude,
			String restaurant_city, String restaurant_address, LocalTime open_time, LocalTime close_time,
			Integer avg_delivery_time, Integer min_order_cost, Integer avg_order_cost) {
		this.restaurant_name = restaurant_name;
		this.restaurant_latitude = restaurant_latitude;
		this.restaurant_longitude = restaurant_longitude;
		this.restaurant_city = restaurant_city;
		this.restaurant_address = restaurant_address;
		this.open_time = open_time;
		this.close_time = close_time;
		this.avg_delivery_time = avg_delivery_time;
		this.min_order_cost = min_order_cost;
		this.avg_order_cost = avg_order_cost;
	}
	public Integer getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(Integer restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public double getRestaurant_latitude() {
		return restaurant_latitude;
	}
	public void setRestaurant_latitude(double restaurant_latitude) {
		this.restaurant_latitude = restaurant_latitude;
	}
	public double getRestaurant_longitude() {
		return restaurant_longitude;
	}
	public void setRestaurant_longitude(double restaurant_longitude) {
		this.restaurant_longitude = restaurant_longitude;
	}
	public String getRestaurant_city() {
		return restaurant_city;
	}
	public void setRestaurant_city(String restaurant_city) {
		this.restaurant_city = restaurant_city;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public LocalTime getOpen_time() {
		return open_time;
	}
	public void setOpen_time(LocalTime open_time) {
		this.open_time = open_time;
	}
	public LocalTime getClose_time() {
		return close_time;
	}
	public void setClose_time(LocalTime close_time) {
		this.close_time = close_time;
	}
	public Integer getAvg_delivery_time() {
		return avg_delivery_time;
	}
	public void setAvg_delivery_time(Integer avg_delivery_time) {
		this.avg_delivery_time = avg_delivery_time;
	}
	public Integer getMin_order_cost() {
		return min_order_cost;
	}
	public void setMin_order_cost(Integer min_order_cost) {
		this.min_order_cost = min_order_cost;
	}
	public Integer getAvg_order_cost() {
		return avg_order_cost;
	}
	public void setAvg_order_cost(Integer avg_order_cost) {
		this.avg_order_cost = avg_order_cost;
	}
	
	
	
	public String getMenu_image() {
		return menu_image;
	}
	public void setMenu_image(String menu_image) {
		this.menu_image = menu_image;
	}
	public Restaurants() {}

}