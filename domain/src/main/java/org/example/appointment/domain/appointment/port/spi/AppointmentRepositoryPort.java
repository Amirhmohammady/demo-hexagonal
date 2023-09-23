package org.example.appointment.domain.appointment.port.spi;

import org.example.appointment.domain.appointment.model.Appointment;

public interface AppointmentRepositoryPort {
    Appointment save(Appointment doctor);
}
