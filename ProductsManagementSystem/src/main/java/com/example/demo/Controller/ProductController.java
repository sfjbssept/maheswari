package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Services.IProductService;

@RestController
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@PostMapping("/addproduct")
	Integer addProduct(@RequestBody Product product) {
		Integer id=productService.addProduct(product);
		System.out.println(id);
		return id;	
	}
	@GetMapping("/allproducts")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
		
	}
}
