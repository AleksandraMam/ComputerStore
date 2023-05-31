package com.computerstore.platform.computerstore.service;

import com.computerstore.platform.computerstore.entity.Product;
import com.computerstore.platform.computerstore.enums.ProductType;
import com.computershop.platform.computershop.repository.*;
import com.computershop.platform.computerstore.repository.*;
import com.computerstore.platform.computerstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DesktopRepository desktopRepository;
    private final LaptopRepository laptopRepository;
    private final MonitorRepository monitorRepository;
    private final HardDriveRepository hardDriveRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, DesktopRepository desktopRepository, LaptopRepository laptopRepository,
                          MonitorRepository monitorRepository, HardDriveRepository hardDriveRepository) {
        this.productRepository = productRepository;
        this.desktopRepository = desktopRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.hardDriveRepository = hardDriveRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product existingProduct) {
        existingProduct.setManufacturer(existingProduct.getManufacturer());
        existingProduct.setPrice(existingProduct.getPrice());
        existingProduct.setSerialNumber(existingProduct.getSerialNumber());
        existingProduct.setQuantity(existingProduct.getQuantity());
        return productRepository.save(existingProduct);
    }

    public List<? extends Product> getProductsByType(String type) {
        ProductType productType = ProductType.fromString(type);

        if (productType == null) {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }

        switch (productType) {
            case DESKTOP:
                return desktopRepository.findAll();
            case LAPTOP:
                return laptopRepository.findAll();
            case MONITOR:
                return monitorRepository.findAll();
            case HARD_DRIVE:
                return hardDriveRepository.findAll();
            default:
                throw new IllegalArgumentException("Invalid product type: " + type);
        }

    }

}
