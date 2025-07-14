package org.training.patterns.Strategy;

public class TempOnlyDisplay implements DisplayStrategy {
    public void display(float temp, float humidity) {
        System.out.println("Температура: " + temp);
    }
}
