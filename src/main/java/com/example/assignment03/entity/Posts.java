package com.example.assignment03.entity;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Posts")
@Data
public class Posts implements Serializable {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = "TITLE")
     String title;

    @Column(name = "CONTENMARKDOWN")
     String contentMarkdown;

    @Column(name = "CONTENHTML")
     String contentHtml;

    @ManyToOne
    @JoinColumn(name = "FOR_DOCTOR_ID")
     User doctorId;

    @ManyToOne
    @JoinColumn(name = "FOR_SPECIALIZATION_ID")
     Specializations specializations;

    @ManyToOne
    @JoinColumn(name = "FOR_CLINIC_ID")
     Clinics clinics;

    @ManyToOne
    @JoinColumn(name = "FOR_PATIENT_ID")
      Patients patients;

    @Column(name = "DATE_TIME_BOOKING")
     Date dateTimeBooking;

    @Column(name = "CONFIRM_BY_DOCTOR")
     int confirmByDoctor;

    @Column(name = "IMAGE")
     String image;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date createAt;

    @Column(name = "DELETE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date deleteAt;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date updateAt;
}
