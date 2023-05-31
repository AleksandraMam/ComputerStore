package com.computerstore.platform.computerstore.controller;

import com.computerstore.platform.computerstore.entity.Product;
import com.computershop.platform.computershop.repository.*;
import com.computerstore.platform.computerstore.repository.ProductRepository;
import com.computerstore.platform.computerstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductRepository productRepository;



    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        if (product.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product id cannot be null");
        }

        Optional<Product> _product = productRepository.findById(product.getId());
        if (_product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with id: " + product.getId());
        }

        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.getProductById(id);

        if (productOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
           return new ResponseEntity<>(HttpStatus.OK);
        }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{type}")
    public ResponseEntity<List<? extends Product>> getProductsByType(@PathVariable String type) {
        {
            List<? extends Product> products = productService.getProductsByType(type);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }
}