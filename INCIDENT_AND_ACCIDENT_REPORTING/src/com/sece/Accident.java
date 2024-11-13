package com.sece;
import java.util.Date;
public class Accident extends Incident {
    private String involvedPersonnel;
    public String getInvolvedPersonnel() {
		return involvedPersonnel;
	}

	public void setInvolvedPersonnel(String involvedPersonnel) {
		this.involvedPersonnel = involvedPersonnel;
	}

	public String getVehicleDamage() {
		return vehicleDamage;
	}

	public void setVehicleDamage(String vehicleDamage) {
		this.vehicleDamage = vehicleDamage;
	}

	private String vehicleDamage;

    // Constructors, Getters, and Setters
    public Accident(int id, Date date, String location, Severity severity, String vehicle, String description, Status status, String involvedPersonnel, String vehicleDamage) {
        super(id, date, location, severity, vehicle, description, status);
        this.involvedPersonnel = involvedPersonnel;
        this.vehicleDamage = vehicleDamage;
    }

    // Getters and Setters
    // ...
}