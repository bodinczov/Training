package org.training;

import org.training.collections.MyArrayList;
import org.training.collections.MyLinkedList.MyLinkedList;
import org.training.collections.MyHashMap.MyHashMap;
import org.training.collections.MyHashSet.MyHashSet;
import org.training.patterns.*;
import org.training.patterns.AbstractFactory.*;
import org.training.patterns.Adapter.*;
import org.training.patterns.Decorator.*;
import org.training.patterns.Facade.*;
import org.training.patterns.Factory.*;
import org.training.patterns.Builder.User;
import org.training.patterns.Observer.*;
import org.training.patterns.Strategy.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- MyArrayList -----");
        MyArrayList<Integer> myArrayListTest = new MyArrayList<>();
        System.out.println(myArrayListTest);
        for (int i = 0; i < 10; i++) {
            myArrayListTest.add(i);
        }
        System.out.println("filled arr: " + myArrayListTest);
        myArrayListTest.add(10);
        System.out.println("add by val: " + myArrayListTest);
        myArrayListTest.add(5, 99);
        System.out.println("add by index: " + myArrayListTest);
        myArrayListTest.remove(99);
        System.out.println("remove by val: " + myArrayListTest);
        myArrayListTest.removeByIndex(0);
        System.out.println("remove by index: " + myArrayListTest);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Integer> myLinkedListTest = new MyLinkedList<>();
        myLinkedListTest.addLast(1);
        myLinkedListTest.addLast(2);
        myLinkedListTest.addLast(3);
        System.out.println("addLast: " + myLinkedListTest);
        myLinkedListTest.addFirst(0);
        System.out.println("addFirst: " + myLinkedListTest);
        myLinkedListTest.add(2, 99);
        System.out.println("add by index: " + myLinkedListTest);
        myLinkedListTest.removeFirst();
        System.out.println("removeFirst: " + myLinkedListTest);
        myLinkedListTest.removeLast();
        System.out.println("removeLast: " + myLinkedListTest);
        myLinkedListTest.remove(1);
        System.out.println("remove by index: " + myLinkedListTest);
        System.out.println("First: " + myLinkedListTest.getFirst());
        System.out.println("Last: " + myLinkedListTest.getLast());
        System.out.println("Size: " + myLinkedListTest.getSize());

        System.out.println("----- MyHashMap -----");
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        System.out.println("isEmpty: " + myHashMap.isEmpty());
        System.out.println("size: " + myHashMap.size());
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);
        myHashMap.put("Three", 3);
        myHashMap.put("Four", 4);
        System.out.println("after put: " + myHashMap);
        System.out.println("size: " + myHashMap.size());
        System.out.println("get by key: " + myHashMap.get("Two"));
        myHashMap.put("Two", 22);
        System.out.println("update value: " + myHashMap);
        System.out.println("contains 'Three': " + myHashMap.containsKey("Three"));
        System.out.println("contains 'Ten': " + myHashMap.containsKey("Ten"));
        myHashMap.remove("One");
        System.out.println("after remove: " + myHashMap);
        System.out.println("size: " + myHashMap.size());
        myHashMap.put(null, 999);
        System.out.println("null key put: " + myHashMap);
        System.out.println("get null key: " + myHashMap.get(null));

        System.out.println("----- MyHashSet -----");
        MyHashSet<String> myHashSet = new MyHashSet<>();
        System.out.println("init: " + myHashSet);
        myHashSet.put("Apple");
        myHashSet.put("Banana");
        myHashSet.put("Cherry");
        myHashSet.put("Date");
        System.out.println("after put: " + myHashSet);
        System.out.println("contains 'Banana': " + myHashSet.contains("Banana"));
        System.out.println("contains 'Orange': " + myHashSet.contains("Orange"));
        myHashSet.remove("Apple");
        System.out.println("after remove 'Apple': " + myHashSet);
        try { // для чека на невозможность добавить дубликат
            myHashSet.put("Banana");
        } catch (RuntimeException e) {
            System.out.println("duplicate insert: " + e.getMessage());
        }
        myHashSet.put(null);
        System.out.println("after put null: " + myHashSet);
        System.out.println("contains null: " + myHashSet.contains(null));
        for (int i = 0; i < 20; i++) {
            myHashSet.put("Item" + i);
        }
        System.out.println("resize check: " + myHashSet);

        demoSingleton();
        demoFactory();
        demoAbstractFactory();
        demoBuilder();
        demoAdapter();
        demoDecorator();
        demoFacade();
        demoObserver();
        demoStrategy();
    }
    static void demoSingleton() {
        System.out.println("\n=== Singleton ===");
        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();
        first.showInstance();
        System.out.println("is inst equals: " + (first == second));
    }

    static void demoFactory() {
        System.out.println("\n=== Factory Method ===");
        ConverterFactory factory = new ConverterFactory();
        Converter lenConv = factory.create("length");
        Converter weightConv = factory.create("weight");
        System.out.println("5 km = " + lenConv.convert(5) + " m");
        System.out.println("3.2 kg = " + weightConv.convert(3.2) + " g");
    }

    static void demoAbstractFactory() {
        System.out.println("\n=== Abstract Factory ===");
        GUIFactory winFactory = new WinFactory();
        GUIFactory macFactory = new MacFactory();
        System.out.println("Windows UI:");
        new Application(winFactory).renderUI();
        System.out.println("Mac UI:");
        new Application(macFactory).renderUI();
    }

    static void demoBuilder() {
        System.out.println("\n=== Builder ===");
        User user = new User.Builder()
                .name("Alex")
                .age(25)
                .email("alex@example.com")
                .build();
        System.out.println("Built user: " + user);
    }

    static void demoAdapter() {
        System.out.println("\n=== Adapter ===");
        Printer printer = new PrinterAdapter(new LegacyPrinter());
        printer.print("Hello, Adapter pattern!");
    }

    static void demoDecorator() {
        System.out.println("\n=== Decorator ===");
        TemperatureSource basic = new BasicWeatherStation();
        TemperatureSource rounded = new RoundedTemperatureDecorator(basic);
        System.out.println("Raw temperature: " + basic.getTemperature());
        System.out.println("Rounded temperature: " + rounded.getTemperature());
    }

    static void demoFacade() {
        System.out.println("\n=== Facade ===");
        WeatherFacade facade = new WeatherFacade();
        Report report = facade.getWeatherReport();
        System.out.println(report.temp() + " " + report.humid() + " " + report.windSpeed());
    }

    static void demoObserver() {
        System.out.println("\n=== Observer ===");
        WeatherStation station = new WeatherStation();
        PhoneDisplay display = new PhoneDisplay();
        station.addObserver(display);
        station.setMeasurements(24.3f, 60.1f);
    }

    static void demoStrategy() {
        System.out.println("\n=== Strategy ===");
        WeatherDisplay tempDisplay = new WeatherDisplay(new TempOnlyDisplay());
        WeatherDisplay humidDisplay = new WeatherDisplay(new HumidityOnlyDisplay());
        WeatherDisplay fullDisplay = new WeatherDisplay(new FullDisplay());
        float t = 22.8f, h = 58.0f;
        tempDisplay.update(t, h);
        humidDisplay.update(t, h);
        fullDisplay.update(t, h);
    }
}
