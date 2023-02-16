package com.productcatalogue.pc.services;

import com.productcatalogue.pc.exception.PCException;
import com.productcatalogue.pc.models.ProductCatalogue;
import com.productcatalogue.pc.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PCServicesImp  implements PCServices{

    @Autowired
    private PCRepository productRepository;

    @Override
    public ProductCatalogue createProduct(ProductCatalogue pc) {
        return productRepository.save(pc);
    }

    @Override
    public ProductCatalogue updateProduct(ProductCatalogue pc) {
        Optional<ProductCatalogue> pcObj = this.productRepository.findById(pc.getProduct_id());
        if(pcObj.isPresent()){
            ProductCatalogue pcUpdate = pcObj.get();
            pcUpdate.setProduct_id(pc.getProduct_id());
            pcUpdate.setProduct_name(pc.getProduct_name());
            pcUpdate.setPrice(pc.getPrice());
            pcUpdate.setProduct_category(pc.getProduct_category());
            return this.productRepository.save(pcUpdate);
        }else {
            throw new PCException("No product found with + " + pc.getProduct_id());
        }

    }

    @Override
    public List<ProductCatalogue> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductCatalogue getProductbyId(long id) {
        Optional<ProductCatalogue> pcObj = this.productRepository.findById(id);
        if(pcObj.isPresent()){
            return pcObj.get();
        }
        else {
            throw new PCException("No Product found with id " + id);
        }
    }

    @Override
    public void deleteProduct(long id) {
        Optional<ProductCatalogue> pcObj = this.productRepository.findById(id);
        if(pcObj.isPresent()){
            productRepository.delete(getProductbyId(id));
        }
        else {
            throw new PCException("No Product found with id " + id);
        }
    }
}
