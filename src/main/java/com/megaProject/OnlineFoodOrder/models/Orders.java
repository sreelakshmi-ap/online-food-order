package com.megaProject.OnlineFoodOrder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

@Id
private Integer order_number;

private Integer user_id;
private Integer restaurant_id;
private double amount;

public Orders(Integer order_number, Integer user_id, Integer restaurant_id, double amount) {
super();
this.order_number = order_number;
this.user_id = user_id;
this.restaurant_id = restaurant_id;
this.amount = amount;
}

public Orders() {

}

public Integer getOrder_number() {
return order_number;
}

public void setOrder_number(Integer order_number) {
this.order_number = order_number;
}

public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}

public Integer getRestaurant_id() {
return restaurant_id;
}

public void setRestaurant_id(Integer restaurant_id) {
this.restaurant_id = restaurant_id;
}

public double getAmount() {
return amount;
}

public void setAmount(double amount) {
this.amount = amount;
}

}