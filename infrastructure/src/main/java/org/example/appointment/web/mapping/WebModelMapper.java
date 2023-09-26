package org.example.appointment.web.mapping;

import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.web.model.AppointmentRequset;
import org.mapstruct.Mapper;

@Mapper
public interface WebModelMapper {
    org.example.appointment.domain.doctor.model.Doctor map(org.example.appointment.web.model.Doctor doctor);

    org.example.appointment.web.model.Doctor map(org.example.appointment.domain.doctor.model.Doctor doctor);

    AppointmentRequset map(Appointment appointment);
}
