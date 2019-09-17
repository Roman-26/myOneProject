package com.roma.mainproject.controller;


import com.roma.mainproject.exception.UserNotFoundException;
import com.roma.mainproject.model.Product;
import com.roma.mainproject.model.User;
import com.roma.mainproject.service.ProductService;
import com.roma.mainproject.service.StorageService;
import com.roma.mainproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
