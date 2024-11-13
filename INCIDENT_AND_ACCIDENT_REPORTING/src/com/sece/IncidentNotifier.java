package com.sece;

import java.util.ArrayList;
import java.util.List;

public class IncidentNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Incident incident) {
        for (Observer observer : observers) {
            observer.update(incident);
        }
    }
}

