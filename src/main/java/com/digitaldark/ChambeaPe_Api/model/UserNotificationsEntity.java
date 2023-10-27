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
@Table(name = "user_notifications")
public class UserNotificationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "`read`", nullable = false)
    private byte read;

    @Column(name = "Date_created", nullable = false)
    private Timestamp dateCreated;

    @Column(name = "Date_updated", nullable = true)
    private Timestamp dateUpdated;

    @Column(name = "is_active", nullable = false)
    private byte isActive;

    @ManyToOne
    @JoinColumn(name = "User_id", nullable = false,foreignKey = @ForeignKey(name = "FK_USER_ID"))
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "Notifications_id", nullable = false,foreignKey = @ForeignKey(name = "FK_NOTIFICATIONS_ID"))
    private NotificationsEntity notificationObject;
}
