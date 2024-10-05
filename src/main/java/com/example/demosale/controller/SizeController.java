package com.example.demosale.controller;

import com.example.demosale.entity.Product;
import com.example.demosale.entity.Size;
import com.example.demosale.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/size")
public class SizeController {
    @Autowired
    private ISizeService iSizeService;
    @PostMapping("/add")
    public ResponseEntity<Size> addSize(@RequestBody Size size) {
       Size createdSize = iSizeService.addSize(size);
        return ResponseEntity.ok(createdSize);
    }
}
