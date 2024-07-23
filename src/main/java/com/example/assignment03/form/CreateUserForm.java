package com.example.assignment03.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserForm {
    private int id;
    @Size(min = 3,message = "USERNAME_INVALID")
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String generalIntroduction;// Giới thiệu chung
    private String trainingProcess;// Quá trình đào tạo
    private String achievementsAchieved;// Các thành tựu đạt được
    private String specialties;// Các chuyên khoa phụ trách


}
