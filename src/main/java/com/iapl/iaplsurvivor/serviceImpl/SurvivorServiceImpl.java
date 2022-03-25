package com.iapl.iaplsurvivor.serviceImpl;

import com.iapl.iaplsurvivor.util.PercentageResponse;
import com.iapl.iaplsurvivor.util.RestResponse;
import com.iapl.iaplsurvivor.model.Survivor;
import com.iapl.iaplsurvivor.repository.SurvivorRepository;
import com.iapl.iaplsurvivor.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurvivorServiceImpl implements SurvivorService {
    @Autowired
    private SurvivorRepository repository;

    public Survivor saveSurvivor(Survivor survivor){
        return repository.save(survivor);
    }

    public List<Survivor> allSurvivors(){
        return repository.findAll();
    }

    public RestResponse updateSurvivorLocation(Survivor survivor){
        RestResponse restResponse=new RestResponse();
        Survivor existSurvivor=repository.findById(survivor.getID()).orElse(null);
        if(existSurvivor==null){
            restResponse.setData("Survivor does not exits");
            return restResponse;
        }
        existSurvivor.setLatitude(survivor.getLatitude());
        existSurvivor.setLongitude(survivor.getLongitude());
        repository.save(survivor);
        restResponse.setStatus(true);
        restResponse.setData(existSurvivor);
        return restResponse;
    }

    public RestResponse PercentageInfected(){
        RestResponse restResponse=new RestResponse();
        List<Survivor> survivors= repository.findAll();
        double value = survivors.stream()
                    .collect(Collectors
                         .averagingDouble(
                                num -> num.isInfected()?1:0));
        String percentage= value * 100 +"%";
        PercentageResponse response=new PercentageResponse(true, percentage);
        restResponse.setStatus(true);
        restResponse.setData(response);
        return restResponse;
    }

    public RestResponse PercentageUnInfected(){
        RestResponse restResponse=new RestResponse();
        List<Survivor> survivors= repository.findAll();
        double value = survivors.stream()
                .collect(Collectors
                        .averagingDouble(
                                num -> !num.isInfected()?1:0));
        String percentage= value * 100 +"%";
        PercentageResponse response=new PercentageResponse(true, percentage);
        restResponse.setStatus(true);
        restResponse.setData(response);
        return restResponse;
    }

    public RestResponse getAllInfectedSurvivors(){
        RestResponse restResponse=new RestResponse();
        List<Survivor> infectedSurvivors=repository.findAll().stream().filter(n->n.isInfected())
                .collect(Collectors.toList());
        restResponse.setStatus(true);
        restResponse.setData(infectedSurvivors);
        return restResponse;
    }

    public RestResponse getAllNonInfectedSurvivors(){
        RestResponse restResponse=new RestResponse();
        List<Survivor> survivors=repository.findAll().stream().filter(n->!n.isInfected())
                .collect(Collectors.toList());
        restResponse.setStatus(true);
        restResponse.setData(survivors);
        return restResponse;
    }
}
