package org.training.patterns.Factory;

class LengthConverter implements Converter {
    public double convert(double input) {
        return input * 1000;
    }
}
class WeightConverter implements Converter {
    public double convert(double input) {
        return input * 1000;
    }
}
