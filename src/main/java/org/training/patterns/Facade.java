package org.training.patterns;

class Thermometer {
    public float readTemperature() {
        return 23.56f;
    }
}
class Hygrometer {
    public float readHumidity() {
        return 55.2f;
    }
}
class WindSensor {
    public float readSpeed() {
        return 4.5f;
    }
}
class WeatherFacade {
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
record Report(float temp, float humid, float windSpeed){}