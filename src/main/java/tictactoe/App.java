package tictactoe;

import tictactoe.console.BoardOutput;
import tictactoe.console.ConsoleInput;
import tictactoe.logics.Board;
import tictactoe.logics.BotPlayer;
import tictactoe.logics.CheckResultOfTurn;
import tictactoe.logics.Point;

public class App {

    private static final char X = 'X';
    private static final char O = 'O';

    public static void main(String[] args) {

        ConsoleInput coordinateX = new ConsoleInput();
        ConsoleInput coordinateY = new ConsoleInput();
        boolean winnerPlayer = false;
        boolean winnerBot = false;
        int counter = 0;
        Board newBoard = new Board();
        BoardOutput boardOutput = new BoardOutput();
        int sizeBoard = newBoard.getSize();
        boardOutput.toConsole(newBoard);
        Point point = new Point();
        BotPlayer botPlayer = new BotPlayer(newBoard);
        CheckResultOfTurn checkResult = new CheckResultOfTurn(newBoard);
        System.out.println("Your figure is X, mine is O. Let's begin!");
        do {
            counter++;
            System.out.println("Enter the coordinates of the position where you want to place the figure:");
            System.out.println("—— Horizontally axis : ");
            point.setPointX(coordinateX.inputDigit());
            System.out.println("| Vertically axis : ");
            point.setPointY(coordinateY.inputDigit());
            newBoard.setFigure(point, X);
            if (counter > 2) {
                winnerPlayer = checkResult.hasThreeInRowMiddle(point, X);
            }
            boardOutput.toConsole(newBoard);
            if (!winnerPlayer && counter <= sizeBoard * sizeBoard / 2) {
                point = botPlayer.setFigure();
                System.out.println("OK, my turn ->");
                newBoard.setFigure(point, O);
                boardOutput.toConsole(newBoard);
                if (counter > 2) {
                    winnerBot = checkResult.hasThreeInRowMiddle(point, O);
                }
            }
        } while(!winnerPlayer && !winnerBot && (counter <= sizeBoard * sizeBoard /2 ));
        if (winnerPlayer) {
            System.out.println("Congratulation, you are winner!");
        } else if (winnerBot) {
            System.out.println("Ups, you are loser!");
        } else {
            System.out.println("It's a draw!");
        }
    }

}
