import java.io.Serializable;

public class Point implements Serializable {

    public int X;
    public int Y;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public Point() {
        int X = 0;
        int Y = 0;
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