package org.example.appointment.domain.appointment.port.spi;

import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;

public interface AppointmentEventPublisherPort {
    void publishEvent(CreateAppointmentEvent event);
}
