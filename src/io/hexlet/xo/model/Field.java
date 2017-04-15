package io.hexlet.xo.model;


import io.hexlet.xo.model.exceptions.InvalidPointException;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int filedSize;

    public Field(final int filedSize) {
        this.filedSize = filedSize;
        field = new Figure[filedSize][filedSize];
    }

    public int getSize() {
        return filedSize;
    }

    public Figure getFigure(final Point point) {
        if (checkPoint(point)) {
            return field[point.getX()][point.getY()];
            //throw new InvalidPointException();
        } else {
            System.out.print("Wrong point! " + point.getX() + " " + point.getY());
            return null;
        }
    }

    public void setFigure(final Point point, final Figure figure) {
        if (checkPoint(point)) {
            field[point.getX()][point.getY()] = figure;
            //throw new InvalidPointException();
        } else {
            System.out.println("Wrong point!");
        }
    }

    private boolean checkPoint(final Point point) {
        boolean Result = checkCoordinate(point.getX(), filedSize) && checkCoordinate(point.getY(), filedSize);
        return Result;
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate <= maxCoordinate;
    }
}

