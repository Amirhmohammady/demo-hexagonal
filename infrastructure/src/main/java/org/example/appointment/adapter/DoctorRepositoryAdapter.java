package org.example.appointment.adapter;

import org.example.appointment.adapter.mapping.DoctorEntityMapper;
import org.example.appointment.data.repository.DoctorRepository;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;
import org.example.appointment.util.With;
import org.springframework.stereotype.Service;

@Service
public class DoctorRepositoryAdapter implements DoctorRepositoryPort {

    private final DoctorRepository doctorRepository;
    private final DoctorEntityMapper mapper;

    public DoctorRepositoryAdapter(DoctorRepository repository, DoctorEntityMapper mapper) {
        this.doctorRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return With.value(doctor).map(mapper::map).perform(doctorRepository::save).map(mapper::map).orElse(null);
    }

    @Override
    public Doctor findById(Long id) {
        return mapper.map(doctorRepository.findById(id).orElse(null));
    }
}
