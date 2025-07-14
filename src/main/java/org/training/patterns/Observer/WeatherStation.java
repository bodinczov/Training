package org.training.patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject<WeatherEvent> {
    private final List<Observer<WeatherEvent>> observers = new ArrayList<>();
    private WeatherEvent current;

    public void setMeasurements(float t, float h) {
        current = new WeatherEvent(t, h);
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer<WeatherEvent> o : observers) {
            o.update(current);
        }
    }

    public void addObserver(Observer<WeatherEvent> o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    public void removeObserver(Observer<WeatherEvent> o) {
        observers.remove(o);
    }
}
