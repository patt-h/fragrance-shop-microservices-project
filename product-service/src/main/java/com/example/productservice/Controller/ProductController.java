package com.example.productservice.Controller;

import com.example.productservice.Entity.Product;
import com.example.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping("/add")
    public Product addNew(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProducts(@PathVariable List<Long> id) {
        productService.deleteProducts(id);
    }


}
