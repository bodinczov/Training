package org.training.patterns.Factory;

public class ConverterFactory {
    public Converter create(String type) {
        return switch (type) {
            case "length" -> new LengthConverter();
            case "weight" -> new WeightConverter();
            default       -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
