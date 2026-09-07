package com.example.privateclub.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Entity
@Table(name = "QR_CODES")
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "uuid")
    private UUID code;

    @ColumnDefault("false")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participants_id")
    @JsonBackReference
    private Participant participant;

    public QRCode() {}

    public QRCode(UUID code) {
        this.code = code;
    }

    public Long getId() { return id; }

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public Participant getParticipant() { return participant; }

    public void setParticipant(Participant participant) { this.participant = participant; }
}
