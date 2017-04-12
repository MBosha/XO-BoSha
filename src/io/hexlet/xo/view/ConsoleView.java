package io.hexlet.xo.view;


import io.hexlet.xo.controllers.*; //CurrentMoveController;
//import io.hexlet.xo.controllers.MoveController;
//import io.hexlet.xo.controllers.WinnerController;
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

    public void show(final Game game) {

        System.out.format("Game name:%s\n", game.getName());
        final Field field = new Field(3);
        for (int x = 0; x < field.getSize(); x++) {

            if (x > 0) {
                printSeparator();
            }
            printLine(field, x);
        }
        //printSeparator();


    }

    public boolean move(final Game game) {

        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            Figure winner = null;
            try {
                winner = winnerController.getWinner(field);
            } catch (InvalidPointException e) {
                e.printStackTrace();
            } catch (AlreadyOccupiedException e) {
                e.printStackTrace();
            }
            if (winner == null) {

                System.out.print("No winner! No move lefts!");
                return false;
            } else {

                System.out.format("Winner is: %s\n", winner);
                return false;
            }

            System.out.println("Please enter move point for: " + currentFigure.);
            try {
                moveController.applyFigure(field, askPoint(), currentFigure);
            } catch (InvalidPointException | AlreadyOccupiedException e) {
                e.printStackTrace();
                System.out.println("Point is invalid!");
            }
            return true;
        }
        return false;
    }

    private void printLine(final Field field, final int x) {

        //printSeparator();
        //System.out.print("|");
        for (int y = 0; y < field.getSize(); y++) {

            Point point = new Point(x, y);
            final Figure figure;
            try {
                figure = field.getFigure(point);
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
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

    private int askCoordinate(final String coordinateName) {

        System.out.format("Please input %s/n", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public final Point askPoint() {

        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }
}
