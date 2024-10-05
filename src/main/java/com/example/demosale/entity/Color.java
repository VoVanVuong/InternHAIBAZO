package com.example.demosale.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Set;

@Entity
@Table(name = "color")
public class Color {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long colorId;
        @Column(name = "colorName")
        private String colorName;

        @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
        private Set<ProductVariant> variants;
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

        // Getters and Setters


    public Color(Long colorId, String colorName, Set<ProductVariant> variants, Boolean deleteFlag, String createdAt, String updateAt) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.variants = variants;
        this.deleteFlag = deleteFlag;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Color() {
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

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Set<ProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(Set<ProductVariant> variants) {
        this.variants = variants;
    }
}
