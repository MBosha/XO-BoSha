package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Figure figure,
                            final Point point,
                            final Field field) throws InvalidPointException, AlreadyOccupiedException {

        if (field.getFigure(point) != null) {

            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);


    }
}
