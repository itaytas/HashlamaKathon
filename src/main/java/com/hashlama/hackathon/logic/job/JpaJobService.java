package com.hashlama.hackathon.logic.job;

import com.hashlama.hackathon.dal.JobDao;
import com.hashlama.hackathon.dal.UserDao;
import com.hashlama.hackathon.logic.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
                    "Cannot find user with the id: " + offerJobUserId,
                    HttpStatus.BAD_REQUEST);

        JobEntity jobEntityToSave = new JobEntity(
                optionalUserEntity.get().getId(),
                optionalUserEntity.get().getCity(),
                details,
                price,
                optionalUserEntity.get().getPhoneNumber(),
                Boolean.TRUE);

        JobEntity saved = this.jobDao.save(jobEntityToSave);

        System.out.println(saved.toString());

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllJobsByCity(String city) {
        List<JobEntity> jobsByCity = this.jobDao.findAllByCity(city);
        return ResponseEntity.ok(jobsByCity);
    }

    @Override
    public ResponseEntity<?> getAllJobsByWantedJobUserId(String id) {
        List<JobEntity> jobsByUserId = this.jobDao.findAllByUserId(id);
        return ResponseEntity.ok(jobsByUserId);
    }

    @Override
    public ResponseEntity<?> takeJob(String offeredJobId, String interestedInJobId) {
        Optional<JobEntity> optionalJobEntity = this.jobDao.findById(offeredJobId);
        if (!optionalJobEntity.isPresent())
            return new ResponseEntity<>(
                    "Cannot find Job with the id: " + offeredJobId,
                    HttpStatus.BAD_REQUEST);

        JobEntity jobEntityToUpdate = optionalJobEntity.get();
        jobEntityToUpdate.setAvailable(Boolean.FALSE);
        JobEntity saved = this.jobDao.save(jobEntityToUpdate);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Override
    public void cleanup() {
        this.jobDao.deleteAll();
    }
}
