package io.khasang.controller;

/**
 * Created by alexey_n on 15.07.2016.
 */
public class InputController {
    public int checkValue(String enteredValue) throws NumberFormatException {
        int time = Integer.parseInt(enteredValue);
        return time;
    }
}
