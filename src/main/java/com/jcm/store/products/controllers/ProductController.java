package com.jcm.store.products.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcm.store.products.dtos.ProductRecordDto;
import com.jcm.store.products.models.ProductModel;
import com.jcm.store.products.repositories.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/products")
	public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductRecordDto productRecordDto){
		var productModel = new ProductModel();
		BeanUtils.copyProperties(productRecordDto, productModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductModel>> getAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
	}
}
