package com.store.cyber.cyberSuplementosback.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;


@Entity(name = "tb_sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Vendor vendor;

    @OneToMany
    private List<Product> product;

    @Column(scale = 13,precision = 2)
    private BigDecimal discount;

    @Column(scale = 13,precision = 2)
    private BigDecimal total;

    @Column(scale = 13,precision = 2)
    private BigDecimal tax;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vendor getSalesPerson() {
        return vendor;
    }

    public void setSalesPerson(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
