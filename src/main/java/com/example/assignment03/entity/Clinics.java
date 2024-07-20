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
@Table(name = "Clinics")
@Data
public class Clinics implements Serializable {

     static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = " `NAME`")
     String name;

    @Column(name = "ADDRESS")
     String address;

    @Column(name = "PHONE")
     String phone;

    @Column(name = "INTRODUCTIONHTML")
     String introductionHtml;

    @Column(name = "INTRODUCTIONMARKDOWN")
     String introductionMarkDown;

    @Column(name = "`DESCRIPTION`")
     String description;

    @Column(name = "IMAGE")
     String image;

    @Column(name = "COST_OF_EXAMINATION")
     String costOfExamination;

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date createAt;
}
