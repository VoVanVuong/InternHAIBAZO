package com.example.demosale.controller;

import com.example.demosale.entity.Categories;
import com.example.demosale.repository.ICategoriesRepository;
import com.example.demosale.service.ICategoriesService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private ICategoriesService iCategoriesService;
    @Autowired
    private ICategoriesRepository iCategoriesRepository;

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = iCategoriesRepository.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<Categories> addCategories(@RequestBody Categories categories) {
       Categories createcategories= iCategoriesService.addCategories(categories);
        return ResponseEntity.ok(createcategories);
    }
    @PostMapping("/addAll")
    public ResponseEntity<List<Categories>> createCategories(@RequestBody List<Categories> categories) {
        List<Categories> savedCategories = iCategoriesRepository.saveAll(categories);
        return ResponseEntity.ok(savedCategories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable int id) {
        Optional<Categories> category = iCategoriesRepository.findById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable int id, @RequestBody Categories categoryDetails) {
        Optional<Categories> categoryOptional = iCategoriesRepository.findById(id);
        if (categoryOptional.isPresent()) {
          Categories category = categoryOptional.get();
            category.setName(categoryDetails.getName());
         Categories updatedCategory =iCategoriesRepository.save(category);
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        Optional<Categories> category = iCategoriesRepository.findById(id);
        if (category.isPresent()) {
           iCategoriesRepository.delete(category.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

