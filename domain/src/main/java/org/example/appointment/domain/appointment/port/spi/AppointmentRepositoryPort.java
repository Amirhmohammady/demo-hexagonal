package org.example.appointment.domain.appointment.port.spi;

import org.example.appointment.domain.appointment.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepositoryPort {
    Appointment save(Appointment doctor);
    List<Appointment> getAllAppointment(LocalDate day);
}
