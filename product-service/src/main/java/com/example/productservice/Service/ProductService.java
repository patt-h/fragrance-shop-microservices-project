package com.example.productservice.Service;

import com.example.productservice.Entity.Product;
import com.example.productservice.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        productRepository.save(product);
        log.info("Product added successfully");
        return product;
    }

    public Product updateProduct(Product product) {
        if (product.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            Optional<Product> productToUpdate = productRepository.findById(product.getId());
            if (productToUpdate.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            } else {
                if (product.getName() == null) {
                    product.setName(productToUpdate.get().getName());
                }
                if (product.getDescription() == null) {
                    product.setDescription(productToUpdate.get().getDescription());
                }
                if (product.getBrand() == null) {
                    product.setBrand(productToUpdate.get().getBrand());
                }
                if (product.getType() == null) {
                    product.setType(productToUpdate.get().getType());
                }
                if (product.getImageUrl() == null) {
                    product.setImageUrl(productToUpdate.get().getImageUrl());
                }

                return productRepository.save(product);
            }
        }
    }

    public void deleteProducts(List<Long> id) {
        productRepository.deleteAllById(id);
    }


}
