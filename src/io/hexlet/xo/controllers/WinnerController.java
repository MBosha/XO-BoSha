package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

public class WinnerController {

  public Figure getWinner(final Field field) throws InvalidPointException {

    final int fieldSize = field.getSize();
    //Figure firstFigure;
    Figure currentFigure;
    Figure nextFigure;
    int Counter = 0;

    //проверка горизонтали
    for (int x = 0; x < fieldSize; x++) {
        Figure firstFigure = field.getFigure(new Point(x, 0));
        if (firstFigure == null) {
            break;
        }
        Counter = 0;
        for (int y = 0; y < fieldSize - 1; y++) {
            currentFigure = field.getFigure(new Point(x, y));
            nextFigure = field.getFigure(new Point(x, y + 1));
            if (nextFigure == null) {
                break;
            }
            if (currentFigure == nextFigure) {
                Counter++;
            }
        }
        if (Counter == fieldSize - 1) {
            return firstFigure;
        }
    }
    //проверка вертикали
    for (int y = 0; y < fieldSize; y++) {
        Figure firstFigure = field.getFigure(new Point(0, y));

        if (firstFigure == null) {
            break;
        }
        Counter = 0;
        for (int x = 0; x < fieldSize - 1; x++) {
            currentFigure = field.getFigure(new Point(x, y));
            nextFigure = field.getFigure(new Point(x, y + 1));
            if (nextFigure == null) {
                break;
            }
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
        Figure firstFigure = field.getFigure(new Point(0, 0));
        if (firstFigure == null) {
            break;
        }

        currentFigure = field.getFigure(new Point(i, i));
        nextFigure = field.getFigure(new Point(i + 1, i + 1));
        if (nextFigure == null) {
            break;
        }
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
        Figure firstFigure = field.getFigure(new Point(0, fieldSize - 1));
        if (firstFigure == null) {
            break;
        }
        currentFigure = field.getFigure(new Point(fieldSize - i, i));
        nextFigure = field.getFigure(new Point(fieldSize - i - 1, i - 1));
        if (nextFigure == null) {
            break;
        }
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
