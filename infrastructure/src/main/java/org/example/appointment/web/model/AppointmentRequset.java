package org.example.appointment.web.model;

import java.time.Duration;
import java.time.LocalDateTime;

public record AppointmentRequset(
        Long doctorId,
        LocalDateTime startTime,
        Duration duration
) {
}
