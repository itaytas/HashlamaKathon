package com.hashlama.hackathon.init;

import com.hashlama.hackathon.dal.UserDao;
import com.hashlama.hackathon.logic.user.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    private AuthService authService;
    private UserDao userDao;

    @Autowired
    public Initializer(AuthService authService, UserDao userDao) {
        super();
        this.authService = authService;
        this.userDao = userDao;
    }

    @PostConstruct
    public void init() throws Exception {
        createDefaultUsers();
    }

    private void createDefaultUsers() {
        String itay = "itaytas";
        String eyal = "Kazula";

        if (!this.userDao.existsByUsername(itay))
            this.authService.addUser("Itay Ta'asiri", itay, "1234", "0505050505", "RAMAT GAN", false);

        if (!this.userDao.existsByUsername(eyal))
            this.authService.addUser("Eyal Kazula", eyal, "12345", "0504747474", "TEL AVIV", true);
    }


}
