package com.ciclo4.reto3.controller;

import com.ciclo4.reto3.model.Product;
import com.ciclo4.reto3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public List<Product> getAllProducts() {
    return productService.getAll();
  }

  @GetMapping("{id}")
  public Optional<Product> getProduct(@PathVariable("id") int id) {
    return productService.getProduct(id);
  }

  @PostMapping("/new")
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@RequestBody Product product) {
    return productService.create(product);
  }

  @PutMapping("/update")
  @ResponseStatus(HttpStatus.CREATED)
  public Product update(@RequestBody Product product) {
    return productService.update(product);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public boolean delete(@PathVariable("id") int id) {
    return productService.delete(id);
  }

}
