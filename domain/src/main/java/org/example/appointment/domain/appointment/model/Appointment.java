package org.example.appointment.domain.appointment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    private LocalDateTime startTime;
    private Duration duration;
    private Long patientId;
    private Long doctorId;
}
