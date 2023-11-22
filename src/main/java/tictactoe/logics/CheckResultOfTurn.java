package tictactoe.logics;

public class CheckResultOfTurn {

    Board board;
    int size;
    public CheckResultOfTurn(Board board) {
        this.board = board;
        this.size = board.getSize();
    }

    public boolean hasThreeInRowMiddle(Point point, char figure) {
        int coordinateX = point.getPointX();
        int coordinateY = point.getPointY();
        return checkIfTurnInMiddle(coordinateX, coordinateY, figure) ||
                checkIfTurnInEdge(coordinateX, coordinateY, figure);
    }

    private boolean checkIfTurnInMiddle (int coordinateX, int coordinateY, char figure) {
        boolean checkFirstCircle = false;
        checkFirstCircle = theSameFigure(coordinateX - 1, coordinateY, coordinateX + 1, coordinateY,figure);
        if (checkFirstCircle) {
            return true;
        }
        for (int i = -1; i < 2; i++) {
            checkFirstCircle = theSameFigure(coordinateX + i, coordinateY - 1,coordinateX - i, coordinateY + 1, figure);
            if (checkFirstCircle) {return true;}
        }
        return false;
    }
    private boolean checkIfTurnInEdge (int coordinateX, int coordinateY, char figure) {
        boolean checkSecondCircle = false;
        for (int j = -1; j < 2; j = j + 2) {
            checkSecondCircle = theSameFigure(coordinateX, coordinateY + 2 * j, coordinateX, coordinateY + j, figure);
            if (checkSecondCircle) {
               return true;
            }
            for (int i = -1; i < 2; i++) {
                checkSecondCircle = theSameFigure(coordinateX + j, coordinateY + i,coordinateX + 2 * j, coordinateY + 2 * i,  figure);
                if (checkSecondCircle) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean theSameFigure(int coordinate1X, int coordinate1Y, int coordinate2X, int coordinate2Y,char figure) {
        return hasPairPoints(coordinate1X, coordinate1Y, coordinate2X, coordinate2Y) &&
                (board.getFigure(new Point(coordinate1X, coordinate1Y)) == figure) &&
                (board.getFigure(new Point(coordinate2X, coordinate2Y)) == figure);
    }
    private boolean hasPairPoints(int point1X, int point1Y, int point2X, int point2Y) {
        return hasCoordinate(point1X) && hasCoordinate(point1Y) &&
                hasCoordinate(point2X) && hasCoordinate(point2Y);
    }
    private boolean hasCoordinate(int coordinate) {
        return (coordinate > 0) &&( coordinate <= size);
    }

}
