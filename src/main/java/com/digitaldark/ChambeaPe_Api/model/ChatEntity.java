package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "chambeape", catalog = "")
public class ChatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;
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
    @JoinColumn(name = "Employer_id", referencedColumnName = "id", nullable = false)
    private EmployerEntity employerByEmployerId;
    @ManyToOne
    @JoinColumn(name = "Message_id", referencedColumnName = "id", nullable = false)
    private MessageEntity messageByMessageId;
    @OneToMany(mappedBy = "chatByChatId")
    private Collection<ClaimsEntity> claimsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerId() {
        return workerByWorkerId.getId();
    }

    public void setWorkerId(int workerId) {
        this.workerByWorkerId.setId(workerId);
    }

    public int getEmployerId() {
        return employerByEmployerId.getId();
    }

    public void setEmployerId(int employerId) {
        this.employerByEmployerId.setId(employerId);
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public int getMessageId() {
        return messageByMessageId.getId();
    }

    public void setMessageId(int messageId) {
        this.messageByMessageId.setId(messageId);
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
        ChatEntity that = (ChatEntity) o;
        return id == that.id && workerByWorkerId.getId() == that.workerByWorkerId.getId() && employerByEmployerId.getId() == that.employerByEmployerId.getId() && messageByMessageId.getId() == that.messageByMessageId.getId() && isActive == that.isActive && Objects.equals(creationTime, that.creationTime) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workerByWorkerId.getId(), employerByEmployerId.getId(), creationTime, messageByMessageId.getId(), dateCreated, dateUpdated, isActive);
    }

    public WorkerEntity getWorkerByWorkerId() {
        return workerByWorkerId;
    }

    public void setWorkerByWorkerId(WorkerEntity workerByWorkerId) {
        this.workerByWorkerId = workerByWorkerId;
    }

    public EmployerEntity getEmployerByEmployerId() {
        return employerByEmployerId;
    }

    public void setEmployerByEmployerId(EmployerEntity employerByEmployerId) {
        this.employerByEmployerId = employerByEmployerId;
    }

    public MessageEntity getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(MessageEntity messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }

    public Collection<ClaimsEntity> getClaimsById() {
        return claimsById;
    }

    public void setClaimsById(Collection<ClaimsEntity> claimsById) {
        this.claimsById = claimsById;
    }
}
