package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Entity
@Table(name = "sale")
public class Sale extends Model {

    @Column(name = "number")
    private String number;

    @Column(name = "dt_created")
    private Date dateCreated;

    @Column(name = "dt_modified")
    private Date dateModified;

    @Column(name = "sale_sum")
    private Double saleSum;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "status_id", referencedColumnName = "id")
    private Status status;

    @OneToMany(mappedBy = "saleHistory")
    private Set<SaleHistory> saleHistories = new HashSet<SaleHistory>();

    @ManyToMany
    @JoinTable(name = "sale_has_product",
            joinColumns = {@JoinColumn( name = "sale_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn( name = "product_id", referencedColumnName = "id")})
    private Set<Product> products = new HashSet<Product>();

    public Sale() {
    }

    public Sale(int id) {
        super(id);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Double getSaleSum() {
        return saleSum;
    }

    public void setSaleSum(Double orderSum) {
        this.saleSum = saleSum;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<SaleHistory> getSaleHistories() {
        return saleHistories;
    }

    public void setSaleHistories(Set<SaleHistory> saleHistories) {
        this.saleHistories = saleHistories;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
