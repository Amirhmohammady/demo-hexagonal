package org.example.appointment.domain.appointment.service;

import org.example.appointment.domain.appointment.port.api.AppointmentService;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.patient.model.Patient;

import java.time.Duration;
import java.time.Instant;

public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public void createNewAppointment(Doctor doctor, Patient patient, Instant instant, Duration duration) {

    }

    @Override
    public void createNewAppointment(Long doctorId, Long patientId, Instant startTime, Duration duration) {

    }

}
