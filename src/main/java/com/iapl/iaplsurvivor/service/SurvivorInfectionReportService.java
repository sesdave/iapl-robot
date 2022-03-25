package com.iapl.iaplsurvivor.service;

import com.iapl.iaplsurvivor.util.RestResponse;

public interface SurvivorInfectionReportService {
    public RestResponse makeInfectedSurvivorReport(int survivor);
}
