package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "posts", schema = "chambeape", catalog = "")
public class PostsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "title", nullable = false, length = 40)
    private String title;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "subtitle", nullable = false, length = 30)
    private String subtitle;
    @Basic
    @Column(name = "imgUrl", nullable = false, length = 255)
    private String imgUrl;
    @Basic
    @Column(name = "Employer_id", nullable = false,insertable=false, updatable=false)
    private int employerId;
    @Basic
    @Column(name = "Date_created", nullable = false)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "Date_updated", nullable = true)
    private Timestamp dateUpdated;
    @Basic
    @Column(name = "is_active", nullable = false)
    private byte isActive;
    @OneToMany(mappedBy = "postsByPostsId")
    private Collection<ContractEntity> contractsById;
    @ManyToOne
    @JoinColumn(name = "Employer_id", referencedColumnName = "id", nullable = false)
    private EmployerEntity employerByEmployerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsEntity that = (PostsEntity) o;
        return id == that.id && employerId == that.employerId && isActive == that.isActive && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(subtitle, that.subtitle) && Objects.equals(imgUrl, that.imgUrl) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, subtitle, imgUrl, employerId, dateCreated, dateUpdated, isActive);
    }

    public Collection<ContractEntity> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<ContractEntity> contractsById) {
        this.contractsById = contractsById;
    }

    public EmployerEntity getEmployerByEmployerId() {
        return employerByEmployerId;
    }

    public void setEmployerByEmployerId(EmployerEntity employerByEmployerId) {
        this.employerByEmployerId = employerByEmployerId;
    }
}
