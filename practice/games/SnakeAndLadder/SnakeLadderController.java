package practice.games.SnakeAndLadder;

import java.util.Arrays;
import java.util.List;

public class SnakeLadderController {
    public static void main(String[] args){
        int boardSize = 100;
        List<Player> players = List.of(
                new Player("Sonil"),
                new Player("Sky"),
                new Player("Rocky"),
                new Player("Sonu")
        );

        List<Snake> snakes = Arrays.asList(
                new Snake(99, 54),
                new Snake(70, 55),
                new Snake(52, 42),
                new Snake(25, 2)
        );
        List<Ladder> ladders = Arrays.asList(
                new Ladder(6, 25),
                new Ladder(11, 40),
                new Ladder(60, 85),
                new Ladder(46, 90)
        );
        Dice dice = new Dice(6);
        Board board = new Board(boardSize,ladders, snakes);
        GameService gameService = new GameService(board, players, dice);
        gameService.start();

    }
}
