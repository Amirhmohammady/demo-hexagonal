package org.example.appointment.web.model;

import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class CreateAppointmentEventInWeb extends ApplicationEvent {
    private final CreateAppointmentEvent event;

    public CreateAppointmentEventInWeb(Object source, CreateAppointmentEvent event) {
        super(source);
        this.event = event;
    }

    public CreateAppointmentEventInWeb(Object source, Clock clock, CreateAppointmentEvent event) {
        super(source, clock);
        this.event = event;
    }

    public CreateAppointmentEvent getEvent() {
        return event;
    }
}
