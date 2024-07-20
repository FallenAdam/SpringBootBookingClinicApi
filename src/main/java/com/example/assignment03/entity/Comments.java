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
@Table(name = "Comments")
@Data
public class Comments implements Serializable {

     static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = "TIMEBOOKING")
     String timeBooking;

    @Column(name = "DATEBOOKING")
     String dateBooking;

    @Column(name = " `NAME`")
     String name;

    @Column(name = "PHONE")
     String phone;

    @Column(name = "CONTENT")
     String content;

    @Column(name = "`STATUS`")
     int status;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
     User doctorId;

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
