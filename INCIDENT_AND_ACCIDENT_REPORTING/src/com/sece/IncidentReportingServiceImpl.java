package com.sece;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidentReportingServiceImpl implements IncidentReportingService {
    private Connection connection;

    public IncidentReportingServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void reportIncident(Incident incident) {
        String sql = "INSERT INTO Incidents (vehicle_id, date, location, severity, description, status, vehicle) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, incident.getId());
            stmt.setDate(2, new java.sql.Date(incident.getDate().getTime()));
            stmt.setString(3, incident.getLocation());
            stmt.setString(4, incident.getSeverity().name());
            stmt.setString(5, incident.getDescription());
            stmt.setString(6, incident.getStatus().name());
            stmt.setString(7, incident.getVehicle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateIncidentStatus(int incidentId, Status status) {
        String sql = "UPDATE Incidents SET status = ? WHERE incident_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, incidentId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Accident> getAccidentsBySeverity(Severity severity) {
        List<Accident> accidents = new ArrayList<>();
        String sql = "SELECT * FROM Incidents WHERE severity = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, severity.name());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Accident accident = new Accident(
                    rs.getInt("incident_id"),
                    rs.getDate("date"),
                    rs.getString("location"),
                    Severity.valueOf(rs.getString("severity")),
                    rs.getString("vehicle"),
                    rs.getString("description"),
                    Status.valueOf(rs.getString("status")),
                    rs.getString("involvedPersonnel"),
                    rs.getString("vehicleDamage")
                );
                accidents.add(accident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accidents;
    }

    @Override
    public List<Incident> getIncidentHistory() {
        List<Incident> incidents = new ArrayList<>();
        String sql = "SELECT * FROM Incidents ORDER BY date DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Incident incident = new Incident(
                    rs.getInt("incident_id"),
                    rs.getDate("date"),
                    rs.getString("location"),
                    Severity.valueOf(rs.getString("severity")),
                    rs.getString("vehicle"),
                    rs.getString("description"),
                    Status.valueOf(rs.getString("status"))
                );
                incidents.add(incident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }
}
