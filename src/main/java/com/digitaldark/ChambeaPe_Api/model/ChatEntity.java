package com.digitaldark.ChambeaPe_Api.model;

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
@Table(name = "chat")
public class ChatEntity {
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
    @JoinColumn(name = "Worker_id", nullable = false, foreignKey = @ForeignKey(name = "FK_WORKER_ID"))
    private WorkerEntity worker;

    @ManyToOne
    @JoinColumn(name = "Employer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EMPLOYER_ID"))
    private EmployerEntity employer;

    @ManyToOne
    @JoinColumn(name = "Message_id", nullable = false, foreignKey = @ForeignKey(name = "FK_MESSAGE_ID"))
    private MessageEntity messageObject;
}
