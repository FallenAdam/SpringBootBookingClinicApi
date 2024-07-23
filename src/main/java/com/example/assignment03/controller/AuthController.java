package com.example.assignment03.controller;


import com.example.assignment03.exception.AppException;
import com.example.assignment03.exception.ErrorCode;
import com.example.assignment03.security.JwtGenerator;
import com.example.assignment03.form.LoginForm;
import com.example.assignment03.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@Validated @RequestBody LoginForm request) throws Exception {
        try {
            authenticate(request.getEmail(), request.getPassword());

            UserDetails userDetails = userService.loadUserByUsername(request.getEmail());
            String token = jwtGenerator.generateToken(userDetails);

            return ResponseEntity.ok("Token: " + token);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred, this user might not exist");
        }
    }




    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AppException(ErrorCode.DISABLED_ACCESS);
        } catch (BadCredentialsException e) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);        }
    }
}
