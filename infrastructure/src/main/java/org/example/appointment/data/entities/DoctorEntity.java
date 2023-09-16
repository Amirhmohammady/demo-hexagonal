package org.example.appointment.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DoctorEntity {

    @Id
    private Long id;

    private String name;

    private boolean expert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpert() {
        return expert;
    }

    public void setExpert(boolean expert) {
        this.expert = expert;
    }
}
