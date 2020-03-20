package com.hashlama.hackathon.api.job;

import com.hashlama.hackathon.logic.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/job")
public class JobRestController {

    private JobService jobService;

    @Autowired
    public JobRestController(JobService jobService) {
        this.jobService = jobService;
    }

    /* TODO: return the full object of the Job include job's id
    *
    */
    @PostMapping("/offer")
    public ResponseEntity<?> offerJob(@Valid @RequestBody JobOfferRequest jobOfferRequest){
        return this.jobService.addJobOffer(jobOfferRequest.getOfferJobUserId(), jobOfferRequest.getPrice(), jobOfferRequest.getDetails());
    }

    /* TODO: return all offered jobs based on the location retrieved from the path variable "id"
     *  (id of the looking for a job user)
     */
    @GetMapping("/all/id/{id}")
    public ResponseEntity<?> getAllJobsNearbyByUserId(@PathVariable String id){
        return this.jobService.getAllJobsByWantedJobUserId(id);
    }

    /* TODO: return all offered jobs based on the location retrieved from the path variable "city"
     *  (id of the looking for a job user)
     */
    @GetMapping("/all/city/{city}")
    public ResponseEntity<?> getAllJobsNearbyByLocation(@PathVariable String city){
        return this.jobService.getAllJobsByCity(city);
    }

    @PostMapping("/take")
    public ResponseEntity<?> takeJob(@Valid @RequestBody TakeOfferRequest takeOfferRequest){
        return this.jobService.takeJob(takeOfferRequest.getOfferedJobId(), takeOfferRequest.getInterestedInJobId());
    }
}
