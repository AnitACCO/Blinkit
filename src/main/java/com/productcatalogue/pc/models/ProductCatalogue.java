package com.productcatalogue.pc.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class ProductCatalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price")
    private long price;

    @Column(name = "product_category")
    private String product_category;


    @CreationTimestamp
    private Date createdTime;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }
}

