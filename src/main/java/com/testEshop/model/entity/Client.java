package com.testEshop.model.entity;

import com.testEshop.model.Model;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Entity
@Table(name = "client")
public class Client extends Model {
    @Column(name = "code")
    private String code;

    @Size(min = 3, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 3, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotEmpty
    private String email;

    @Size(min = 5, max = 25)
    @NotNull
    @Column(name = "username", length = 25)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "source_id", referencedColumnName = "id")
    private Source source;

    @OneToMany(mappedBy = "client")
    private Set<Sale> sales = new HashSet<Sale>();

    public Client() {
    }

    public Client(int id) {
        super(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Source getSource() {
        return source;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
