package tictactoe.logics;

import java.util.Random;

public class BotPlayer {

    private Board board;
    public BotPlayer(Board board) {
        this.board = board;
    }
    public Point setFigure() {
        Point point = new Point();
        int sizeBoard = board.getSize();
        int bestPlace = sizeBoard/2 + 1;
        point.setPointX(bestPlace);
        point.setPointY(bestPlace);
        if (board.placeAvailable(point)) {
            return point;
        }
        Random random = new Random();
        while (true) {

            point.setPointX(random.nextInt(sizeBoard) + 1);

            point.setPointY(random.nextInt(sizeBoard) + 1);
            if (board.placeAvailable(point)) {
                return point;
            }
        }
    }

}
