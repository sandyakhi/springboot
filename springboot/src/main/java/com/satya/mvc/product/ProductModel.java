package com.satya.mvc.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel
{
	private String name;
	private String brand;
	private String madeIn;
	private double price;
	private int quantity;
	public double discountRate;
    private double taxPrice;

	
	}
	 
		
	
	
	


