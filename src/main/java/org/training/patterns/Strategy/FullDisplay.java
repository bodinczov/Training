package org.training.patterns.Strategy;

public class FullDisplay implements DisplayStrategy {
    public void display(float temp, float humidity) {
        System.out.println("Температура: " + temp + ", Влажность: " + humidity);
    }
}
