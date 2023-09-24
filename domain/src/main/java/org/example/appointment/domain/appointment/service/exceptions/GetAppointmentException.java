package org.example.appointment.domain.appointment.service.exceptions;

public class GetAppointmentException extends RuntimeException{
    public GetAppointmentException(String message) {
        super(message);
    }

    public GetAppointmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public GetAppointmentException(Throwable cause) {
        super(cause);
    }
}
