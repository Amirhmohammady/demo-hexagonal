package org.example.appointment.web.listener;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;
import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.web.model.CreateAppointmentEventInWeb;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyEventListener {
    private final DoctorService doctorService;

    @EventListener
    public void createAppointmentEventListener(CreateAppointmentEventInWeb event) {
        CreateAppointmentEvent createAppointmentEvent = event.getEvent();
        doctorService.suscribeEvent(createAppointmentEvent);
    }
}
