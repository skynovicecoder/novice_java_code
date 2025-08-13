package practice.games.SnakeAndLadder;

import java.util.List;

public class Board {
    int board;
    List<Ladder> ladders;
    List<Snake> snakes;

    public Board(int board, List<Ladder> ladders, List<Snake> snakes){
        this.board = board;
        this.ladders = ladders;
        this.snakes = snakes;
    }

    public int  getSize(){
        return board;
    }

    public int checkLadderAndSnake(int position){
        for(Ladder ladder: ladders){
            if(ladder.getStart()==position){
                return ladder.getEnd();
            }
        }

        for(Snake snake: snakes){
            if(snake.getStart()==position){
                return snake.getEnd();
            }
        }

        return position;
    }


}
