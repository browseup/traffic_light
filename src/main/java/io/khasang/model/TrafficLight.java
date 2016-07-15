package io.khasang.model;

/**
 * Класс описывает светофор, который содержит набор элементов светофора и его состояние.
 * В светофоре может быть любое кол-во элементов светофора и любая их очередность
 * @author alexey_n
 */
public class TrafficLight {
    /** Набор элементов светофора */
    private final SignalLight[] signalLights;
    /** Индекс элемента светофора, который горит в текущее время */
    private int currentIndexSignal = 0;
    /** Сколько времени горит текущий элемент светофора */
    private int currentTimeSignal = 0;
    /** Время одного полного цикла работы всех элементов светофора */
    private int timeFullCycle = 0;
    /** Время работы светофора. Светофор имеет состояние по истечению этого времени */
    private int time = 0;

    /**
     * Создает объект светофора
     * @param signalLights Набор элементов светофора
     */
    public TrafficLight(SignalLight[] signalLights) {
        this.signalLights = signalLights;
    }

    /**
     * При получения времени работы светофора, объект принимает состояние, которое должен иметь по истечению этого врмени
     * @param time Время работы светофора. Светофор имеет состояние по истечению этого времени
     */
    public void setTime(int time) {
        this.time = time;
        prepareState();
    }

    /**
     * @return Индекс элемента светофора, который горит в текущее время
     */
    public int getCurrentIndexSignal() {
        return currentIndexSignal;
    }

    /**
     * @return Возвращает цвет текущего элемента светофора
     */
    public Color getCurrentColor() {
        Color currentColor = signalLights[currentIndexSignal].getColor();
        return currentColor;
    }

    /**
     * @return Возвращает время, которое отработал текущий элемент светофора (0 означает что этот элемент светофора только начал своб работу)
     */
    public int getCurrentTimeSignal() {
        return currentTimeSignal;
    }

    /**
     * Метод, который обновляет состояние объекта на основании time - времени работы светофора
     */
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
