package com.computershop.platform.computershop.service;

import com.computerstore.platform.computerstore.entity.*;
import com.computerstore.platform.computerstore.repository.*;
import com.computerstore.platform.computerstore.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Mock
    DesktopRepository desktopRepository;

    @Mock
    LaptopRepository laptopRepository;

    @Mock
    MonitorRepository monitorRepository;

    @Mock
    HardDriveRepository hardDriveRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(new Product()));
        List<Product> products = productService.getAllProducts();
        assert(!products.isEmpty());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        Optional<Product> retrievedProduct = productService.getProductById(1L);
        assert(retrievedProduct.isPresent());
    }

    @Test
    void testSaveProduct() {
        Product product = new Product();
        when(productRepository.save(any())).thenReturn(product);
        Product savedProduct = productService.saveProduct(product);
        assert(savedProduct != null);
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setManufacturer("Test Manufacturer");
        product.setPrice(999.99);
        product.setSerialNumber("123456789");
        product.setQuantity(5);
        when(productRepository.save(any())).thenReturn(product);
        Product updatedProduct = productService.updateProduct(product);
        assert(updatedProduct != null);
        assert(updatedProduct.getManufacturer().equals("Test Manufacturer"));
        assert(updatedProduct.getPrice() == 999.99);
        assert(updatedProduct.getSerialNumber().equals("123456789"));
        assert(updatedProduct.getQuantity() == 5);
    }

    @Test
    void getProductsByTypeDesktopTest() {
        when(desktopRepository.findAll()).thenReturn(Arrays.asList(new Desktop(), new Desktop()));

        assertEquals(2, productService.getProductsByType("DESKTOP").size());
        verify(desktopRepository, times(1)).findAll();
    }

    @Test
    void getProductsByTypeLaptopTest() {
        when(laptopRepository.findAll()).thenReturn(Arrays.asList(new Laptop(), new Laptop()));

        assertEquals(2, productService.getProductsByType("LAPTOP").size());
        verify(laptopRepository, times(1)).findAll();
    }

    @Test
    void getProductsByTypeMonitorTest() {
        when(monitorRepository.findAll()).thenReturn(Arrays.asList(new Monitor(), new Monitor()));

        assertEquals(2, productService.getProductsByType("MONITOR").size());
        verify(monitorRepository, times(1)).findAll();
    }

    @Test
    void getProductsByTypeHardDriveTest() {
        when(hardDriveRepository.findAll()).thenReturn(Arrays.asList(new HardDrive(), new HardDrive()));

        assertEquals(2, productService.getProductsByType("HARD_DRIVE").size());
        verify(hardDriveRepository, times(1)).findAll();
    }

    @Test
    void getProductsByTypeInvalidTest() {
        assertThrows(IllegalArgumentException.class, () -> productService.getProductsByType("INVALID_TYPE"));
    }

}