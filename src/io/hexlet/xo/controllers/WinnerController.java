package io.hexlet.xo.controllers;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.InvalidPointException;

@SuppressWarnings("ALL")
public class WinnerController {


    @SuppressWarnings("ControlFlowStatementWithoutBraces")
    public Figure getWinner(final Field field) {
        final int fieldSize = field.getSize();
        try {
            for (int i = 0; i < fieldSize; i++)
                if (check(field, new Point(i, 0), (Point point) -> new Point(point.getX(), point.getY() + 1)))
                    return field.getFigure(new Point(i, 0));

            for (int i = 0; i < fieldSize; i++)
                if (check(field, new Point(0, i), point -> new Point(point.getX() + 1, point.getY())))
                    return field.getFigure(new Point(0, i));

            if (check(field, new Point(0, 0), point -> new Point(point.getX() + 1, point.getY() + 1)))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, fieldSize - 1), point -> new Point(point.getX() + 1, point.getY() - 1)))
                return field.getFigure(new Point(0, fieldSize - 1));

        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null)
                return false;

            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (currentFigure != nextFigure) {
            return false;
        }

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {

        Point next(final Point point);

    }

}