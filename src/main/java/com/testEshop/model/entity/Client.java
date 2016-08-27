package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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


    @Size(min = 5, max = 25)
    @NotNull
    @Column(name = "username", length = 25)
    private String username;

    @Column(name = "password")
    private String password;

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
}
