package org.example.appointment.domain.appointment.model;

import com.sun.source.tree.InstanceOfTree;
import lombok.Getter;
import lombok.Setter;
import org.example.appointment.domain.doctor.model.Doctor;
import org.example.appointment.domain.patient.model.Patient;

import java.time.Duration;
import java.time.Instant;

@Getter
@Setter
public class Appointment {
    private Instant startTime;
    private Duration duration;
    private Long patientId;
    private Long doctorId;
    private Long id;
}
