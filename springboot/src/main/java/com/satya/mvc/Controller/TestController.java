package com.satya.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.satya.mvc.entity.ProductEntity;
import com.satya.mvc.product.ProductModel;
import com.satya.mvc.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class TestController
{	
 @Autowired
	ProductService productService;
 @GetMapping("/productform")
 public String getproductform(ProductModel model) 
 {
    
     return "add-product";
 }
	@PostMapping("/saveproduct")
	public String SaveProductdata(ProductModel productModel) 
	{  
		productService.SaveProductdata(productModel);
    return "success";
	}

@GetMapping("/getallproducts")
public String getAllProducts(Model model) 
{
	List<ProductEntity>products=productService.getAllProducts();
	model.addAttribute("products", products);
    return "product-list";
}
@GetMapping("/getserchform")
public String idserch()
{
    return "search-form";
}
@PostMapping("/searchbyid")
public String searchbyid(@RequestParam Long id, Model model)
{
	ProductEntity product= productService.searchbyid(id);
	model.addAttribute("product", product);
	return "search-form";
}
@GetMapping("/delete/{id}")
public String deleteProductByid(@PathVariable ("id") long id) 
{ 
	productService.deleteProductById(id);
    return "redirect:/getallproducts";
}
@GetMapping("/edit/{id}")
public String editProductById(@PathVariable("id") Long id,Model model) 
{
	ProductModel productModel=productService.editProductById(id);
	model.addAttribute("product",productModel);
	model.addAttribute("id",id);
    return "edit";
}
@PostMapping("/editproductsave/{id}")
public String updateproduct(@PathVariable("id") Long id,@ModelAttribute ProductEntity productmodel)
{
	productService.updateproduct(id,productmodel);
    
    
    return "redirect:/getallproducts";
}





}
