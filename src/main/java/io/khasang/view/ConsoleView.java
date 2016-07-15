package io.khasang.view;

import io.khasang.controller.InputController;
import io.khasang.model.Color;
import io.khasang.model.TrafficLight;

import java.util.Scanner;

/**
 * Created by alexey_n on 15.07.2016.
 */
public class ConsoleView {
    private final InputController inputController = new InputController();
    private final TrafficLight trafficLight;
    private int time;

    public ConsoleView(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void start() {
        getEnteredValue();
        showCurrentSignalAndCurrentTimeSignal();
    }

    private void getEnteredValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("На какой минуте Вы хотите узнать состояние сфетофора ?");
        String enteredValue = sc.nextLine();
        try {
            time = inputController.checkValue(enteredValue); //todo Добавить проверку на отрицательное число и размер числа
        } catch (NumberFormatException e) {
            System.out.println("Сосредоточьтесь. Нужно ввести число.");
            getEnteredValue();
        }
        trafficLight.setTime(time);
    }

    private void showCurrentSignalAndCurrentTimeSignal() {
        int currentIndexSignal = trafficLight.getCurrentIndexSignal();
        int currentTimeSignal = trafficLight.getCurrentTimeSignal();
        Color currentColor = trafficLight.getCurrentColor();
        System.out.printf("Сейчас горит %s цвет, на %d минуте. Для справки - это %d цвет в списке светофора.", currentColor, currentTimeSignal, currentIndexSignal + 1);
    }
}
