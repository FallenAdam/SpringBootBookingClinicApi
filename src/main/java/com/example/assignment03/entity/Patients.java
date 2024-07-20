package com.example.assignment03.entity;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Patients")
@Data
public class Patients implements Serializable {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = " `STATUS`")
     int status;

    @Column(name = " `NAME`")
     String name;

    @Column(name = "GENDER")
     String gender;

    @Column(name = "PHONE")
     String phone;

    @Column(name = "ADDRESS")
     String address;

    @Column(name = " DATE_OF_BIRTH")
     String dateOfBirth;

    @Column(name = "PATHOLOGICAL")
     String pathological;

    @Column(name = "`DESCRIBE`")
     String describe;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
     User doctor;
}
