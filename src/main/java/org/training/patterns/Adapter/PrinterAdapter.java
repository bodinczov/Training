package org.training.patterns.Adapter;

public class PrinterAdapter implements Printer {
    private final LegacyPrinter legacy;

    public PrinterAdapter(LegacyPrinter legacy) {
        this.legacy = legacy;
    }

    public void print(String text) {
        legacy.printLegacy(text);
    }
}
