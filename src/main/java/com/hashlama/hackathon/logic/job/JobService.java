package com.hashlama.hackathon.logic.job;

import org.springframework.http.ResponseEntity;

public interface JobService {

    public ResponseEntity<?> addJobOffer(String offerJobUserId, Integer price, String details);

    public ResponseEntity<?> getAllJobsByCity(String city);

    public ResponseEntity<?> getAllJobsByWantedJobUserId(String id);

    public ResponseEntity<?> takeJob(String offeredJobId, String interestedInJobId);

    public void cleanup();
}
