package com.iapl.iaplsurvivor.controller;

import com.iapl.iaplsurvivor.model.Robot;
import com.iapl.iaplsurvivor.util.RobotResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RobotController {
    @GetMapping("/robots")
    public @ResponseBody
    RobotResponse getAllRobots()  {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

        ResponseEntity<Robot[]> responseEntity = restTemplate.getForEntity(url, Robot[].class);
        List<Robot> robots= Arrays.asList(responseEntity.getBody());
        RobotResponse robotResponse=new RobotResponse(true, robots);

        return robotResponse;
    }
}
