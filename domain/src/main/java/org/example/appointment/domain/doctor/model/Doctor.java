package org.example.appointment.domain.doctor.model;

public class Doctor {

    private String name;
    private boolean expert;

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
