package com.example.demosale.service;

import com.example.demosale.entity.Color;

import java.util.List;

public interface IColorService {
    public List<Color> getAllColors();
    public Color getColorById(int id);
    public Color saveColor(Color color);
    public List<Color> saveAllColors(List<Color> colors);
    public void deleteColor(int id);
}
