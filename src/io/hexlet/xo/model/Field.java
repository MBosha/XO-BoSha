package io.hexlet.xo.model;


import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int fieldSize;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }


    public int getSize() {

        return field.length;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {

        if (!chekPoint(point)) {

            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {

        if (!chekPoint(point)) {

            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean chekPoint (final Point point) {

        return chekCoordinate(point.x, field.length) && chekCoordinate(point.y, field[point.x].length);
    }

    private boolean chekCoordinate (final int coordinate, final int maxCoordinate) {

        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
