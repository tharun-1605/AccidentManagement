package com.sece;
import java.util.Date;

public class Incident {
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private int id;
    private Date date;
    private String location;
    private Severity severity;
    private String vehicle;
    private String description;
    private Status status;

    // Constructors, Getters, and Setters
    public Incident(int id, Date date, String location, Severity severity, String vehicle, String description, Status status) {
        this.setId(id);
        this.date = date;
        this.location = location;
        this.severity = severity;
        this.vehicle = vehicle;
        this.description = description;
        this.status = status;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

    // Getters and Setters
    // ...
}

