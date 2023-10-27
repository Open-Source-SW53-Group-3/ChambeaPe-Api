package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "evidences", schema = "chambeape", catalog = "")
public class EvidencesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "image", nullable = false, length = 250)
    private String image;
    @Basic
    @Column(name = "Claims_id", nullable = false,insertable=false, updatable=false)
    private int claimsId;
    @Basic
    @Column(name = "Date_created", nullable = false)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "Date_updated", nullable = true)
    private Timestamp dateUpdated;
    @Basic
    @Column(name = "is_active", nullable = false)
    private byte isActive;
    @ManyToOne
    @JoinColumn(name = "Claims_id", referencedColumnName = "id", nullable = false)
    private ClaimsEntity claimsByClaimsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getClaimsId() {
        return claimsId;
    }

    public void setClaimsId(int claimsId) {
        this.claimsId = claimsId;
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
        EvidencesEntity that = (EvidencesEntity) o;
        return id == that.id && claimsId == that.claimsId && isActive == that.isActive && Objects.equals(image, that.image) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, claimsId, dateCreated, dateUpdated, isActive);
    }

    public ClaimsEntity getClaimsByClaimsId() {
        return claimsByClaimsId;
    }

    public void setClaimsByClaimsId(ClaimsEntity claimsByClaimsId) {
        this.claimsByClaimsId = claimsByClaimsId;
    }
}
