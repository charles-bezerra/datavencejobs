package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.models.Job;
import com.datavence.datavencejobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("")
    public @ResponseBody List<Job> getAllJobs () {
        return jobRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Optional<Job> getJob (@PathVariable(name = "id") Long id) {
        return jobRepository.findById(id);
    }

    @PostMapping("")
    public @ResponseBody Job postJob (@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @DeleteMapping("")
    public void deleteJob (@RequestBody Job job){
        jobRepository.delete(job);
    }

    @PutMapping("")
    public @ResponseBody Job putJob (@RequestBody Job job) {
        return jobRepository.save(job);
    }

}
