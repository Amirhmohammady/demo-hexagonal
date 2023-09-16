package org.example.appointment.adapter.mapping;

import org.example.appointment.data.entities.DoctorEntity;
import org.example.appointment.domain.doctor.model.Doctor;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorEntityMapper {
    Doctor map(DoctorEntity doctor);
    DoctorEntity map(Doctor doctor);
}
