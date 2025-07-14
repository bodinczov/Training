package org.training.patterns.Decorator;

public class RoundedTemperatureDecorator extends TemperatureDecorator {
    public RoundedTemperatureDecorator(TemperatureSource source) {
        super(source);
    }

    @Override
    public float getTemperature() {
        return Math.round(super.getTemperature());
    }
}
