package org.example.appointment.adapter;

import lombok.RequiredArgsConstructor;
import org.example.appointment.domain.appointment.port.event.CreateAppointmentEvent;
import org.example.appointment.domain.appointment.port.spi.AppointmentEventPublisherPort;
import org.example.appointment.web.model.CreateAppointmentEventInWeb;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentEventPublisherAdapter implements AppointmentEventPublisherPort {
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishEvent(CreateAppointmentEvent event) {
        eventPublisher.publishEvent(new CreateAppointmentEventInWeb(this , event));
    }
}
