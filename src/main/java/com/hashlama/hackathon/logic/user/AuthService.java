package com.hashlama.hackathon.logic.user;

import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<?> authenticateUser(String username, String password);

    public ResponseEntity<?> addUser(String fullName, String username, String password, String phoneNumber, String city, Boolean isIsolated);

    public void cleanup();
}
