package tictactoe.logics;

public class BotPlayer {

    private Board board;
    public BotPlayer(Board board, char figure) {
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
        while (true) {
            point.setPointX((int)(Math.random() * sizeBoard) + 1);
            point.setPointY((int)(Math.random() * sizeBoard) + 1);
            if (board.placeAvailable(point)) {
                return point;
            }
        }
    }
}
