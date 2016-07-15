package io.khasang;

import io.khasang.model.Color;
import io.khasang.model.SignalLight;
import io.khasang.model.TrafficLight;
import io.khasang.view.ConsoleView;

/**
 * Класс для запуска программы
 * @author alexey_n
 */
public class Main {
    /** Время работы зеленого сигнала */
    private final static int DURATION_GREEN = 2;
    /** Время работы желтого сигнала */
    private final static int DURATION_YELLOW = 3;
    /** Время работы красного сигнала */
    private final static int DURATION_RED = 4;

    /**
     * Точка входа в программу
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        /** Создаем три элемента светофора */
        SignalLight greenSignal = new SignalLight(Color.GREEN, DURATION_GREEN);
        SignalLight yellowSignal = new SignalLight(Color.YELLOW, DURATION_YELLOW);
        SignalLight redSignal = new SignalLight(Color.RED, DURATION_RED);
        /** Создаем массив элементов светофора. Очередность важна */
        SignalLight[] signalLights = {greenSignal, yellowSignal, redSignal};
        /** Создаем объект светофора */
        TrafficLight trafficLight = new TrafficLight(signalLights);
        /** Создаем объект для взаимодействия в консоли */
        ConsoleView consoleView = new ConsoleView(trafficLight);
        /** Запускаем взаимодействия в консоли с пользователем */
        consoleView.start();
    }
}
