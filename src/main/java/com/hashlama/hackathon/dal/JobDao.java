package com.hashlama.hackathon.dal;

import com.hashlama.hackathon.logic.job.JobEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao extends PagingAndSortingRepository<JobEntity, String> {

    List<JobEntity> findAllByCity(String city);

    List<JobEntity> findAllByUserId(String userId);
}
