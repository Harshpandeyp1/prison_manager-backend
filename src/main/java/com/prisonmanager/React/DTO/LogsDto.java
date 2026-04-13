package com.prisonmanager.React.DTO;

public class LogsDto {

    private String id;
    private String type;
    private String message;
    private String time;
    private String date;
    private String badge;

    public LogsDto(String id, String type, String message, String time, String date, String badge) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.time = time;
        this.date = date;
        this.badge = badge;
    }

    // Getters
    public String getId() { return id; }
    public String getType() { return type; }
    public String getMessage() { return message; }
    public String getTime() { return time; }
    public String getDate() { return date; }
    public String getBadge() { return badge; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setMessage(String message) { this.message = message; }
    public void setTime(String time) { this.time = time; }
    public void setDate(String date) { this.date = date; }
    public void setBadge(String badge) { this.badge = badge; }
}