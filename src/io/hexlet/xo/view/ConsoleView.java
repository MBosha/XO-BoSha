package io.hexlet.xo.view;


import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Point;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    public final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();
    private Figure winner;

    public void show(final Game game) {

        Field showField = game.getField();

        System.out.format("Game name: %s\n", game.getName());
        try {
            if (winner == null) {
                System.out.format("Step figure: %s\n", currentMoveController.currentMove(game.getField()));
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        //final Field field = new Field(3);
        for (int x = 0; x < showField.getSize(); x++) {

            if (x > 0) {
                printSeparator();
            }
                printLine(game.getField(), x);

        }
        //printSeparator();


    }

    public boolean move(final Game game) {

        final Field field = game.getField();
        Figure currentFigure = Figure.X;
        try {
            currentFigure = currentMoveController.currentMove(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        try {
        winner = winnerController.getWinner(field);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }


        if (winner == null & currentFigure == null) {
            System.out.print("No winner! No move lefts!");
            return false;
        } else if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        try {
            moveController.applyFigure(field, askPoint(), currentFigure);
        } catch (AlreadyOccupiedException e) {
            e.printStackTrace();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return true;
    }

    private void printLine(final Field field, final int x) {

        //printSeparator();
        //System.out.print("|");
        for (int y = 0; y < field.getSize(); y++) {
            Point point = new Point(x, y);
            Figure figure;
            figure = field.getFigure(point);

            System.out.print(" ");
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
            if (y != field.getSize() - 1) {
                System.out.print("|");
            }
        }
        System.out.println();
    }

    private void printSeparator() {

        System.out.println("-----------");
    }

    private int askCoordinate(final String coordinateName) throws InvalidPointException {

        System.out.format("Please input %s:\n", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        int step = 0;
        try {
            step = scanner.nextInt();
        } catch (Exception e) {

            System.out.println("Wrong symbol!");
            //e.printStackTrace();
        }
        return step;
    }

    public final Point askPoint() throws InvalidPointException {

            return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }
}
