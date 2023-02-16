package com.productcatalogue.pc.repository;


import com.productcatalogue.pc.models.ProductCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCRepository extends JpaRepository<ProductCatalogue , Long> {
}
