package org.company.desafio.observer;

import java.util.ArrayList;
import java.util.List;

public class Observavel<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notificaObservers(T obj) {
        for (Observer<T> observer : observers) {
            observer.update(obj);
        }
    }
}
