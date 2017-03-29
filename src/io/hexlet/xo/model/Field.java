package io.hexlet.xo.model;


import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private static int FIELD_SIZE = 3;

    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {

        return field.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {

        if (!chekPoint(point)) {

            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {

        if (!chekPoint(point)) {

            throw new InvalidPointException();
        }

        if (field[point.x][point.y] != null) {

            throw new AlreadyOccupiedException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean chekPoint (final Point point) {

        return chekCoordinate(point.x) && chekCoordinate(point.y);
    }

    private boolean chekCoordinate (final int coordinate) {

        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

}
