package org.example.appointment.domain.doctor.service;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;

@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepositoryPort repository;

    /*public DoctorServiceImpl(DoctorRepositoryPort repository) {
        this.repository = repository;
    }*/

    @Override
    public Doctor create(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor getById(Long doctorId) {
        return null;
    }

    @Override
    public void suscribeEvent(CreateAppointmentEvent event) {
        System.out.println("Doctor dmain notifed that Appointment created: " + event);
    }
}
