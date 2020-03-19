package com.hashlama.hackathon.api.job;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/job")
public class JobRestController {

    /* TODO: return the full object of the Job include job's id
    *
    */
    @PostMapping("/offer")
    public ResponseEntity<?> offerJob(@Valid @RequestBody JobOfferRequest jobOfferRequest){
        return null;
    }

    /* TODO: return all offered jobs based on the location retrieved from the path variable "id"
     *  (id of the looking for a job user)
     */
    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllJobsNearby(@PathVariable String id){
        return null;
    }

    @PostMapping("/provider")
    public ResponseEntity<?> takeJob(){
        return null;
    }
}
