package ru.lanapetrova.savannah.simulator._main;

import ru.lanapetrova.savannah.simulator.entity.Lion;
import ru.lanapetrova.savannah.simulator.util.EventSimulator;

public class _Main {

    public static void main(String[] args) {
        Lion lion = new Lion();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(lion);
    }
}
