package org.training.patterns;

interface DisplayStrategy {
    void display(float temp, float humidity);
}

class TempOnlyDisplay implements DisplayStrategy {
    public void display(float temp, float humidity) {
        System.out.printf("Температура: " + temp);
    }
}

class HumidityOnlyDisplay implements DisplayStrategy {
    public void display(float temp, float humidity) {
        System.out.printf("Влажность: " + humidity);
    }
}

class FullDisplay implements DisplayStrategy {
    public void display(float temp, float humidity) {
        System.out.printf("Температура: " + temp + ", Влажность: " + humidity);
    }
}

class WeatherDisplay {
    private final DisplayStrategy strategy;

    public WeatherDisplay(DisplayStrategy strategy) {
        this.strategy = strategy;
    }

    public void update(float temp, float humidity) {
        strategy.display(temp, humidity);
    }
}
