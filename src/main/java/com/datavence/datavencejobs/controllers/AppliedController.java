package com.datavence.datavencejobs.controllers;

import com.datavence.datavencejobs.models.Applied;
import com.datavence.datavencejobs.repositories.AppliedRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applied")
public class AppliedController {
    @Autowired
    private AppliedRespository appliedRespository;
    
    @GetMapping("")
    public @ResponseBody List<Applied> getAllApplied() {
        return appliedRespository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Applied> getApplied(@PathVariable Long id) {
        return appliedRespository.findById(id);
    }

    @PostMapping("")
    public @ResponseBody Applied postApplied(@RequestBody Applied applied) {
        return appliedRespository.save(applied);
    }

    @PutMapping("")
    public @ResponseBody Applied putApplied(@RequestBody Applied applied) {
        return appliedRespository.save(applied);
    }

    @DeleteMapping("")
    public @ResponseBody void deleteApplied(@RequestBody Applied applied) {
        appliedRespository.delete(applied);
    }
}
