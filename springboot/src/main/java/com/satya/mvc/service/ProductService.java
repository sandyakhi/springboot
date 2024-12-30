package com.satya.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.mvc.entity.ProductEntity;
import com.satya.mvc.product.ProductModel;
import com.satya.mvc.repository.ProductRepository;
@Service
public class ProductService
{
@Autowired
ProductRepository productRepository;
public void SaveProductdata(ProductModel productModel)
{
	double stockvalue;
	stockvalue=productModel.getPrice()* productModel.getQuantity();
	double discountprice;
	discountprice=(productModel.getPrice()*productModel.getDiscountRate()/100);
	double taxprice;
	taxprice=productModel.getPrice()*0.8;
	double offerprice;
	offerprice=productModel.getPrice()-productModel.getDiscountRate();
	long finalprice;
	finalprice=(long) (productModel.getPrice()*18/100);
	 ProductEntity productEntity=new ProductEntity();

	 
	 productEntity.setName(productModel.getName());
	 productEntity.setBrand(productModel.getBrand());
   	
	 productEntity.setMadeIn(productModel.getMadeIn());
	 productEntity.setPrice(productModel.getPrice());
	 productEntity.setDiscountRate(productModel.getDiscountRate());
	 productEntity.setQuantity(productModel.getQuantity());
	 productEntity.setTaxPrice(taxprice);
	 productEntity.setDiscountPrice(discountprice);
	 productEntity.setFinalPrice(finalprice);
	 productEntity.setOfferPrice(offerprice);
	 productEntity.setStockValue(stockvalue);
	 
	 productRepository.save(productEntity);
       
}
public List<ProductEntity>getAllProducts()
{
	List<ProductEntity>products =productRepository.findAll();
	return products;
}

public ProductEntity searchbyid(Long id)
{
	   Optional<ProductEntity>optionaldata = productRepository.findById(id);
	   if(optionaldata.isPresent())
	   {	
		   ProductEntity product = optionaldata.get();
		   return product;
	   }
	   else 
	   {
		return null;
	}
}
	
	public void deleteProductById(long id) 
	{
		productRepository.deleteById(id);	
		
	}
	public ProductModel editProductById(Long id) 
	
		{
			
	Optional<ProductEntity> optionalProduct = productRepository.findById(id);
	        
	        if (optionalProduct.isPresent())
	        {
	            ProductEntity productEntity = optionalProduct.get();
	            
	            
	            ProductModel productModel = new ProductModel();
	            
	            productModel.setName(productEntity.getName());
	            productModel.setBrand(productEntity.getBrand());
	            productModel.setMadeIn(productEntity.getMadeIn());
	            productModel.setPrice(productEntity.getPrice());
	            productModel.setQuantity(productEntity.getQuantity());
	            productModel.setDiscountRate(productEntity.getDiscountRate());
	            
	            return productModel;
	            
	        }
	        else
	        {
	            
	            return null; 
	        }
			
			
		}
	public void updateproduct(Long id, ProductEntity productmodel)
	{
		Optional<ProductEntity> optionaldata = productRepository.findById(productmodel.getId());
		if(optionaldata.isPresent())
		{
			ProductEntity productEntity=optionaldata.get();
			double stockvalue;
			stockvalue=productmodel.getPrice()* productmodel.getQuantity();
			double discountprice;
			discountprice=(productmodel.getPrice()*productmodel.getDiscountRate()/100);
			double taxprice;
			taxprice=productmodel.getPrice()*0.8;
			double offerprice;
			offerprice=productmodel.getPrice()-productmodel.getDiscountRate();
			long finalprice;
			finalprice=(long) (productmodel.getPrice()*18/100);
			 productEntity.setName(productmodel.getName());
			 productEntity.setBrand(productmodel.getBrand());
		   	
			 productEntity.setMadeIn(productmodel.getMadeIn());
			 productEntity.setPrice(productmodel.getPrice());
			 productEntity.setDiscountRate(productmodel.getDiscountRate());
			 productEntity.setQuantity(productmodel.getQuantity());
			 productEntity.setTaxPrice(taxprice);
			 productEntity.setDiscountPrice(discountprice);
			 productEntity.setFinalPrice(finalprice);
			 productEntity.setOfferPrice(offerprice);
			 productEntity.setStockValue(stockvalue);
			 
			 productRepository.save(productEntity);
			
		}
	}
}
	
		
	










