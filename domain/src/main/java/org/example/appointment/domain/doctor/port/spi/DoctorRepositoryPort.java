package org.example.appointment.domain.doctor.port.spi;

import org.example.appointment.domain.doctor.model.Doctor;

public interface DoctorRepositoryPort {

    Doctor save(Doctor doctor);
}
