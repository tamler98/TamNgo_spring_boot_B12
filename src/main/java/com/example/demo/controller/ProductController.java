package com.example.demo.controller;


import com.example.demo.entities.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value={"/", "/products"})
    public String listAll(Model model) {
        List<ProductEntity> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "product";
    }

}