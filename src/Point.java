import java.io.Serializable;

    // Point is a class which returnS the coordinates of the mouse.

public class Point implements Serializable {

    public int X;
    public int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return ("X=" + getX() + "and Y=" + getY());
    }


    public static void main(String[] args) {
    }
}