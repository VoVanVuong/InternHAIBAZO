package com.example.demosale.controller;

import com.example.demosale.entity.Color;
import com.example.demosale.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorController {

    @Autowired
    private IColorService colorService;

    // Get all colors
    @GetMapping
    public List<Color> getAllColors() {
        return colorService.getAllColors();
    }

    // Get color by ID
    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable int id) {
        Color color = colorService.getColorById(id);
        if (color != null) {
            return ResponseEntity.ok(color);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Add a single color
    @PostMapping
    public ResponseEntity<Color> addColor(@RequestBody Color color) {
        Color savedColor = colorService.saveColor(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedColor);
    }

    // Add multiple colors at once
    @PostMapping("/addAll")
    public ResponseEntity<List<Color>> addColors(@RequestBody List<Color> colors) {
        List<Color> savedColors = colorService.saveAllColors(colors);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedColors);
    }

    // Delete color by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable int id) {
        colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}
