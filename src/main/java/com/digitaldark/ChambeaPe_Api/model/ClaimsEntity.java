package com.digitaldark.ChambeaPe_Api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "claims", schema = "chambeape", catalog = "")
public class ClaimsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;
    @Basic
    @Column(name = "Message_id", nullable = false,insertable=false, updatable=false)
    private int messageId;
    @Basic
    @Column(name = "Chat_id", nullable = false,insertable=false, updatable=false)
    private int chatId;
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
    @JoinColumn(name = "Message_id", referencedColumnName = "id", nullable = false)
    private MessageEntity messageByMessageId;
    @ManyToOne
    @JoinColumn(name = "Chat_id", referencedColumnName = "id", nullable = false)
    private ChatEntity chatByChatId;
    @OneToMany(mappedBy = "claimsByClaimsId")
    private Collection<EvidencesEntity> evidencesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
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
        ClaimsEntity that = (ClaimsEntity) o;
        return id == that.id && messageId == that.messageId && chatId == that.chatId && isActive == that.isActive && Objects.equals(creationTime, that.creationTime) && Objects.equals(dateCreated, that.dateCreated) && Objects.equals(dateUpdated, that.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationTime, messageId, chatId, dateCreated, dateUpdated, isActive);
    }

    public MessageEntity getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(MessageEntity messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }

    public ChatEntity getChatByChatId() {
        return chatByChatId;
    }

    public void setChatByChatId(ChatEntity chatByChatId) {
        this.chatByChatId = chatByChatId;
    }

    public Collection<EvidencesEntity> getEvidencesById() {
        return evidencesById;
    }

    public void setEvidencesById(Collection<EvidencesEntity> evidencesById) {
        this.evidencesById = evidencesById;
    }
}
