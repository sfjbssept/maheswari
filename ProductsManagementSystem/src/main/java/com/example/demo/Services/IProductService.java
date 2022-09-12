package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;

@Service
public interface IProductService {
	Integer addProduct(Product product);
	
	List<Product> getAllProducts();
	
}
