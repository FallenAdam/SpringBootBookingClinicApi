package com.example.assignment03.entity;

import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "`Users`")
@Data
public class User implements Serializable {

     static final long serialVersionUID = 1L;

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @Column(name = " `NAME`")
     String name;

    @Column(name = " EMAIL")
     String email;

    @Size(min = 8, message = "INVALID_PASSWORD")
    @Column(name = "`PASSWORD`")
     String password;

    @Column(name = "ADDRESS")
     String address;

    @Column(name = "PHONE")
     String phone;

    @Column(name = "AVATAR")
     String avatar;

    @Column(name = "GENDER")
     String gender;

    @Column(name = "`DESCRIPTION`")
     String description;

    @Column(name = "IS_ACTIVE")
     int isActive;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
     Role role;

    @Column(name = "GENERALINTRODUCTION")
     String generalIntroduction;// Giới thiệu chung

    @Column(name = "TRAININGPROCESS")
     String trainingProcess;// Quá trình đào tạo

    @Column(name = "ACHIEVEMENTSACHIEVED")
     String achievementsAchieved;// Các thành tựu đạt được

    @Column(name = "SPECIALTIES")
     String specialties;// Các chuyên khoa phụ trách

    @Column(name = "CREATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date createAt;

    @Column(name = "DELETE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date deleteAt;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.TIMESTAMP)
     Date updateAt;

    @Column(unique = true,name = "token")
     String token;

}
