package io.hexlet.xo.model;

import io.hexlet.xo.model.exception.AlreadyOccupiedException;
import io.hexlet.xo.model.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;


public class FieldTest {
    @Test
    public void getSize() throws Exception {

        final Field field = new Field();

        assertEquals(3, field.getSize());

    }

    @Test
    public void setFigure() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureIsNotSet() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenXIsLessThenZero() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {

            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYIsLessThenZero() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,-1);

        try {

            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenXMoreSize() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);

        try {

            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void getFigureWhenYMoreSize() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {

            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void setFigureWhenAlreadyOccupited() throws Exception {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final  Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupiedException e) {}


    }

}