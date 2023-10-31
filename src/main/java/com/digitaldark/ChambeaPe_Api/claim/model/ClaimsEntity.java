package com.digitaldark.ChambeaPe_Api.claim.model;

import com.digitaldark.ChambeaPe_Api.chat.model.ChatEntity;
import com.digitaldark.ChambeaPe_Api.chat.model.MessageEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "claims")
public class ClaimsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "creation_time", nullable = false)
    private Timestamp creationTime;

    @Column(name = "Date_created", nullable = false)
    private Timestamp dateCreated;

    @Column(name = "Date_updated", nullable = true)
    private Timestamp dateUpdated;

    @Column(name = "is_active", nullable = false)
    private byte isActive;

    @ManyToOne
    @JoinColumn(name = "Message_id", nullable = false , foreignKey = @ForeignKey(name = "FK_CLAIMS_MESSAGE_ID"))
    private MessageEntity messageObject;

    @OneToOne
    @JoinColumn(name = "Chat_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CLAIMS_CHAT_ID"))
    private ChatEntity chatObject;

}
