package org.example.appointment.domain.appointment.port.event;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class CreateAppointmentEvent {
    private Long doctorId;
    private LocalDate day;
}
