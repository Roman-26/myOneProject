package com.roma.mainproject.controller;

import com.roma.mainproject.dto.UserDTO;
import com.roma.mainproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(name = "error", defaultValue = "false") String hasError,
                        Model model){
        if(Boolean.valueOf(hasError)){
            model.addAttribute("error", "Invalid username or password");
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserDTO(@ModelAttribute(name = "user") @Valid UserDTO user, BindingResult result,
                                  WebRequest webRequest, Errors errors,Model model){
        if (result.hasErrors()){
            model.addAttribute("user",user);
            return "/register";
        }
        userService.registerNewUserDTO(user);
        return "redirect:/profile";
    }
}
