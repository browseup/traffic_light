package io.khasang.model;

/**
 * Created by alexey_n on 15.07.2016.
 */
public class SignalLight {
    private final Color color;
    private final int duration;

    public SignalLight(Color color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    public Color getColor() {
        return color;
    }

    public int getDuration() {
        return duration;
    }
}
