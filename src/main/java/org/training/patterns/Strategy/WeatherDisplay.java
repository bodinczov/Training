package org.training.patterns.Strategy;

public class WeatherDisplay {
    private final DisplayStrategy strategy;

    public WeatherDisplay(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void update(float temp, float humidity) {
        strategy.display(temp, humidity);
    }
}
