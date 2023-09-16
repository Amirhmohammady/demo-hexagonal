package org.example.appointment.configuration;

import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;
import org.example.appointment.domain.doctor.service.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public DoctorService doctorService(@Autowired DoctorRepositoryPort doctorRepositoryPort) {
        return new DoctorServiceImpl(doctorRepositoryPort);
    }
}
