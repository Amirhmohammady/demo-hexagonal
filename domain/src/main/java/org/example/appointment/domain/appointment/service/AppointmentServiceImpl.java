package org.example.appointment.domain.appointment.service;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.model.Appointment;
import org.example.appointment.domain.appointment.port.api.AppointmentService;
import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;
import org.example.appointment.domain.appointment.port.spi.AppointmentEventPublisherPort;
import org.example.appointment.domain.appointment.port.spi.AppointmentRepositoryPort;
import org.example.appointment.domain.appointment.service.exceptions.GetAppointmentException;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.doctor.port.spi.DoctorRepositoryPort;
import org.example.appointment.domain.patient.model.Patient;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepositoryPort appointmentRepositoryPort;
    private final DoctorRepositoryPort doctorRepositoryPort;
    private final AppointmentEventPublisherPort eventPublisher;

    @Override
    public Appointment createNewAppointment(Doctor doctor, Patient patient, LocalDateTime startTime, Duration duration) {
        return null;
    }

    @Override
    public Appointment createNewAppointment(Long doctorId, Long patientId, LocalDateTime startTime, Duration duration) {
        //check duration
        Doctor doctor = doctorRepositoryPort.findById(doctorId);
        if (doctor.isExpert()) {
            if (duration.toMinutes() < 10 || duration.toMinutes() > 30)
                throw new GetAppointmentException("duration fo expert doctor is 10 to 30 minute");
        } else if (duration.toMinutes() < 5 || duration.toMinutes() > 15)
            throw new GetAppointmentException("duration fo general doctor is 5 to 15 minute");

        DayOfWeek dayOfWeek = startTime.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.FRIDAY)
            throw new GetAppointmentException("THURSDAY and FRIDAY are weekend");

        LocalTime time = startTime.atZone(ZoneId.systemDefault()).toLocalTime();
        if (time.isBefore(LocalTime.of(9, 0)) || time.plus(duration).isAfter(LocalTime.of(18, 0)))
            throw new GetAppointmentException("appointment time should be between 9 to 18");

        LocalDateTime endTime = startTime.plus(duration);
        //LocalDate currentDate = LocalDate.ofInstant(startTime, ZoneId.systemDefault());
        List<Appointment> appointments = appointmentRepositoryPort.getAllAppointmentWithSameDay(startTime);
        for (var a : appointments) {
            LocalDateTime startTime2 = a.getStartTime();
            LocalDateTime endTime2 = startTime2.plus(a.getDuration());
            if ((startTime.isAfter(startTime2) && startTime.isBefore(endTime2)) || (endTime.isAfter(startTime2) && endTime.isBefore(endTime2)))
                throw new GetAppointmentException("The appointment time interferes from " + startTime2 + " to " + endTime2);
        }
        Appointment appointment = new Appointment(startTime, duration, patientId, doctorId);
        eventPublisher.publishEvent(new CreateAppointmentEvent(appointment.getDoctorId(), appointment.getStartTime().toLocalDate()));
        return appointmentRepositoryPort.save(appointment);
    }

    @Override
    public Appointment setEarlierAppointment(Long doctorId, Long patientId, Duration duration) {
        //check duration
        Doctor doctor = doctorRepositoryPort.findById(doctorId);
        if (doctor.isExpert()) {
            if (duration.toMinutes() < 10 || duration.toMinutes() > 30)
                throw new GetAppointmentException("duration fo expert doctor is 10 to 30 minute");
        } else if (duration.toMinutes() < 5 || duration.toMinutes() > 15)
            throw new GetAppointmentException("duration fo general doctor is 5 to 15 minute");

        LocalDateTime day = LocalDateTime.now();
        for (int t1 = 0; t1 < 10; t1++) {
            List<Appointment> appointments = appointmentRepositoryPort.getAllAppointmentWithSameDay(day);
            LocalTime startTime = LocalTime.of(9, 0);
            LocalTime endTime;
            for (var a : appointments) {
                endTime = startTime.plus(duration);
                LocalTime sTime = a.getStartTime().toLocalTime();
                LocalTime eTime = sTime.plus(a.getDuration());
                if (!((endTime.isAfter(sTime) && endTime.isBefore(eTime)) || (startTime.isBefore(sTime) && endTime.isAfter(eTime)))) {
                    eventPublisher.publishEvent(new CreateAppointmentEvent(doctorId, day.toLocalDate()));
                    return appointmentRepositoryPort.save(new Appointment(day, duration, patientId, doctorId));
                }
                if (eTime.plus(duration).isAfter(LocalTime.of(18, 0))) break;
                startTime = eTime;
            }
            DayOfWeek dayOfWeek;
            do {
                day = day.plus(1, ChronoUnit.DAYS);
                dayOfWeek = day.getDayOfWeek();
            } while (dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.FRIDAY);
        }
        throw new GetAppointmentException("there is no free time in next 10 days to get appointment.");
    }

}
