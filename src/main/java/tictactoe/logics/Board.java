package tictactoe.logics;

import java.util.Arrays;

public class Board {
    private static final int DEFAULT_SIZE = 3;
    private static final char EMPTY_FIELD = ' ';

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

}
