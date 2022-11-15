package com.excercise.controller;

import com.excercise.model.Product;
import com.excercise.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public ResponseEntity<Object> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public @ResponseBody
    ResponseEntity<Object> sendNewProduct(@RequestBody @Valid Product product){
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        try {
            if (productService.existProductById(id)) {
                productService.delete(id);
                return new ResponseEntity<>("Product successfully deleted", HttpStatus.OK);
            }
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println("Failed to delete Product");
        }
        return new ResponseEntity<>("Failed to cancel the Product!", HttpStatus.NOT_FOUND);
    }


}
