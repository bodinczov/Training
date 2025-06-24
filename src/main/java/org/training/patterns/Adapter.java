package org.training.patterns;

class LegacyPrinter {
    public void printLegacy(String text) {
        System.out.println("OLD: " + text);
    }
}
interface Printer {
    void print(String text);
}
class PrinterAdapter implements Printer {
    private final LegacyPrinter legacy;

    public PrinterAdapter(LegacyPrinter legacy) {
        this.legacy = legacy;
    }

    public void print(String text) {
        legacy.printLegacy(text);
    }
}
