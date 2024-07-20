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
@Table(name = "Schedules")
@Data
public class Schedules implements Serializable {

    static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;


    @Column(name = "`DATE`")
     String date;

    @Column(name = "`TIME`")
     String time;

    @Column(name = "MAX_BOOKING")
     String maxBooking;

    @Column(name = "SUM_BOOKING")
     String sumBooking;

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
