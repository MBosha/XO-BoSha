package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

public class WinnerController {

  public WinnerController() {

    public static Figure getWinner(final Field field) /*throws InvalidPointException, AlreadyOccupiedException*/ {

        final int fieldSize = field.getSize();
        Figure firstFigure;
        Figure currentFigure;
        Figure nextFigure;
        int Counter;
        //вертикали
        Counter = 0;
        for (int i = 0; i < fieldSize; i++) {
            firstFigure = field.getFigure(new Point(i, 0));
            if (firstFigure == null) {
                break;
            }
            for (int j = 0; j < fieldSize - 1; j++) {
                currentFigure = field.getFigure(new Point(i, j));
                nextFigure = field.getFigure(new Point(i, j + 1));
                if (currentFigure == nextFigure) {
                    Counter++;
                }
            }
            if (Counter == fieldSize - 1) {
                return firstFigure;
            }
        }
        //горизонтали
        Counter = 0;
        for (int i = 0; i < fieldSize; i++) {
            firstFigure = field.getFigure(new Point(0, i));
            if (firstFigure == null) {
                break;
            }
            for (int j = 0; j < fieldSize - 1; j++) {
                currentFigure = field.getFigure(new Point(j, i));
                nextFigure = field.getFigure(new Point(j, i + 1));
                if (currentFigure == nextFigure) {
                    Counter++;
                }
            }
            if (Counter == fieldSize - 1) {
                return firstFigure;
            }
        }

        //главная диагональ
        Counter = 0;
        for (int i = 0; i < fieldSize - 1; i++) {
            firstFigure = field.getFigure(new Point(0, 0));
            if (firstFigure == null) {
                break;
            }
            currentFigure = field.getFigure(new Point(i, i));
            nextFigure = field.getFigure(new Point(i + 1, i + 1));
            if (currentFigure == nextFigure) {
                Counter++;
            }
            if (Counter == fieldSize - 1) {
                return firstFigure;
            }
        }
        //побочная диагональ
        Counter = 0;
        for (int i = 0; i < fieldSize - 1; i++) {
            firstFigure = field.getFigure(new Point(0, fieldSize));
            if (firstFigure == null) {
                break;
            }
            currentFigure = field.getFigure(new Point(fieldSize - i, i));
            nextFigure = field.getFigure(new Point(fieldSize - i - 1, i - 1));
            if (currentFigure == nextFigure) {
                Counter++;
            }
            if (Counter == fieldSize - 1) {
                return firstFigure;
            }
        }
        return null;
      }
    }
}
