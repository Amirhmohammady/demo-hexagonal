package org.example.appointment.domain.doctor.service;

import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepositoryPort repository;

    public DoctorServiceImpl(DoctorRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Doctor create(Doctor doctor) {
        return repository.save(doctor);
    }
}
