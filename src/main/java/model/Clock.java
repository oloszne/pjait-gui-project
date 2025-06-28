package model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock implements Runnable, ObservableClock {
    private ClockObserver observer;

    @Override
    public void addObserver(ClockObserver observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObservers(String time) {
        observer.onTimeUpdate(time);
    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            notifyObservers(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
