package io.khasang.model;

/**
 * Created by alexey_n on 15.07.2016.
 */
public class TrafficLight {
    private final SignalLight[] signalLights;
    //private int currentSignal = 0;
    //private int currentTimeSignal = 0;

    public TrafficLight(SignalLight[] signalLights) {
        this.signalLights = signalLights;
    }
}
