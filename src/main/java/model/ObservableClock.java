package model;

public interface ObservableClock {
    void addObserver(ClockObserver observer);
    void notifyObservers(String time);
}
