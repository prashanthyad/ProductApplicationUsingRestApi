package com.prashanth.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class product {
  @Id
  private int productId;
  private String productName;
  private String productType;
  private String productCategory;
  private double productPrice;
  
   @Embedded
   private Discount discount;
   @Column(nullable = true)
   private double finalprice;

public product() {
	super();
}

public product(int productId, String productName, String productType, String productCategory, double productPrice,
		Discount discount,double finalprice) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productType = productType;
	this.productCategory = productCategory;
	this.productPrice = productPrice;
	this.discount = discount;
	this.finalprice=finalprice;
}

public double getFinalprice() {
	return finalprice;
}

public void setFinalprice(double finalprice) {
	this.finalprice = finalprice;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductType() {
	return productType;
}

public void setProductType(String productType) {
	this.productType = productType;
}

public String getProductCategory() {
	return productCategory;
}

public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}

public double getProductPrice() {
	return productPrice;
}

public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}

public Discount getDiscount() {
	return discount;
}

public void setDiscount(Discount discount) {
	this.discount = discount;
}

@Override
public String toString() {
	return "product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
			+ ", productCategory=" + productCategory + ", productPrice=" + productPrice + ", discount=" + discount
			+ ", finalprice=" + finalprice + "]";
}


   
}
