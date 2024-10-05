package com.example.demosale.repository;

import com.example.demosale.entity.Image;
import com.example.demosale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByDeleteFlagFalse();


}
