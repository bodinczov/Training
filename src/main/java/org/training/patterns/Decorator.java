package org.training.patterns;

interface TemperatureSource {
    float getTemperature();
}
class BasicWeatherStation implements TemperatureSource {
    public float getTemperature() {
        return 23.567f;
    }
}
abstract class TemperatureDecorator implements TemperatureSource {
    protected final TemperatureSource source;

    public TemperatureDecorator(TemperatureSource source) {
        this.source = source;
    }

    public float getTemperature() {
        return source.getTemperature();
    }
}
class RoundedTemperatureDecorator extends TemperatureDecorator {
    public RoundedTemperatureDecorator(TemperatureSource source) {
        super(source);
    }

    @Override
    public float getTemperature() {
        return Math.round(super.getTemperature());
    }
}