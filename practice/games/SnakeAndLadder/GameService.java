package practice.games.SnakeAndLadder;

import java.util.List;

public class GameService {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private boolean gameOver = false;

    public GameService(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
    }

    public void start() {
        while (!gameOver) {
            for (Player player : players) {
                takeTurn(player, board, dice);
                if (isWinner(player)) {
                    System.out.println("Player name: " + player.getName() + " won the match ...!!!");
                    gameOver = true;
                    break;
                }
            }
        }

    }

    public void takeTurn(Player player, Board board, Dice dice) {
        System.out.println("Player name: " + player.getName() + " current position :" + player.getPosition());
        int diceDisplay = dice.getRoll();
        System.out.println("Player name: " + player.getName() + " rolled and on dice got :" + diceDisplay);

        int newPos = player.getPosition() + diceDisplay;

        if (newPos > board.getSize()) {
            System.out.println(player.getName() + " cannot move, needs exact roll.");
            return;
        }

        newPos = board.checkLadderAndSnake(newPos);
        player.setPosition(newPos);
        System.out.println("Player name: " + player.getName() + " current position after rolling dice :" + player.getPosition());

    }

    private boolean isWinner(Player player) {
        return player.getPosition() == board.getSize();
    }
}
