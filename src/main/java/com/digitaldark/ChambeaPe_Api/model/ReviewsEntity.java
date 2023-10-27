package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "chambeape", catalog = "")
public class ReviewsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Employer_id", nullable = false,insertable=false, updatable=false)
    private int employerId;
    @Basic
    @Column(name = "Worker_id", nullable = false,insertable=false, updatable=false)
    private int workerId;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "sent_by_id", nullable = false)
    private int sentById;
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
    @JoinColumn(name = "Employer_id", referencedColumnName = "id", nullable = false)
    private EmployerEntity employerByEmployerId;
    @ManyToOne
    @JoinColumn(name = "Worker_id", referencedColumnName = "id", nullable = false)
    private WorkerEntity workerByWorkerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getSentById() {
        return sentById;
    }

    public void setSentById(int sentById) {
        this.sentById = sentById;
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
        ReviewsEntity that = (ReviewsEntity) o;
        return id == that.id && employerId == that.employerId && workerId == that.workerId && sentById == that.sentById && isActive == that.isActive && Objects.equals(description, that.description) && Objects.equals(date, that.date) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employerId, workerId, description, date, sentById, dateCreated, dateUpdated, isActive);
    }

    public EmployerEntity getEmployerByEmployerId() {
        return employerByEmployerId;
    }

    public void setEmployerByEmployerId(EmployerEntity employerByEmployerId) {
        this.employerByEmployerId = employerByEmployerId;
    }

    public WorkerEntity getWorkerByWorkerId() {
        return workerByWorkerId;
    }

    public void setWorkerByWorkerId(WorkerEntity workerByWorkerId) {
        this.workerByWorkerId = workerByWorkerId;
    }
}
