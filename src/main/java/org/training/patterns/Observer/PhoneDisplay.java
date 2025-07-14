package org.training.patterns.Observer;

public class PhoneDisplay implements Observer<WeatherEvent> {
    public void update(WeatherEvent event) {
        System.out.printf("Температура: " + event.temp()
                + ", влажность: " + event.humidity());
    }
}
