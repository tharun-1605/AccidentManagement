package com.sece;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            IncidentReportingServiceImpl service = new IncidentReportingServiceImpl(connection);
            Scanner scanner = new Scanner(System.in);

            // Get user input for a new incident
            System.out.println("Enter vehicle ID:");
            int vehicleId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter location:");
            String location = scanner.nextLine();

            System.out.println("Enter severity (MINOR/MAJOR):");
            String severityInput = scanner.nextLine();
            Severity severity = Severity.valueOf(severityInput.toUpperCase());

            System.out.println("Enter description:");
            String description = scanner.nextLine();

            // Create and report a new incident
            Incident incident = new Incident(0, new Date(), location, severity, "Vehicle " + vehicleId, description, Status.REPORTED);
            service.reportIncident(incident);
            System.out.println("Incident reported successfully.");

            // Update incident status
            System.out.println("Enter incident ID to update status:");
            int incidentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter new status (REPORTED/UNDER_INVESTIGATION/RESOLVED):");
            String statusInput = scanner.nextLine();
            Status status = Status.valueOf(statusInput.toUpperCase());

            service.updateIncidentStatus(incidentId, status);
            System.out.println("Incident status updated successfully.");

            // Get incident history
            List<Incident> incidents = service.getIncidentHistory();
            System.out.println("Incident History:");
            for (Incident inc : incidents) {
                System.out.println(inc);
            }

            // Get accidents by severity
            List<Accident> accidents = service.getAccidentsBySeverity(Severity.MAJOR);
            System.out.println("Major Accidents:");
            for (Accident acc : accidents) {
                System.out.println(acc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
