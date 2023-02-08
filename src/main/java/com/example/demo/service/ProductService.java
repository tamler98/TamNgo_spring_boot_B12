package com.example.demo.service;


import com.example.demo.entities.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }
    public Page<ProductEntity> getProductsByName(String searchInput, Pageable pageable) {return productRepository.getByNameContaining(searchInput,pageable);}
//    public List<ProductEntity> getProductsByName(String searchInput) {return productRepository.getByNameContaining(searchInput);}
}
