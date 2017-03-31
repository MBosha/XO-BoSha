package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {

        try {

            //проверка горизонталей
            for (int i = 0; i < field.getSize(); i++) {

                if (check(field, new Point(i, 0), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x, point.y + 1);
                    }
               }))
               return field.getFigure(new Point(i, 0));
            }

            //проверка вертикалей
            for (int i = 0; i < field.getSize(); i++) {

                if (check(field, new Point(0, i), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1, point.y);
                    }
                }))
                    return field.getFigure(new Point(0, i));
            }

            //проверка главной диагонали
            for (int i = 0; i < field.getSize(); i++) {

                if (check(field, new Point(0, 0), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1, point.y + 1);
                    }
                }))
                    return field.getFigure(new Point(0, 0));
            }

            //проверка побочной диагонали
            for (int i = 0; i < field.getSize(); i++) {

                if (check(field, new Point(0, field.getSize()), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1, point.y - 1);
                    }
                }))
                    return field.getFigure(new Point(0, field.getSize()));
            }

            if (field.getFigure(new Point(0, 0)) == (field.getFigure(new Point(0, 1))) &&
                    field.getFigure(new Point(0, 0)) == (field.getFigure(new Point(0, 2)))) {
                return field.getFigure(new Point(0, 0));
            }
            } catch (InvalidPointException e) {
                e.printStackTrace();
                return null;
        }

        private boolean check(final Field field1, final Point startPoint, IPointChanger pointChanger) {

            final Point p1 = startPoint;

            final Point p2 = pointChanger.next(p1);

            final Point p3 = pointChanger.next(p2);

            return false;
        }

        private interface IPointChanger {

            Point next(final Point point);
        }



    }
}
