package tictactoe.logics;

import java.util.Arrays;

public class Board {
    private static final int DEFAULT_SIZE = 3;
    private static final char EMPTY_FIELD = ' ';
    private static final String VERTICAL_FIELD_SEPARATOR = " │ "; //vertical field separator
    private static final String TWO_SPACES = " ".repeat(2);
    private static final String TREE_SPACES = " ".repeat(3);
    private static final char HORIZONTAL_LINE = '—';
    private static final char CROSS_LINE = '┼';
    private int size;
    private final char[][] field;

    public Board() {
        setSize(DEFAULT_SIZE);
        field = new char[size][size];
        clearBoard();
    }
    Board(int size) {
        setSize(size);
        field = new char[size][size];
        clearBoard();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void clearBoard() {

        for (char[] chars : field) {
            Arrays.fill(chars, EMPTY_FIELD);
        }
    }
    public char getFigure(Point point) {
        return field[point.getPointY() - 1][point.getPointX() - 1];
    }

    public void setFigure(Point point, char figure) {
        this.field[point.getPointY() - 1][point.getPointX() - 1] = figure;

    }

    public boolean placeAvailable(Point point) {
        return field[point.getPointY() - 1][point.getPointX() - 1] == EMPTY_FIELD;
    }
    public boolean gameOver(Point point,char figure) {
        return false;
    }

    public boolean resultOfMove(Point point,char figure) {
        int coordinateX = point.getPointX()-1;
        int coordinateY = point.getPointY()-1;
        boolean checkFirstCircle = false;
        boolean checkSecondCircle = false;
        if (hasPairPoints(coordinateX - 1, coordinateY, coordinateX + 1, coordinateY)) {
            checkFirstCircle = (field[coordinateY][coordinateX - 1] == figure) && (field[coordinateY][coordinateX + 1] == figure);
            if (checkFirstCircle) {
                return true;
            }
        }
        for (int j = -1; j < 2; j = j + 2) {
            for (int i = -1; i < 2; i++) {
                if (hasPairPoints(coordinateX + i, coordinateY - 1, coordinateX - i, coordinateY + 1)) {
                    checkFirstCircle = (field[coordinateY - 1][coordinateX + i] == figure) && (field[coordinateY + 1][coordinateX - i] == figure);
                    if (checkFirstCircle) {
                        return true;
                    }
                }
                if (hasPairPoints(coordinateX + j, coordinateY + i, coordinateX + 2 * j, coordinateY + 2 * i)) {
                    checkSecondCircle = (field[coordinateY + i][coordinateX + j] == figure) && (field[coordinateY + 2 * i][coordinateX + 2 * j] == figure);
                    if (checkSecondCircle) {
                        return true;
                    }
                }
            }
            if (hasPairPoints(coordinateX, coordinateY + 2 * j, coordinateX, coordinateY + j)) {
                checkSecondCircle = (field[coordinateY + 2 * j][coordinateX] == figure) && (field[coordinateY + j][coordinateX] == figure);
                if (checkSecondCircle) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPairPoints(int point1X, int point1Y, int point2X, int point2Y) {
        return hasCoordinate(point1X) && hasCoordinate(point1Y) &&
                hasCoordinate(point2X) && hasCoordinate(point2Y);
         }
    public boolean hasCoordinate(int coordinate) {
        return (coordinate >= 0) &&( coordinate < size);
    }


    @Override
    public String toString() {

        StringBuilder boardField = new StringBuilder();
        for (int horCounter = 0; horCounter <= size; horCounter++) {
            for (int verCounter = 1; verCounter <= size; verCounter++) {
                if(horCounter == 0) {
                    boardField.append(TREE_SPACES).append(verCounter);
                } else {
                    if(verCounter == 1) {
                        boardField.append(horCounter).append(TWO_SPACES);
                    }
                    boardField.append(field[horCounter - 1][verCounter - 1]);
                    if (verCounter != size ) {
                        boardField.append(VERTICAL_FIELD_SEPARATOR);
                    }
                }
            }
            boardField.append("\n");
        }
        return boardField.toString();
    }
}
