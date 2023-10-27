package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "chambeape", catalog = "")
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "time", nullable = false)
    private Timestamp time;
    @Basic
    @Column(name = "content", nullable = false, length = 255)
    private String content;
    @Basic
    @Column(name = "send_by_id", nullable = false)
    private int sendById;
    @Basic
    @Column(name = "Date_created", nullable = false)
    private Timestamp dateCreated;
    @Basic
    @Column(name = "Date_updated", nullable = true)
    private Timestamp dateUpdated;
    @Basic
    @Column(name = "is_active", nullable = false)
    private byte isActive;
    @OneToMany(mappedBy = "messageByMessageId")
    private Collection<ChatEntity> chatsById;
    @OneToMany(mappedBy = "messageByMessageId")
    private Collection<ClaimsEntity> claimsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSendById() {
        return sendById;
    }

    public void setSendById(int sendById) {
        this.sendById = sendById;
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
        MessageEntity that = (MessageEntity) o;
        return id == that.id && sendById == that.sendById && isActive == that.isActive && Objects.equals(time, that.time) && Objects.equals(content, that.content) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, content, sendById, dateCreated, dateUpdated, isActive);
    }

    public Collection<ChatEntity> getChatsById() {
        return chatsById;
    }

    public void setChatsById(Collection<ChatEntity> chatsById) {
        this.chatsById = chatsById;
    }

    public Collection<ClaimsEntity> getClaimsById() {
        return claimsById;
    }

    public void setClaimsById(Collection<ClaimsEntity> claimsById) {
        this.claimsById = claimsById;
    }
}
