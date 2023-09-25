package org.example.appointment.configuration;

import org.example.appointment.domain.appointment.port.api.AppointmentService;
import org.example.appointment.domain.appointment.port.spi.AppointmentRepositoryPort;
import org.example.appointment.domain.appointment.service.AppointmentServiceImpl;
import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;
import org.example.appointment.domain.doctor.service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public AppointmentService appointmentService(@Autowired AppointmentRepositoryPort appointmentRepositoryPort) {
        return new AppointmentServiceImpl(appointmentRepositoryPort);
    }

    @Bean
    public DoctorService doctorService(@Autowired DoctorRepositoryPort doctorRepositoryPort) {
        return new DoctorServiceImpl(doctorRepositoryPort);
    }
}
