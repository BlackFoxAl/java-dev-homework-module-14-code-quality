package tictactoe.console;

import java.util.Scanner;

public class ConsoleInput {

    private static final int DEFAULT_LIMIT_VALUE = 3;

    private int limitValue;

    public ConsoleInput() {
        setLimitValue(DEFAULT_LIMIT_VALUE);
    }

    public int getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(int limitValue) {
        this.limitValue = limitValue;
    }


    public int inputDigit() {
        System.out.print("Enter a number from 1 to " + limitValue + " : ");
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNextInt()) {
                int scanDigit = scan.nextInt();
                if (scanDigit  > 0 &&  scanDigit <= limitValue) {
                    return scanDigit;
                }
            } else {
                scan.next();
            }
            System.out.print("Wrong! Enter a number from 1 to " + limitValue + " : ");
        }
    }

}
