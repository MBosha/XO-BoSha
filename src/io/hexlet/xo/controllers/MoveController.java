package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;


public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws AlreadyOccupiedException, InvalidPointException {
        if (field.getFigure(point) != null) {
            System.out.println("Field busy!");
        } else {
            field.setFigure(point, figure);
        }

    }

}
