package org.example.appointment.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentEntity {

    @Id
    private Long id;

    private boolean expert;

    private LocalDateTime startTime;

    private Duration duration;

    private Long doctorId;

    private Long patientId;

    @Override
    public String toString() {
        return "AppointmentEntity{" +
                "id=" + id +
                ", expert=" + expert +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
