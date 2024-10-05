package com.example.demosale.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Set;

@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sizeName")
    private String sizeName;
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

    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private Set<ProductSize> variants;

    public Size() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Set<ProductSize> getVariants() {
        return variants;
    }

    public void setVariants(Set<ProductSize> variants) {
        this.variants = variants;
    }

    public Size(int id, String sizeName, Boolean deleteFlag, String createdAt, String updateAt, Set<ProductSize> variants) {
        this.id = id;
        this.sizeName = sizeName;
        this.deleteFlag = deleteFlag;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.variants = variants;
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
}
