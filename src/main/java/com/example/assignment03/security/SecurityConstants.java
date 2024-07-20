package com.example.assignment03.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;
    public static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

}
