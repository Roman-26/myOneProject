package com.roma.mainproject.controller;

import com.roma.mainproject.dto.ProductDTO;
import com.roma.mainproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("product",new ProductDTO());
        return "product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute(name = "product") ProductDTO product){
        productService.saveNewProduct(product);
        return "redirect:/product";
    }
}
