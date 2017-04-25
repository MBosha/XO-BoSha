package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;


public class WinnerControllerTest {
    @Test
    public void getWinnerHor() throws Exception {
        final  WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }

    }

}