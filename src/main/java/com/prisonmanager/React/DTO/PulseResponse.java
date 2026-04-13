package com.prisonmanager.React.DTO;

import java.util.List;

public class PulseResponse {
    private long totalInmates;
    private long activeStaff;
    private long alerts;
    private double occupancyRate;
    private List<String> recentLogs;

    public PulseResponse(long totalInmates, long activeStaff, long alerts, double occupancyRate, List<String> recentLogs) {
        this.totalInmates = totalInmates;
        this.activeStaff = activeStaff;
        this.alerts = alerts;
        this.occupancyRate = occupancyRate;
        this.recentLogs = recentLogs;
    }

    // Getters and setters
    public long getTotalInmates() {
        return totalInmates;
    }

    public void setTotalInmates(long totalInmates) {
        this.totalInmates = totalInmates;
    }

    public long getActiveStaff() {
        return activeStaff;
    }

    public void setActiveStaff(long activeStaff) {
        this.activeStaff = activeStaff;
    }

    public long getAlerts() {
        return alerts;
    }

    public void setAlerts(long alerts) {
        this.alerts = alerts;
    }

    public double getOccupancyRate() {
        return occupancyRate;
    }

    public void setOccupancyRate(double occupancyRate) {
        this.occupancyRate = occupancyRate;
    }

    public List<String> getRecentLogs() {
        return recentLogs;
    }

    public void setRecentLogs(List<String> recentLogs) {
        this.recentLogs = recentLogs;
    }
}
