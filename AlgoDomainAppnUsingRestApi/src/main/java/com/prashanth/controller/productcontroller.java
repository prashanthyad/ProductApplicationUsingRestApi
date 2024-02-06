package com.prashanth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashanth.model.product;
import com.prashanth.service.ProductServiceImp;

@RestController
public class productcontroller {
	@Autowired
	private ProductServiceImp service;
  @PostMapping("/save")
  public String Save(@RequestBody product prod)
  {
	    product p=service.saveRecord(prod);
	  return "Data inserted successfully";
  }
  
  @GetMapping("/getone/{productId}")
  public product getOne(@PathVariable int productId)
  {
	  product p=service.getoneRecord(productId);
	  return p;
  }
  @GetMapping("/getall")
  public List<product> getAll()
  {
	 List<product> getall=service.getAll();
	 return getall;
  }
  @DeleteMapping("/delete/{productId}")
  public String deleteRec(@PathVariable int  productId)
  {
	  service.deleteRecord(productId);
	  return "Data Deleted successfully";
	  
  }
  @PostMapping("/update/{productId}")
  public product updateRecord(@RequestBody product prod, @PathVariable int productId)
  {
	  product update=service.updateRecord(prod, productId);
	  return update;
  }
	  
  
}
