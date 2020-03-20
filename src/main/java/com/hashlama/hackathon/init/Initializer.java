package com.hashlama.hackathon.init;

import com.hashlama.hackathon.dal.JobDao;
import com.hashlama.hackathon.dal.UserDao;
import com.hashlama.hackathon.logic.job.JobService;
import com.hashlama.hackathon.logic.user.AuthService;
import com.hashlama.hackathon.logic.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class Initializer {

    private AuthService authService;
    private JobService jobService;
    private UserDao userDao;
    private JobDao jobDao;

    @Autowired
    public Initializer(AuthService authService, JobService jobService, UserDao userDao, JobDao jobDao) {
        this.authService = authService;
        this.jobService = jobService;
        this.userDao = userDao;
        this.jobDao = jobDao;
    }

    @PostConstruct
    public void init() throws Exception {
        String itay = "itaytas";
        String kazula = "Kazula";
        createDefaultUsers(itay, kazula);
        createDefaultJobs(itay, kazula);
    }

    private void createDefaultJobs(String itay, String kazula) throws Exception {
        Optional<UserEntity> optionalUserEntity = this.userDao.findByUsername(kazula);
        if (!optionalUserEntity.isPresent())
            throw new Exception("Problem occured while creating users");

        UserEntity userEntity = optionalUserEntity.get();
        this.jobService.addJobOffer(userEntity.getId(), 100, "Details for the first job");
        this.jobService.addJobOffer(userEntity.getId(), 200, "Details for the second job");
        this.jobService.addJobOffer(userEntity.getId(), 300, "Details for the third job");
        this.jobService.addJobOffer(userEntity.getId(), 400, "Details for the forth job");


    }

    private void createDefaultUsers(String itay, String kazula) {
        if (!this.userDao.existsByUsername(itay))
            this.authService.addUser("Itay Ta'asiri", itay, "1234", "0505050505", "RAMAT GAN", false);

        if (!this.userDao.existsByUsername(kazula))
            this.authService.addUser("Eyal Kazula", kazula, "12345", "0504747474", "TEL AVIV", true);
    }


}
