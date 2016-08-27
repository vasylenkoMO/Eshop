package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Entity
@Table(name = "category")
public class Category extends Model {

    @Column(name = "name", length = 50)
    private String name;

    @ManyToMany
    @JoinTable(name = "category_has_product",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private Set<Product> products = new HashSet<Product>();

    public Category() {
    }

    public Category(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


}
