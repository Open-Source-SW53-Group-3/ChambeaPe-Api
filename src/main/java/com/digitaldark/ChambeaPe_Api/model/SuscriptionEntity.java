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
@Table(name = "suscription")
public class SuscriptionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "start_day", nullable = false)
    private Timestamp startDay;

    @Column(name = "end_day", nullable = false)
    private Timestamp endDay;

    @Column(name = "Date_created", nullable = false)
    private Timestamp dateCreated;

    @Column(name = "Date_updated", nullable = true)
    private Timestamp dateUpdated;

    @Column(name = "is_active", nullable = false)
    private byte isActive;
    @ManyToOne
    @JoinColumn(name = "Premium_id", nullable = false,foreignKey = @ForeignKey(name = "FK_SUSCRIPTION_PREMIUM_ID"))
    private PremiumEntity premiumObject;
    @ManyToOne
    @JoinColumn(name = "User_id", nullable = false,foreignKey = @ForeignKey(name = "FK_SUSCRIPTION_USER_ID"))
    private UsersEntity user;
}
