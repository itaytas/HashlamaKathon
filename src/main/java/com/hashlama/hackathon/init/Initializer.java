package com.hashlama.hackathon.init;

import com.hashlama.hackathon.logic.user.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    private AuthService authService;

    @Autowired
    public Initializer(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostConstruct
    public void init() throws Exception {
        createDefaultUsers();
    }

    private void createDefaultUsers() {
        this.authService.addUser("Itay Ta'asiri", "itaytas", "1234", "0505050505", "RAMAT GAN", false);
    }


}
