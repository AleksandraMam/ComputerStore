package com.computershop.platform.computershop.controller;

import com.computerstore.platform.computerstore.controller.ProductController;
import com.computerstore.platform.computerstore.entity.Product;
import com.computerstore.platform.computerstore.repository.ProductRepository;
import com.computerstore.platform.computerstore.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        when(productService.saveProduct(any())).thenReturn(product);
        ResponseEntity<Product> responseEntity = productController.addProduct(product);
        assert (responseEntity.getStatusCode() == HttpStatus.CREATED);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        when(productService.updateProduct(any())).thenReturn(product);
        ResponseEntity<?> responseEntity = productController.updateProduct(product);
        assert (responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    void testGetProduct() {
        Product product = new Product();
        product.setId(1L);
        when(productService.getProductById(any())).thenReturn(Optional.of(product));
        ResponseEntity<Product> responseEntity = productController.getProduct(1L);
        assert (responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    void testGetAllProducts() {
        when(productService.getAllProducts()).thenReturn(Arrays.asList(new Product()));
        ResponseEntity<List<Product>> responseEntity = productController.getAllProducts();
        assert (responseEntity.getStatusCode() == HttpStatus.OK);
    }

}