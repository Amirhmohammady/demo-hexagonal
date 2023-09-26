package org.example.appointment.web.model;

import java.time.Duration;
import java.time.LocalDateTime;

public record Appointment(
        Doctor doctor,
        Patient patient,
        LocalDateTime instant,
        Duration duration
) {
}
