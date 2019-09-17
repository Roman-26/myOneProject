package com.roma.mainproject.controller;

import com.roma.mainproject.dto.ProductDTO;
import com.roma.mainproject.exception.StorageFileNotFoundException;
import com.roma.mainproject.model.Product;
import com.roma.mainproject.repository.ProductRepository;
import com.roma.mainproject.service.ProductService;
import com.roma.mainproject.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorageService storageService;
    

    @GetMapping("/profile/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment: filename=\""+file.getFilename()+"\"").body(file);

    }

    @PostMapping("/upload/{id}")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                  RedirectAttributes redirectAttributes , @PathVariable Long id) throws IOException {

        Product product = productService.findById(id).get();
        product.setProductPicture("http://localhost/profile/"+storageService.store(file).getFileName());
        productRepository.save(product);
        redirectAttributes.addFlashAttribute("message",
                "Your file "+file.getOriginalFilename()+" successfully uploaded!");
        return "redirect:/profile";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException e){
        return ResponseEntity.notFound().build();
    }

}
