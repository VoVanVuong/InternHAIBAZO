package com.example.demosale.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demosale.entity.Image;
import com.example.demosale.entity.Product;
import com.example.demosale.repository.IProductRepository;
import com.example.demosale.repository.ImageRepository;
import com.example.demosale.service.IMageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ImageService implements IMageService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Image uploadImage(MultipartFile file, int productId) throws IOException {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        String url = uploadResult.get("url").toString();
        String altText = uploadResult.get("alt_text").toString();

        // Tạo đối tượng Image và lưu vào DB
        Image image = new Image();
        image.setImageUrl(url);
        image.setAltText(altText);
        image.setProduct(product);

        return imageRepository.save(image);  // Lưu thông tin vào database
    }
   @Override
    public List<Image> getImagesByProductId(int productId) {
        return imageRepository.findByProductId(productId);
    }
    @Override
    public Image getFirstImageByProductId(int productId) {
        List<Image> images = imageRepository.findByProductIdOrderByCreatedAtAsc(productId);
        if (images != null && !images.isEmpty()) {
            return images.get(0); // Lấy ảnh đầu tiên
        }
        return null; // Nếu không có ảnh nào
    }
}
