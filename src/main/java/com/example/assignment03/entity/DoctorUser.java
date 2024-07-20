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
@Table(name = "DoctorUser")
@Data
public class DoctorUser implements Serializable {

     static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
     User doctor;//1

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
     Clinics clinics;

    @ManyToOne
    @JoinColumn(name = "SPECIALIZATION_ID")
     Specializations specializations;//1

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
