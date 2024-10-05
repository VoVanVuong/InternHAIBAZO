package com.example.demosale.repository;

import com.example.demosale.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductVariantRepository extends JpaRepository<ProductVariant,Integer> {
}
