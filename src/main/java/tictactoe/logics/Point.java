package tictactoe.logics;

public class Point {
    private int pointX;
    private int pointY;
    public Point() {
        this.pointX = 0;
        this.pointY = 0;
    }
    public Point(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }
    @Override
    public String toString() {
        return "X " + pointX +" : Y " + pointY;
    }

}
