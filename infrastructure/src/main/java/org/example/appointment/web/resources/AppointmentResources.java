package org.example.appointment.web.resources;

import org.example.appointment.web.model.Appointment;
import org.example.appointment.web.model.AppointmentRequset;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class AppointmentResources {

    @GetMapping("/appointments")
    public List<Appointment> findAppointments(
            @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate
    ) {
        return Collections.emptyList();
    }

    @Secured({"ROLE_PATIENT"})
    @PostMapping("/appointments")
    public AppointmentRequset setAppointments(
            @RequestBody AppointmentRequset appointment
    ) {
        return null;
    }
}
