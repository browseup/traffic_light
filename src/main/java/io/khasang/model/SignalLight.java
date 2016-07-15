package io.khasang.model;

/**
 * Класс описывает один элемент светофора, который содержит цвет сигнала и время действия сигнала.
 * @author alexey_n
 */
public class SignalLight {
    /** Цвет сигнала */
    private final Color color;
    /** Время действия сигнала */
    private final int duration;

    /**
     * Создает объект одного элемента светофора
     * @param color Цвет сигнала
     * @param duration Время действия сигнала
     */
    public SignalLight(Color color, int duration) {
        this.color = color;
        this.duration = duration;
    }

    /**
     * @return Возвращает цвет сигнала
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return Возвращает время действия сигнала
     */
    public int getDuration() {
        return duration;
    }
}
