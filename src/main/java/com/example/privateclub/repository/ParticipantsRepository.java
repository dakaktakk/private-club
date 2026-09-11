package com.example.privateclub.repository;

import com.example.privateclub.domain.entity.Participant;
import jakarta.data.repository.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("NullableProblems")
@Repository
public interface ParticipantsRepository extends JpaRepository<Participant, Long> {
}
