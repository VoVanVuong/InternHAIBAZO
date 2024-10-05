package com.example.demosale.service.impl;

import com.example.demosale.entity.Color;
import com.example.demosale.repository.IColorRepository;
import com.example.demosale.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    private IColorRepository colorRepository;

    // Retrieve all colors
    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    // Retrieve a color by its ID
    @Override
    public Color getColorById(int id) {
        return colorRepository.findById(id).orElse(null);
    }

    // Save a single color
    @Override
    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    // Save multiple colors at once
    @Override
    public List<Color> saveAllColors(List<Color> colors) {
        return colorRepository.saveAll(colors);
    }

    // Delete a color by its ID
    @Override
    public void deleteColor(int id) {
        colorRepository.deleteById(id);
    }
}
