package com.hashlama.hackathon.api.auth;

import com.hashlama.hackathon.api.auth.SignInRequest;
import com.hashlama.hackathon.logic.user.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private AuthService authService;

    @Autowired
    public AuthRestController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody SignInRequest signInRequest){
        System.out.println(signInRequest.getUsername() + "\n" + signInRequest.getPassword());

        return this.authService.authenticateUser(signInRequest.getUsername(), signInRequest.getPassword());
    }
}
