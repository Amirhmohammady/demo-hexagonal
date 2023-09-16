package org.example.appointment.web.resources;

import org.example.appointment.web.model.Appointment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
