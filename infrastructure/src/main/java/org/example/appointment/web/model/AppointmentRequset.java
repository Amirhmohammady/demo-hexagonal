package org.example.appointment.web.model;

import java.time.Duration;
import java.time.Instant;

public record AppointmentRequset(
        Long doctorId,
        Instant instant,
        Duration duration
) {
}
