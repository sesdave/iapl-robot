package com.iapl.iaplsurvivor.repository;

import com.iapl.iaplsurvivor.model.ReportInfection;
import org.springframework.data.repository.CrudRepository;

public interface InfectedSurvivorReportRepository extends CrudRepository<ReportInfection, Integer> {
    ReportInfection findBySurvivorID(int survivorid);
}
