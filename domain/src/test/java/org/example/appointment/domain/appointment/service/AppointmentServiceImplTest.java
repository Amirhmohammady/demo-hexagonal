package org.example.appointment.domain.appointment.service;

import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.domain.appointment.port.spi.AppointmentEventPublisherPort;
import org.example.appointment.domain.appointment.port.spi.AppointmentRepositoryPort;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

class AppointmentServiceImplTest {

    @Test
    void givenEmptyDoctor_whenGettingAppointment_thenAppointmentShouldSet() {
        // arrange
        AppointmentRepositoryPort mockApointmentRepositoryPort = Mockito.mock(AppointmentRepositoryPort.class);
        Mockito.when(mockApointmentRepositoryPort.getAllAppointmentWithSameDay(Mockito.any())).thenReturn(new ArrayList<>());
        Mockito.when(mockApointmentRepositoryPort.save(Mockito.any())).thenAnswer(inp -> {
            return inp.getArgument(0);
        });
        DoctorRepositoryPort mockDoctorRepositoryPort = Mockito.mock(DoctorRepositoryPort.class);
        Mockito.when(mockDoctorRepositoryPort.findById(1L)).thenReturn(new Doctor(1L, "Ali", false));
        AppointmentEventPublisherPort mockEventPublisher = Mockito.mock(AppointmentEventPublisherPort.class);
        //Mockito.doNothing().when(mockEventPublisher).publishEvent(Mockito.any(CreateAppointmentEvent.class));

        // act
        AppointmentServiceImpl service = new AppointmentServiceImpl(mockApointmentRepositoryPort, mockDoctorRepositoryPort, mockEventPublisher);
        Appointment appointment = service.createNewAppointment(1L, 2L, LocalDateTime.of(2023, 9, 3, 15, 15), Duration.ofMinutes(15));

        // assert
        System.out.println(">".repeat(50));
        System.out.println(appointment);
        System.out.println("<".repeat(50));
        Assertions.assertEquals(appointment.getDuration(),Duration.ofMinutes(15));
    }

    @Test
    void testCreateNewAppointment() {
    }

    @Test
    void setEarlierAppointment() {
    }
}