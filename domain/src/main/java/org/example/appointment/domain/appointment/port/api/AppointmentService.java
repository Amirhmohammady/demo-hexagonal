package org.example.appointment.domain.appointment.port.api;

import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.patient.model.Patient;

import java.time.Duration;
import java.time.LocalDateTime;

public interface AppointmentService {
    Appointment createNewAppointment(Doctor doctor, Patient patient, LocalDateTime startTime, Duration duration);

    Appointment createNewAppointment(Long doctorId, Long patientId, LocalDateTime startTime, Duration duration);

    Appointment setEarlierAppointment(Long doctorId, Long patientId, Duration duration);
}

