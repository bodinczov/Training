package org.training.patterns;

import java.util.ArrayList;
import java.util.List;

interface Observer<T> {
    void update(T event);
}

interface Subject<T> {
    void addObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void notifyObservers();
}

class WeatherStation implements Subject<WeatherEvent> {
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

record WeatherEvent(float temp, float humidity) {}

class PhoneDisplay implements Observer<WeatherEvent> {
    public void update(WeatherEvent event) {
        System.out.printf("Температура: " + event.temp()
                + ", влажность: " + event.humidity());
    }
}
