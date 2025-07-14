package org.training.patterns.Facade;

public class WeatherFacade {
    private final Thermometer thermometer = new Thermometer();
    private final Hygrometer hygrometer = new Hygrometer();
    private final WindSensor windSensor = new WindSensor();

    public float getCurrentTemperature() {
        return thermometer.readTemperature();
    }

    public float getCurrentHumidity() {
        return hygrometer.readHumidity();
    }

    public Report getWeatherReport() {
        return new Report(thermometer.readTemperature(),
                hygrometer.readHumidity(),
                windSensor.readSpeed());
    }
}
