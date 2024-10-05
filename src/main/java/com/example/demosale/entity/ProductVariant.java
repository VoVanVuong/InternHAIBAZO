package com.example.demosale.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "productVariant")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToOne
//    @JoinColumn(name = "size_id")
//    private Size size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;
//    @Column(name = "stock")
//    private int stock;



    @Column(name = "delete_flag")
    private Boolean deleteFlag;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at ", columnDefinition = "Datetime")
    private String createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at ", columnDefinition = "Datetime")
    private String updateAt;
    public ProductVariant() {
    }
    public ProductVariant(int id, Product product, Color color,  Boolean deleteFlag, String createdAt, String updateAt) {
        this.id = id;
        this.product = product;
//        this.size = size;
        this.color = color;
//        this.stock = stock;
        this.deleteFlag = deleteFlag;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
