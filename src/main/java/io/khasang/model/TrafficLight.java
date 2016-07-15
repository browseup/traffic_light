package io.khasang.model;

/**
 * Created by alexey_n on 15.07.2016.
 */
public class TrafficLight {
    private final SignalLight[] signalLights;
    private int currentIndexSignal = 0;
    private int currentTimeSignal = 0;
    private int timeFullCycle = 0;
    private int time = 0;

    public TrafficLight(SignalLight[] signalLights) {
        this.signalLights = signalLights;
    }

    public void setTime(int time) {
        this.time = time;
        prepareState();
    }

    public int getCurrentIndexSignal() {
        return currentIndexSignal;
    }

    public Color getCurrentColor() {
        Color currentColor = signalLights[currentIndexSignal].getColor();
        return currentColor;
    }

    public int getCurrentTimeSignal() {
        return currentTimeSignal;
    }

    private void prepareState() {
        for (int i = 0; i < signalLights.length; i++) {
            timeFullCycle += signalLights[i].getDuration();
        }
        int timeInLastCycle = time % timeFullCycle;
        for (int i = 0; i < signalLights.length; i++) {
            if (timeInLastCycle >= signalLights[i].getDuration()) {
                timeInLastCycle -= signalLights[i].getDuration();
            } else {
                currentIndexSignal = i;
                currentTimeSignal = timeInLastCycle;
                i = signalLights.length;
            }
        }
    }
}
