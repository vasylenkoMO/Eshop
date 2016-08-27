package com.testEshop.model.entity;

import com.testEshop.model.Model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vastl271nko on 27.08.16.
 */
@Entity
@Table(name = "sale_history")
public class SaleHistory extends Model {

    @Column(name = "sale_sum")
    private double saleSum;

    @Column(name = "active_from")
    private Date activeFrom;

    @Column(name = "active_to")
    private Date activeTo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "sale_id")
    private Sale saleHistory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "status_id", referencedColumnName = "id")
    private Status status;

    public SaleHistory() {
    }

    public SaleHistory(int id) {
        super(id);
    }

    public double getSaleSum() {
        return saleSum;
    }

    public void setSaleSum(double saleSum) {
        this.saleSum = saleSum;
    }

    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    public Date getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(Date activeTo) {
        this.activeTo = activeTo;
    }

    public Sale getSaleHistory() {
        return saleHistory;
    }

    public void setSaleHistory(Sale saleHistory) {
        this.saleHistory = saleHistory;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
