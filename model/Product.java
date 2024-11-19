package model;

public class Product {
	private String description;
	private double price;
	String code;


	public Product(String description,String code ) {
		this.description = description;
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
