package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Entity
@Table(name = "status")
public class Status extends Model {

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "source")
    private Set<Client> clients = new HashSet<Client>();

    @OneToMany(mappedBy = "status")
    private Set<SaleHistory> saleHistories = new HashSet<SaleHistory>();

    public Status() {
    }

    public Status(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<SaleHistory> getSaleHistories() {
        return saleHistories;
    }

    public void setSaleHistories(Set<SaleHistory> saleHistories) {
        this.saleHistories = saleHistories;
    }
}
