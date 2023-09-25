package org.example.appointment.domain.appointment.service;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.domain.appointment.port.api.AppointmentService;
import org.example.appointment.domain.appointment.port.spi.AppointmentRepositoryPort;
import org.example.appointment.domain.appointment.service.exceptions.GetAppointmentException;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.patient.model.Patient;

import java.time.*;
import java.util.List;

@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepositoryPort appointmentRepositoryPort;

    @Override
    public Appointment createNewAppointment(Doctor doctor, Patient patient, Instant instant, Duration duration) {
        return null;
    }

    @Override
    public Appointment createNewAppointment(Long doctorId, Long patientId, Instant startTime, Duration duration) {
        //check duration
        if (duration.toMinutes() < 1) throw new GetAppointmentException("duration can not be less than 1 minute");

        DayOfWeek dayOfWeek = startTime.atZone(ZoneId.systemDefault()).getDayOfWeek();
        if (dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.FRIDAY)
            throw new GetAppointmentException("THURSDAY and FRIDAY are weekend");
        Instant endTime = startTime.plus(duration);
        //LocalDate currentDate = LocalDate.ofInstant(startTime, ZoneId.systemDefault());
        List<Appointment> appointments = appointmentRepositoryPort.getAllAppointmentWithSameDay(startTime);
        for (var a : appointments) {
            Instant startTime2 = a.getStartTime();
            Instant endTime2 = startTime2.plus(a.getDuration());
            if ((startTime.isAfter(startTime2) && startTime.isBefore(endTime2)) || (endTime.isAfter(startTime2) && endTime.isBefore(endTime2)))
                throw new GetAppointmentException("The appointment time interferes from " + startTime2 + " to " + endTime2);
        }
        Appointment appointment = new Appointment(startTime, duration, patientId, doctorId);
        return appointmentRepositoryPort.save(appointment);
    }

    @Override
    public Appointment setEarlierAppointment(Long doctorId, Long patientId, Duration duration) {
        return null;
    }

}
