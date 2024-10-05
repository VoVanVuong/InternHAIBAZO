package com.example.demosale.service.impl;

import com.example.demosale.entity.Product;
import com.example.demosale.repository.IProductRepository;
import com.example.demosale.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    @Override
    public List<Product> findByDeleteFlagFalse() {
        return iProductRepository.findByDeleteFlagFalse();
    }
    @Override
    public Product getProductById(int id) {
        // Sử dụng phương thức findById của JpaRepository để lấy công việc theo ID
        Optional<Product> optionalProduct = iProductRepository.findById(id);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {

            return null;
        }
    }
    @Override
    public Product addProduct(Product product) {
        return iProductRepository.save(product);
    }

}
