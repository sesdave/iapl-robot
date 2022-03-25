package com.iapl.iaplsurvivor.serviceImpl;

import com.iapl.iaplsurvivor.util.RestResponse;
import com.iapl.iaplsurvivor.model.ReportInfection;
import com.iapl.iaplsurvivor.model.Survivor;
import com.iapl.iaplsurvivor.repository.InfectedSurvivorReportRepository;
import com.iapl.iaplsurvivor.repository.SurvivorRepository;
import com.iapl.iaplsurvivor.service.SurvivorInfectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SurvivorInfectionReportServiceImpl implements SurvivorInfectionReportService {
    @Autowired
    InfectedSurvivorReportRepository infectedSurvivorRepository;

    @Autowired
    SurvivorRepository survivorRepository;

    public RestResponse makeInfectedSurvivorReport(int survivorid){
        RestResponse restResponse=new RestResponse();
        Survivor checkSurvivorExist=survivorRepository.findById(survivorid).orElse(null);
        if(checkSurvivorExist==null){
            restResponse.setData("survivor does not exists!!!");
            return restResponse;
        }
        ReportInfection reportInfection=infectedSurvivorRepository.findBySurvivorID(survivorid);
        if(reportInfection!=null){
            if(reportInfection.getCount()<3){
                int count=reportInfection.getCount();
                reportInfection.setCount(count+1);
                infectedSurvivorRepository.save(reportInfection);
            }else{
                Survivor survivor=reportInfection.getSurvivor();
                survivor.setInfected(true);
                survivorRepository.save(survivor);

            }
            restResponse.setStatus(true);
            restResponse.setData(reportInfection);
        }else {
            ReportInfection newReport=new ReportInfection();
            newReport.setSurvivor(checkSurvivorExist);
            newReport.setCount(1);
            infectedSurvivorRepository.save(newReport);


            restResponse.setStatus(true);
            restResponse.setData(newReport);
        }
        return restResponse;

    }
}
