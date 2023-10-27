package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "contract", schema = "chambeape", catalog = "")
public class ContractEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "Worker_id", nullable = false,insertable=false, updatable=false)
    private int workerId;
    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @Basic
    @Column(name = "start_day", nullable = false)
    private Timestamp startDay;
    @Basic
    @Column(name = "end_day", nullable = false)
    private Timestamp endDay;
    @Basic
    @Column(name = "salary", nullable = false, precision = 2)
    private BigDecimal salary;
    @Basic
    @Column(name = "Posts_id", nullable = false,insertable=false, updatable=false)
    private int postsId;
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
    @JoinColumn(name = "Worker_id", referencedColumnName = "id", nullable = false)
    private WorkerEntity workerByWorkerId;
    @ManyToOne
    @JoinColumn(name = "Posts_id", referencedColumnName = "id", nullable = false)
    private PostsEntity postsByPostsId;
    @OneToMany(mappedBy = "contractByContractId")
    private Collection<ServiceEntity> servicesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getStartDay() {
        return startDay;
    }

    public void setStartDay(Timestamp startDay) {
        this.startDay = startDay;
    }

    public Timestamp getEndDay() {
        return endDay;
    }

    public void setEndDay(Timestamp endDay) {
        this.endDay = endDay;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
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
        ContractEntity that = (ContractEntity) o;
        return id == that.id && workerId == that.workerId && postsId == that.postsId && isActive == that.isActive && Objects.equals(content, that.content) && Objects.equals(startDay, that.startDay) && Objects.equals(endDay, that.endDay) && Objects.equals(salary, that.salary) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workerId, content, startDay, endDay, salary, postsId, dateCreated, dateUpdated, isActive);
    }

    public WorkerEntity getWorkerByWorkerId() {
        return workerByWorkerId;
    }

    public void setWorkerByWorkerId(WorkerEntity workerByWorkerId) {
        this.workerByWorkerId = workerByWorkerId;
    }

    public PostsEntity getPostsByPostsId() {
        return postsByPostsId;
    }

    public void setPostsByPostsId(PostsEntity postsByPostsId) {
        this.postsByPostsId = postsByPostsId;
    }

    public Collection<ServiceEntity> getServicesById() {
        return servicesById;
    }

    public void setServicesById(Collection<ServiceEntity> servicesById) {
        this.servicesById = servicesById;
    }
}
