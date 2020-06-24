package com.php.java14examples.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.php.java14examples.entity.ProductEntity;
import com.php.java14examples.record.ProductRecord;
import com.php.java14examples.record.ProductRecordDTO;
import com.php.java14examples.repository.ProductRepository;
import com.php.java14examples.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    private ProductServiceImpl productServiceImpl;

    // Tipo temporário
    record Response(@JsonProperty List<ProductEntity> list, @JsonProperty int total){}

    public ProductController(ProductRepository productRepository, ProductServiceImpl productServiceImpl){
      this.productRepository = productRepository;
      this.productServiceImpl = productServiceImpl;
    }

    @GetMapping
    public Response findAll(){
        var listProduct = productRepository.findAll();
        return new Response(listProduct, listProduct.size());
    }

    @GetMapping("{id}")
    public @ResponseBody ProductRecord findById(@PathVariable Long id){
        return productServiceImpl.findById(id);
    }

    @PostMapping
    public ProductEntity create(@RequestBody @Valid ProductRecordDTO productRecordDTO){
        return productRepository.save(productRecordDTO.toEntity());
    }

    @PostMapping("/record")
    public ProductRecord createRecord(@RequestBody @Valid ProductRecordDTO productRecordDTO){
        return productServiceImpl.createProduct(productRecordDTO.name(), productRecordDTO.status());
    }
}
