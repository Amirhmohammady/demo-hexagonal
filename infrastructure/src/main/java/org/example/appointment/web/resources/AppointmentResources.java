package org.example.appointment.web.resources;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.port.api.AppointmentService;
import org.example.appointment.web.mapping.WebModelMapper;
import org.example.appointment.web.model.Appointment;
import org.example.appointment.web.model.AppointmentRequset;
import org.example.appointment.web.securityconfig.AuthenticationFacade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class AppointmentResources {
    private final AppointmentService appointmentService;
    private final AuthenticationFacade authenticationFacade;
    private final WebModelMapper mapper;

    @GetMapping("/appointments")
    public List<Appointment> findAppointments(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate) {
        return Collections.emptyList();
    }

    @Secured({"ROLE_PATIENT"})
    @PostMapping("/appointments")
    public AppointmentRequset setAppointments(@RequestBody AppointmentRequset appointment) {
        return mapper.map(appointmentService.createNewAppointment(appointment.doctorId(), authenticationFacade.getCurrentUser().getId(), appointment.startTime(), appointment.duration()));
    }
}
