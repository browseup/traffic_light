package io.khasang;

import io.khasang.model.Color;
import io.khasang.model.SignalLight;
import io.khasang.model.TrafficLight;
import io.khasang.view.ConsoleView;

/**
 * Created by alexey_n on 15.07.2016.
 */
public class Main {
    private final static int DURATION_GREEN = 2;
    private final static int DURATION_YELLOW = 3;
    private final static int DURATION_RED = 4;

    public static void main(String[] args) {
        SignalLight greenSignal = new SignalLight(Color.GREEN, DURATION_GREEN);
        SignalLight yellowSignal = new SignalLight(Color.YELLOW, DURATION_YELLOW);
        SignalLight redSignal = new SignalLight(Color.RED, DURATION_RED);
        SignalLight[] signalLights = {greenSignal, yellowSignal, redSignal};
        TrafficLight trafficLight = new TrafficLight(signalLights);
        ConsoleView consoleView = new ConsoleView(trafficLight);
        consoleView.start();
    }
}
