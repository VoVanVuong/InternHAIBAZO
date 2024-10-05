package com.example.demosale.service.impl;

import com.example.demosale.entity.Categories;
import com.example.demosale.repository.ICategoriesRepository;
import com.example.demosale.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService implements ICategoriesService {
    @Autowired
    private ICategoriesRepository iCategoriesRepository;
    @Override
    public Categories addCategories(Categories categories) {
        return iCategoriesRepository.save(categories);
    }
}
