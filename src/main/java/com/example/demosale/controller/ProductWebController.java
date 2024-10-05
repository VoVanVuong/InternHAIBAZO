package com.example.demosale.controller;

import com.example.demosale.entity.Image;
import com.example.demosale.entity.Product;
import com.example.demosale.repository.IProductRepository;
import com.example.demosale.service.IMageService;
import com.example.demosale.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductWebController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private IMageService iMageService;
    @Autowired
    public ProductWebController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("/homes")
    public String product(Model model){
        List<Product> productList=iProductService.findByDeleteFlagFalse();
        model.addAttribute("productList",productList);
        return "products";
    }
    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id")int id, Model model){
        Product product=iProductService.getProductById(id);
        model.addAttribute("product",product);

        List<Image> images = iMageService.getImagesByProductId(id);
        model.addAttribute("images", images);

        Image firstImage = iMageService.getFirstImageByProductId(id);
        model.addAttribute("firstImage", firstImage);

        return "detailproducts";
    }

}
