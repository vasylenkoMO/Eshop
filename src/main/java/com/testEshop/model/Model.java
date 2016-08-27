package com.testEshop.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vastl271nko on 27.08.16.
 */
@MappedSuperclass
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Model() {

    }

    public Model(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
