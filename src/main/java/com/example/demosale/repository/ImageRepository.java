package com.example.demosale.repository;

import com.example.demosale.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    List<Image> findByProductId(int productId);
    List<Image> findByProductIdOrderByCreatedAtAsc(int productId);


}
