package com.prashanth.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.prashanth.model.Discount;
import com.prashanth.model.product;
import com.prashanth.repo.productRepo;

@Service
public class ProductServiceImp implements ProductService{
 @Autowired
 private productRepo repo;
 @Autowired
 private Discount dis;

@Override
public product saveRecord(product prod) 
{
	double discount=0.0;
	double gst=0.0;
	int deliveryCharges=0;
	double tprice=prod.getProductPrice();
	if(prod.getProductCategory().equals("Electronics"))
	{
		dis.setProductCategory1("Electronics");
        
        	discount=(tprice*15)/100;
        	gst=(tprice*18)/100;
        	deliveryCharges=350;
        
	}
	else if(prod.getProductCategory().equals("Home Appliances"))
	{
		dis.setProductCategory1("Home Appliances");
        
        	discount=(tprice*22)/100;
        	gst=(tprice*24)/100;
        	deliveryCharges=800;
        
	}
	else if(prod.getProductCategory().equals("Clothing"))
	{
		dis.setProductCategory1("Clothing");
        
        	discount=(tprice*40)/100;
        	gst=(tprice*12)/100;
        	deliveryCharges=0;
        
	}
	else if (prod.getProductCategory().equals("Furniture"))
	{
		dis.setProductCategory1("Furniture");
        
        	discount=(tprice*10)/100;
        	gst=(tprice*18)/100;
        	deliveryCharges=300;
        
	}
	
	double finalprice=tprice+gst+deliveryCharges-discount;
	dis.setDiscount(discount);
	dis.setGst(gst);
	dis.setDeliveryCharges(deliveryCharges);
	prod.setDiscount(dis);
	prod.setFinalprice(finalprice);
	product p=repo.save(prod);
	
	return p;
}

@Override
public product getoneRecord(int productId) 
{
product	get=repo.findById(productId).get();
	return get;
}

@Override
public List<product> getAll() 
{
  List<product>	p=repo.findAll();
	return p;
}

@Override
public void deleteRecord(int productId) 
{
	repo.deleteById(productId);
	
}

@Override
public product updateRecord(product prod, int productId) {
    product oldrecord = repo.findById(productId).orElse(null);

    if (oldrecord != null) {
        oldrecord.setProductName(prod.getProductName());
        oldrecord.setProductPrice(prod.getProductPrice());
        oldrecord.setProductType(prod.getProductType());
        oldrecord.setProductCategory(prod.getProductCategory());

        double discount = 0.0;
        double gst = 0.0;
        int deliveryCharges = 0;

        if (prod.getProductCategory().equals("Electronics")) 
        {
            
            dis.setProductCategory1("Electronics");
            discount = (prod.getProductPrice() * 15) / 100;
            gst = (prod.getProductPrice() * 18) / 100;
            deliveryCharges = 350;
        } 
        else if (prod.getProductCategory().equals("Home Appliances"))
        {
            
            dis.setProductCategory1("Home Appliances");
            discount = (prod.getProductPrice() * 22) / 100;
            gst = (prod.getProductPrice() * 24) / 100;
            deliveryCharges = 800;
        }
        else if (prod.getProductCategory().equals("Clothing")) 
        {
            dis = new Discount(); // Initialize the Discount object
            dis.setProductCategory1("Clothing");
            discount = (prod.getProductPrice() * 40) / 100;
            gst = (prod.getProductPrice() * 12) / 100;
            deliveryCharges = 0;
        } 
        else if (prod.getProductCategory().equals("Furniture")) 
        {
           
            dis.setProductCategory1("Furniture");
            discount = (prod.getProductPrice() * 10) / 100;
            gst = (prod.getProductPrice() * 18) / 100;
            deliveryCharges = 300;
        }
        double finalprice=prod.getProductPrice()+gst+deliveryCharges-discount;
        dis.setDiscount(discount);
        dis.setGst(gst);
        dis.setDeliveryCharges(deliveryCharges);
        oldrecord.setDiscount(dis);
        prod.setFinalprice(finalprice);

        product updatedRecord = repo.save(oldrecord);
        return updatedRecord;
    } 
        
        return null;
    
}

}
