package com.roma.mainproject.controller;

import com.roma.mainproject.dto.ProductDTO;
import com.roma.mainproject.exception.UserNotFoundException;
import com.roma.mainproject.model.Product;
import com.roma.mainproject.model.User;
import com.roma.mainproject.service.ProductService;
import com.roma.mainproject.service.StorageService;
import com.roma.mainproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("product",new ProductDTO());
        return "product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute(name = "product") ProductDTO product,Principal principal){
        product.setUser(userService.findOne(principal.getName()).orElseThrow(UserNotFoundException::new));
        productService.saveNewProduct(product);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        User user = userService.findOne(principal.getName()).orElseThrow(UserNotFoundException::new);
        List<Product> products = productService.findAll(user);
        model.addAttribute("productList",products);
        model.addAttribute("username",principal.getName());
        model.addAttribute("files", storageService.loadAll()
                .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile",path.getFileName().toString()).build().toString()).collect(Collectors.toList()));
        return "profile";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id")Long id){
        productService.delete(id);
        return "redirect:/profile";
    }
}
