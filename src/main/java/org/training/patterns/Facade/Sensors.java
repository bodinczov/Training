package org.training.patterns.Facade;

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
