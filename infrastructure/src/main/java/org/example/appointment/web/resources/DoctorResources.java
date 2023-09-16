package org.example.appointment.web.resources;

import org.example.appointment.domain.doctor.port.api.DoctorService;
import org.example.appointment.util.With;
import org.example.appointment.web.mapping.WebModelMapper;
import org.example.appointment.web.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class DoctorResources {

    private final DoctorService doctorService;
    private final WebModelMapper mapper;

    public DoctorResources(DoctorService doctorService, WebModelMapper mapper) {
        this.doctorService = doctorService;
        this.mapper = mapper;
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createNewDoctor(@RequestBody Doctor doctor){

        // return With.value(doctor).map(mapper::map).perform(doctorService::create).map(mapper::map).get(r->new ResponseEntity<>(r, HttpStatus.CREATED));

        var domainModelRequest = mapper.map(doctor);

        var savedDoctor = doctorService.create(domainModelRequest);

        return new ResponseEntity<>(mapper.map(savedDoctor), HttpStatus.CREATED);
    }

}
