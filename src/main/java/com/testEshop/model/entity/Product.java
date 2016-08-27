package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Entity
@Table(name = "product")
public class Product extends Model {
    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "count")
    private int count;

    @ManyToMany(mappedBy = "products")
    private Set<Sale> sales = new HashSet<Sale>();

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories = new HashSet<Category>();

    public Product() {
    }

    public Product(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {

        /*String ctgrs  = "";
        for(Category category: categories) {
            ctgrs += category.getName();
        }*/
        return super.getId() + " - " + name + " - price: " + price;
    }
}
