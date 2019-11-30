package Model;

import Interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private ArrayList <Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void Attach(Observer o) {
        this.observers.add(o);
    }

    protected void notifyObservers() {
        for(Observer o: observers)
            o.update();
    }

}
