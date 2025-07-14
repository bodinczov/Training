package org.training.patterns.Decorator;

abstract class TemperatureDecorator implements TemperatureSource {
    protected final TemperatureSource source;

    public TemperatureDecorator(TemperatureSource source) {
        this.source = source;
    }

    public float getTemperature() {
        return source.getTemperature();
    }
}
