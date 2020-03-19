package com.hashlama.hackathon.api.job;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/job")
public class JobRestController {

    @PostMapping("/offer")
    public ResponseEntity<?> offerJob(@Valid @RequestBody OfferedJob offeredJob){
        return null;
    }
    
    @GetMapping("/all/{city}")
    public ResponseEntity<?> getAllJobsNearby(@PathVariable String city){
        return null;
    }

    @PostMapping("/provider")
    public ResponseEntity<?> takeJob(){
        return null;
    }
}
