package com.example.demosale.controller;

import com.example.demosale.entity.Product;
import com.example.demosale.repository.IProductRepository;
import com.example.demosale.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = iProductService.addProduct(product);
        return ResponseEntity.ok(createdProduct);
    }
    //Add a new product
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = iProductRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Get product by ID
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = iProductRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
    //Add multiple products
    @PostMapping("/addAll")
    public ResponseEntity<List<Product>> createProducts(@RequestBody List<Product> products) {
        List<Product> savedProducts = iProductRepository.saveAll(products);
        return ResponseEntity.ok(savedProducts);
    }
    //Update a product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        Optional<Product> productOptional = iProductRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setCategories(productDetails.getCategories());
            Product updatedProduct = iProductRepository.save(product);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //  Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        Optional<Product> product = iProductRepository.findById(id);
        if (product.isPresent()) {
            iProductRepository.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
