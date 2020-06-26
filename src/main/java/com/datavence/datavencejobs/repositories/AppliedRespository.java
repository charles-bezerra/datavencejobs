package com.datavence.datavencejobs.repositories;

import com.datavence.datavencejobs.models.Applied;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppliedRespository extends JpaRepository <Applied, Long> {
    List<Applied> findAll();
}
