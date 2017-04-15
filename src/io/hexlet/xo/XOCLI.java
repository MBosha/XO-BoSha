package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {
    //здесь написаен код
    public static void main(final  String[] args) {

        final String name1 = "BoSha";
        final String name2 = "MiSha";
        boolean loop = true;

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);


        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);

        while (consoleView.move(gameXO)) {

            consoleView.show(gameXO);
        }
    }
}

