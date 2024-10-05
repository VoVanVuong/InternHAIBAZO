package com.example.demosale.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;
    @Column(name = "delete_flag")
    private Boolean deleteFlag;
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Image> images;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductSize> sizez;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at ", columnDefinition = "Datetime")
    private String createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at ", columnDefinition = "Datetime")
    private String updateAt;

    public Product() {
    }


    public Set<ProductSize> getSizez() {
        return sizez;
    }

    public void setSizez(Set<ProductSize> sizez) {
        this.sizez = sizez;
    }

    public Product(int id, String name, String description, float price, Boolean deleteFlag, Categories categories, Set<Image> images, Set<ProductSize> sizez, String createdAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.deleteFlag = deleteFlag;
        this.categories = categories;
        this.images = images;
        this.sizez = sizez;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Set<Image> getImages() {
        return images;
    }

//    public Set<Size> getSizez() {
////        return sizez;
////    }
////
////    public void setSizez(Set<Size> sizez) {
////        this.sizez = sizez;
////    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
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
}
