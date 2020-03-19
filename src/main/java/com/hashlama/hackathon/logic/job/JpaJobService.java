package com.hashlama.hackathon.logic.job;

import com.hashlama.hackathon.dal.JobDao;
import com.hashlama.hackathon.dal.UserDao;
import com.hashlama.hackathon.logic.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaJobService implements JobService {

    private JobDao jobDao;
    private UserDao userDao;

    @Autowired
    public JpaJobService(JobDao jobDao, UserDao userDao) {
        this.jobDao = jobDao;
        this.userDao = userDao;
    }

    @Override
    public ResponseEntity<?> addJobOffer(String offerJobUserId, Integer price, String details) {
        Optional<UserEntity> optionalUserEntity = this.userDao.findById(offerJobUserId);
        if (!optionalUserEntity.isPresent())
            return new ResponseEntity<>(
                    "Cannot find user with the id : " + offerJobUserId,
                    HttpStatus.BAD_REQUEST);

        JobEntity jobEntity = new JobEntity(
                optionalUserEntity.get().getId(),
                optionalUserEntity.get().getCity(),
                details,
                price,
                optionalUserEntity.get().getPhoneNumber()
                );


        return null;
    }

    @Override
    public ResponseEntity<?> getAllJobsByCity(String city) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllJobsByWantedJobUserId(String id) {
        return null;
    }

    @Override
    public void cleanup() {

    }
}
