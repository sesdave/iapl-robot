package com.iapl.iaplsurvivor.service;

import com.iapl.iaplsurvivor.model.Survivor;
import com.iapl.iaplsurvivor.util.LocationChangeRequest;
import com.iapl.iaplsurvivor.util.RestResponse;

import java.util.List;

public interface SurvivorService {
    public Survivor saveSurvivor(Survivor survivor);
    public List<Survivor> allSurvivors();

    public RestResponse updateSurvivorLocation(LocationChangeRequest location, int Id);

    public RestResponse PercentageInfected();

    public RestResponse PercentageUnInfected();

    public RestResponse getAllInfectedSurvivors();

    public RestResponse getAllNonInfectedSurvivors();

}
