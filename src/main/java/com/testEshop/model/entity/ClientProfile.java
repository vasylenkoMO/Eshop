package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by vastl271nko on 06.09.16.
 */
@Entity
@Table(name = "client_profile")
public class ClientProfile extends Model {

    @Column(name="TYPE", length=15, unique=true, nullable=false)
    private String type = ClientProfileType.USER.getUserProfileType();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ClientProfile))
            return false;
        ClientProfile other = (ClientProfile) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserProfile [id=" + super.getId() + ", type=" + type + "]";
    }



}
