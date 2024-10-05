package com.example.demosale.service;

import com.example.demosale.entity.Image;
import com.example.demosale.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IMageService {
    public Image uploadImage(MultipartFile file, int productId) throws IOException;
    public List<Image> getImagesByProductId(int productId);
    public Image getFirstImageByProductId(int productId);
}
