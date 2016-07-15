package io.khasang.controller;

import io.khasang.controller.exceptions.NegativeValueException;
import io.khasang.model.TrafficLight;

/**
 * Класс, который обрабатывает введеные данные пользователем.
 * @author alexey_n
 */
public class InputController {
    /**
     * Метод обрабатывает введеные данные от пользователя, и если все хорошо, передает данные в светофор
     * @throws NegativeValueException Исключение возникает при отрицательном значении
     * @throws NumberFormatException Исключение возникает если нельза получить числовое значение из строки
     * @param enteredValue Время работы светофора
     * @param trafficLight Объект светофора
     */
    public void checkValue(String enteredValue, TrafficLight trafficLight) throws NegativeValueException{
        int time = Integer.parseInt(enteredValue);
        if (time < 0) {
            throw new NegativeValueException();
        }
        trafficLight.setTime(time);
    }
}
