package com.iapl.iaplsurvivor.util;

public class PercentageResponse {
    private boolean status;
    private String percentage;

    public PercentageResponse(boolean status, String percentage) {
        this.status = status;
        this.percentage = percentage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
