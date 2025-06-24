package org.training.patterns;

interface Converter {
    double convert(double input);
}
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
class ConverterFactory {
    public Converter create(String type) {
        return switch (type) {
            case "length" -> new LengthConverter();
            case "weight" -> new WeightConverter();
            default       -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
