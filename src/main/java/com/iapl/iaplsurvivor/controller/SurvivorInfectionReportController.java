package com.iapl.iaplsurvivor.controller;

import com.iapl.iaplsurvivor.util.SurvivorReportRequest;
import com.iapl.iaplsurvivor.util.RestResponse;
import com.iapl.iaplsurvivor.service.SurvivorInfectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SurvivorInfectionReportController {
    @Autowired
    SurvivorInfectionReportService service;

    @PostMapping("/make-report")
    public RestResponse makeInfectionReport(@RequestBody SurvivorReportRequest request){
        return service.makeInfectedSurvivorReport(request.getSurvivorId());
    }

}
