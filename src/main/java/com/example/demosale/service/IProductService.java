package com.example.demosale.service;

import com.example.demosale.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findByDeleteFlagFalse();
    public Product getProductById(int id);
    public Product addProduct(Product product);
}
