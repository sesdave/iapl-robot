package com.iapl.iaplsurvivor.util;

import com.iapl.iaplsurvivor.model.Robot;

import java.util.List;

public class RobotResponse {
    private boolean status;
    private List<Robot> robots;


    public RobotResponse(boolean status, List<Robot> robots) {
        this.status = status;
        this.robots = robots;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }
}
