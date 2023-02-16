package com.productcatalogue.pc.controller;

import com.productcatalogue.pc.models.ProductCatalogue;
import com.productcatalogue.pc.services.PCServices;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PCController {
    @Autowired
    private PCServices productServices;

    @GetMapping("/product")
    private ResponseEntity<List<ProductCatalogue>> getAllProduct(){
        return ResponseEntity.ok().body(this.productServices.getAllProduct());
    }

    @GetMapping("/product/{product_id}")
    private ProductCatalogue getProductById(@PathVariable long product_id){
        return this.productServices.getProductbyId(product_id);
    }

    @PostMapping("/products")
    private ResponseEntity<ProductCatalogue> saveProduct(@RequestBody ProductCatalogue pc){
        return ResponseEntity.ok().body(this.productServices.createProduct(pc));
    }

    @PutMapping("/updateProduct/{product_id}")
    private ResponseEntity<ProductCatalogue> updateProduct(@PathVariable long product_id,@RequestBody ProductCatalogue pc){
        pc.setProduct_id(product_id);
        return ResponseEntity.ok().body(this.productServices.updateProduct(pc));
    }

    @DeleteMapping("/deleteProduct/{product_id}")
    private HttpStatus deleteProduct(@PathVariable long product_id) {
        this.productServices.deleteProduct(product_id);
        return HttpStatus.OK;
    }
}
