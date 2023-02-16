package com.productcatalogue.pc.services;

import com.productcatalogue.pc.models.ProductCatalogue;

import java.util.List;

public interface PCServices {
    ProductCatalogue createProduct(ProductCatalogue pc);
    ProductCatalogue updateProduct(ProductCatalogue pc);
    List<ProductCatalogue> getAllProduct();
    ProductCatalogue getProductbyId(long id);
    void deleteProduct(long id);
}
