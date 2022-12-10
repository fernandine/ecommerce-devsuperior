package com.jean.dsCommerce.controller;

import com.jean.dsCommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping

    @GetMapping("id")

    @PostMapping

    @PutMapping

    @DeleteMapping
}
