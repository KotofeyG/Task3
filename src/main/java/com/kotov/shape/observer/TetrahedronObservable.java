package com.kotov.shape.observer;

public interface TetrahedronObservable {
    void attach(TetrahedronObserver observer);
    void detach();
    void notifyObserver();
}