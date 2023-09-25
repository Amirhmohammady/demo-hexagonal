package org.example.appointment.domain.doctor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class General extends Doctor {
    private Long userId;
}
