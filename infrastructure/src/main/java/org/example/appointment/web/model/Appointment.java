package org.example.appointment.web.model;

import java.time.Duration;
import java.time.Instant;

public record Appointment(
        Doctor doctor,
        Patient patient,
        Instant instant,
        Duration duration
) {
}
