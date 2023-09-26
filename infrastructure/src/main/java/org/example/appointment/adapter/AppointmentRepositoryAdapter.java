package org.example.appointment.adapter;

import lombok.RequiredArgsConstructor;
import org.example.appointment.data.repository.AppointmentRepository;
import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.domain.appointment.port.spi.AppointmentRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentRepositoryAdapter implements AppointmentRepositoryPort {
    private final AppointmentRepository appointmentRepository;
    @Override
    public Appointment save(Appointment doctor) {
        return null;
    }

    @Override
    public List<Appointment> getAllAppointmentWithSameDay(LocalDateTime instant) {
        return null;
    }
}
