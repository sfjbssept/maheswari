package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.repo.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	IProductRepository productRepository;

	@Override
	public Integer addProduct(Product product) {
		Product addProduct = productRepository.save(product);
		return addProduct.getId();
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProduct(Integer Id) {
		
		return productRepository.findById(Id);
	}

	@Override
	public Product updateProduct(Product product, Integer Id) {
		Product existingProduct = productRepository.findById(Id).orElseThrow(
		() -> new ResourceNotFoundException("Product","id",Id));
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductBrand(product.getProductBrand());
		existingProduct.setProductPrice(product.getProductPrice());
		
		productRepository.save(existingProduct);
		return existingProduct;
		
	}

	@Override
	public void deleteProduct(Integer Id) {
		productRepository.deleteById(Id);
		
	}
	
	
}
