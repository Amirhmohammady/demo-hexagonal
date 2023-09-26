package org.example.appointment.web.model;

import java.time.Duration;

public record EarlierAppointmentRequest(
        Long doctorId,
        Duration duration
) {
}
