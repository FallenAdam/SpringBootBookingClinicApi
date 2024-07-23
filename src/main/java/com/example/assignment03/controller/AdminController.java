package com.example.assignment03.controller;

import com.example.assignment03.dto.PatientsDTO;
import com.example.assignment03.dto.PostsDTO;
import com.example.assignment03.form.CreateUserForm;
import com.example.assignment03.service.IEmailService;
import com.example.assignment03.service.IPostsService;
import com.example.assignment03.service.ISchedulesService;
import com.example.assignment03.service.IUserService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(value = "api/admin")
public class AdminController {

    @Autowired
    private IPostsService postsService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IEmailService emailService;

    @Autowired
    private ISchedulesService schedulesService;


    // Nếu Status bằng 1 thì chuyển về 0( Mở -> khóa)
    @PostMapping("/lock-account")
    public ResponseEntity<String> lockPatients(@RequestParam int id, @RequestParam String description) {
        userService.lockOrUnlockUser(id,description, true);
        return ResponseEntity.ok("Đã khóa tài khoản !");
    }

    // Nếu Status bằng 0 thì chuyển về 1(khóa -> mở)
    @PostMapping("/unLock-account")
    public ResponseEntity<String> unLockPatients(@RequestParam int id, @RequestParam String description) {
        userService.lockOrUnlockUser(id ,description, false);
        return ResponseEntity.ok("Đã mở tài khoản !");
    }



    // Create Account Doctor
    @PostMapping("/create-Doctor")
    public ResponseEntity<String> createDoctor(@RequestBody CreateUserForm form) {
        userService.createDoctor(form);
        return ResponseEntity.ok("Taọ tài khoản Bác sĩ thành công .");
    }


    // Admin check lịch sử khám bệnh của bệnh nhân
    @GetMapping("/AdminCheck-AppointmentsUser")
    public ResponseEntity<?> viewAppointmentsUserByAdmin(@RequestParam int id){
       PostsDTO postDTOS = postsService.viewAppointmentsUserByAdmin(id);
       return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }

    // Admin check lịch sử khám bệnh của bác sĩ
    @GetMapping("/AdminCheck-AppointmentsDoctor")
    public PatientsDTO viewAppointmentsDoctorByAdmin(@RequestParam int id){
        PatientsDTO patientsDTO = schedulesService.viewAppointmentsDoctorByAdmin(id);
        return patientsDTO;
    }

    // Gửi thông tin về email cá nhân của bệnh nhân
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestParam String to,
                                                          @RequestParam String subject,
                                                          @RequestParam String text,
                                                          @RequestParam MultipartFile file

    ) throws MessagingException, IOException, DocumentException {
        emailService.sendMessageWithAttachment(to, subject, text, file);
        return ResponseEntity.ok("Email sent successfully");
    }

}
