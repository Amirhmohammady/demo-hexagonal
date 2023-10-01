package org.example.appointment.domain.doctor.port.api;

import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;
import org.example.appointment.domain.doctor.model.Doctor;

public interface DoctorService {

    Doctor create(Doctor doctor);

    Doctor getById(Long doctorId);

    void suscribeEvent(CreateAppointmentEvent event);
}
