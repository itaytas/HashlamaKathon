package com.hashlama.hackathon.api.auth;

import com.hashlama.hackathon.api.auth.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInRequest loginRequest){
        return null;
    }
}
