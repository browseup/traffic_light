package io.khasang.view;

import io.khasang.controller.InputController;
import io.khasang.controller.exceptions.NegativeValueException;
import io.khasang.model.Color;
import io.khasang.model.TrafficLight;

import java.util.Scanner;

/**
 * Класс описывает визуальное взаимодействие с пользователем
 * @author alexey_n
 */
public class ConsoleView {
    /** Контроллер, для обработки введеных данных пользователем */
    private final InputController inputController = new InputController();
    /** Объект светофор */
    private final TrafficLight trafficLight;

    /**
     * Создает объект класса для визуального взаимодействия с пользователем
     * @param trafficLight Светофор
     */
    public ConsoleView(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    /**
     * Запускает работу взаимодействия с пользователем
     */
    public void start() {
        getEnteredValue();
        showCurrentSignalAndCurrentTimeSignal();
    }

    /**
     * Получаем значение времени от пользователя
     */
    private void getEnteredValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("На какой минуте Вы хотите узнать состояние сфетофора ?");
        String enteredValue = sc.nextLine();
        try {
            inputController.checkValue(enteredValue, trafficLight); //todo Добавить проверку на отрицательное число и размер числа
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели число с ошибкой или оно превышает 2_147_483_647. Попробуйте еще раз.");
            getEnteredValue();
        } catch (NegativeValueException e) {
            System.out.println("Число не должно быть отрицательным. Попробуйте еще раз.");
            getEnteredValue();
        }
    }

    /**
     * Отображение результата работы в консоли
     */
    private void showCurrentSignalAndCurrentTimeSignal() {
        int currentIndexSignal = trafficLight.getCurrentIndexSignal();
        int currentTimeSignal = trafficLight.getCurrentTimeSignal();
        Color currentColor = trafficLight.getCurrentColor();
        System.out.printf("Сейчас горит %s цвет, на %d минуте. Для справки - это %d цвет в списке светофора.", currentColor, currentTimeSignal, currentIndexSignal + 1);
    }
}
