package com.example.demo.controller;


import com.example.demo.entities.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/search")
    public String showProducts(Model model, @RequestParam(name="searchInput") String searchInput, @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> productList = (Page<ProductEntity>) productService.getProductsByName(searchInput, pageable);
        model.addAttribute("productList", productList);
        model.addAttribute("searchInput", searchInput);
        return "productList";
    }

}