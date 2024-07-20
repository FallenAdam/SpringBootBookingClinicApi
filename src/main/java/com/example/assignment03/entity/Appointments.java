package com.example.assignment03.entity;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Appointments")
@Data
public class Appointments implements Serializable {

     static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = "PATHOLOGICAL")
     String pathological;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
     Patients patients;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID")
     Places places;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
     User doctorId;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date createAt;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date updateAt;
}
