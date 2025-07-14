package org.training.patterns.Strategy;

public class HumidityOnlyDisplay implements DisplayStrategy {
    public void display(float temp, float humidity) {
        System.out.println("Влажность: " + humidity);
    }
}

