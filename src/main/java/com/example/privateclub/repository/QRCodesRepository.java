package com.example.privateclub.repository;

import com.example.privateclub.domain.entity.Participant;
import com.example.privateclub.domain.entity.QRCode;
import jakarta.data.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("NullableProblems")
@Repository
public interface QRCodesRepository extends JpaRepository<QRCode, Long> {

    Optional<QRCode> findByParticipantAndActiveTrue(Participant participant);

    Optional<QRCode> findByCode(UUID codeId);

    Optional<QRCode> findByParticipantIdAndActiveTrue(Long participantId);
}
