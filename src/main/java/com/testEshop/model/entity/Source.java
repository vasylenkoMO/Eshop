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
@Table(name = "source")
public class Source extends Model {

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "source")
    private Set<Client> clients = new HashSet<Client>();

    public Source() {
    }

    public Source(int id) {
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
}
