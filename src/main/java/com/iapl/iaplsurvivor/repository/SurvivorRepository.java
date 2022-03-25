package com.iapl.iaplsurvivor.repository;

import com.iapl.iaplsurvivor.model.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurvivorRepository extends JpaRepository<Survivor, Integer> {
}
