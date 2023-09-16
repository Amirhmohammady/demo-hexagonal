package org.example.appointment.adapter;

import org.example.appointment.adapter.mapping.DoctorEntityMapper;
import org.example.appointment.data.repository.DoctorRepository;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;
import org.example.appointment.util.With;
import org.springframework.stereotype.Service;

@Service
public class DoctorRepositoryAdapter implements DoctorRepositoryPort {

    private final DoctorRepository repository;
    private final DoctorEntityMapper mapper;

    public DoctorRepositoryAdapter(DoctorRepository repository, DoctorEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return With.value(doctor).map(mapper::map).perform(repository::save).map(mapper::map).orElse(null);
    }
}
