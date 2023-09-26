package org.example.appointment.data.repository;

import org.example.appointment.data.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    Optional<AppointmentEntity> findById(Long Id);

    @Query("SELECT a FROM AppointmentEntity AS a WHERE FUNCTION('DATEDIFF',a.startTime,:day)=0 ORDER BY a.startTime ASC")
    List<AppointmentEntity> getAllByDayAscending(@Param("day") LocalDateTime day);
}
