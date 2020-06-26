package com.datavence.datavencejobs.repositories;

import com.datavence.datavencejobs.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
