package com.sece;

import java.util.List;

public interface IncidentReportingService {
    void reportIncident(Incident incident);
    void updateIncidentStatus(int incidentId, Status status);
    List<Accident> getAccidentsBySeverity(Severity severity);
    List<Incident> getIncidentHistory();
}
