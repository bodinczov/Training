package org.training.patterns.Observer;

public interface Observer<T> {
    void update(T event);
}

interface Subject<T> {
    void addObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void notifyObservers();
}

