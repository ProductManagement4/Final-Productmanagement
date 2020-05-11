package com.project.LocationService.Pojo;

import java.sql.Date;
import java.util.List;

public class StorePojo {

	private int id;
	private String name;
	private String location;
	private Date date;
	private List<ProductPojo> allProducts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ProductPojo> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(List<ProductPojo> allProducts) {
		this.allProducts = allProducts;
	}

	public StorePojo(int id, String name, String location, Date date, List<ProductPojo> allProducts) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.date = date;
		this.allProducts = allProducts;
	}

	public StorePojo() {
		super();

	}

	@Override
	public String toString() {
		return "StorePojo [id=" + id + ", name=" + name + ", location=" + location + ", date=" + date + ", allProducts="
				+ allProducts + "]";
	}

}
