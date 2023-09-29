package org.example.appointment.web.listener;

import org.example.appointment.web.model.CreateAppointmentEventInWeb;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {
    @EventListener
    public void createAppointmentEventListener(CreateAppointmentEventInWeb event){
        
    }
}
