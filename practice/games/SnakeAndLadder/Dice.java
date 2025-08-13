package practice.games.SnakeAndLadder;

import java.util.Random;

public class Dice {
    int sides;
    Random rand;

    public Dice(int sides) {
        this.sides = sides;
        this.rand = new Random();
    }

    public int getSides() {
        return sides;
    }

    public int getRoll() {
        return rand.nextInt(sides)+1;
    }

}
