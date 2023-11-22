package tictactoe.console;

import tictactoe.logics.Board;
import tictactoe.logics.Point;

public class BoardOutput {
    private static final String VERTICAL_FIELD_SEPARATOR = " │ ";
    private static final String TWO_SPACES = " ".repeat(2);
    private static final String TREE_SPACES = " ".repeat(3);

    public void toConsole(Board board) {
        StringBuilder boardField = new StringBuilder();
        int size = board.getSize();
        for (int horCounter = 0; horCounter <= size; horCounter++) {
            for (int verCounter = 1; verCounter <= size; verCounter++) {
                if(horCounter == 0) {
                    boardField.append(TREE_SPACES).append(verCounter);
                } else {
                    if(verCounter == 1) {
                        boardField.append(horCounter).append(TWO_SPACES);
                    }
                    boardField.append(board.getFigure(new Point(verCounter,horCounter)));
                    if (verCounter != size ) {
                        boardField.append(VERTICAL_FIELD_SEPARATOR);
                    }
                }
            }
            boardField.append("\n");
        }
        System.out.println(boardField);
    }

}
