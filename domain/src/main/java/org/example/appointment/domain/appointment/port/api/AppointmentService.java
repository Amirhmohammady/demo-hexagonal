package org.example.appointment.domain.appointment.port.api;

import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.patient.model.Patient;

import java.time.Duration;
import java.time.Instant;

public interface AppointmentService {
    public void createNewAppointment(Doctor doctor, Patient patient, Instant startTime, Duration duration);
    public void createNewAppointment(Long doctorId, Long patientId, Instant startTime, Duration duration);
}

