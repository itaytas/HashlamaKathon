package com.hashlama.hackathon.dal;

import com.hashlama.hackathon.logic.job.JobEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends PagingAndSortingRepository<JobEntity, String> {
}
