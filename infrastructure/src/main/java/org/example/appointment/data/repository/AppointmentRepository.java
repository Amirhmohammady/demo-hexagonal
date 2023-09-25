package org.example.appointment.data.repository;

import org.example.appointment.data.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    Optional<AppointmentEntity> findById(Long Id);
}
