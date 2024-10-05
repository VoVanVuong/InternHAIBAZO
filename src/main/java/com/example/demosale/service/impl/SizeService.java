package com.example.demosale.service.impl;

import com.example.demosale.entity.Size;
import com.example.demosale.repository.ISizeRepository;
import com.example.demosale.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepository iSizeRepository;
    @Override
    public Size addSize(Size size) {
        return iSizeRepository.save(size);
    }
}
