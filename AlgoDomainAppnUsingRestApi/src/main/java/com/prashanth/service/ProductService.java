package com.prashanth.service;

import java.util.List;

import com.prashanth.model.product;

public interface ProductService {

	public product saveRecord(product prod);
	public product getoneRecord(int productId);
	public List<product>getAll();
	public void deleteRecord(int productId);
	public product updateRecord(product prod,int productId);
	
	
}
