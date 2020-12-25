package com.megaProject.OnlineFoodOrder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menu_id;
	
	private String item_name;
	private double cook_time;
	private String category;
	private String course;
	private String desrcription;
	private String item_image_path;
	
	public String getItem_image_path() {
		return item_image_path;
	}

	public void setItem_image_path(String item_image_path) {
		this.item_image_path = item_image_path;
	}


	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Menu(String item_name, String category,double cook_time, String course, String desrcription) {
		this.item_name = item_name;
		this.cook_time = cook_time;
		this.category = category;
		this.course = course;
		this.desrcription = desrcription;
	}

	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getCook_time() {
		return cook_time;
	}
	public void setCook_time(int cook_time) {
		this.cook_time = cook_time;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDesrcription() {
		return desrcription;
	}
	public void setDesrcription(String desrcription) {
		this.desrcription = desrcription;
	}
	
	public Menu() {}
}
