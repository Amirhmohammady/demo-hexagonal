package org.example.appointment.domain.appointment.service;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.domain.appointment.port.api.AppointmentService;
import org.example.appointment.domain.appointment.port.spi.AppointmentRepositoryPort;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.patient.model.Patient;

import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepositoryPort appointmentRepositoryPort;

    @Override
    public Appointment createNewAppointment(Doctor doctor, Patient patient, Instant instant, Duration duration) {
        return null;
    }

    @Override
    public Appointment createNewAppointment(Long doctorId, Long patientId, Instant startTime, Duration duration) {
        return null;
    }

    @Override
    public Appointment setEarlierAppointment(Long doctorId, Long patientId, Duration duration) {
        return null;
    }

}
