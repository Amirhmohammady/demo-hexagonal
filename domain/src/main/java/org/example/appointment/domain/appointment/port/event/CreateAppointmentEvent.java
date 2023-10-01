package org.example.appointment.domain.appointment.port.event;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
public class CreateAppointmentEvent {
    private Long doctorId;
    private LocalDate day;
}
