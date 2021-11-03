import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {

    public Color c;
    protected Point point;
    protected int semiAxisX;
    protected int semiAxisY;
    protected int length;
    protected int width;

    public int getSemiAxisX() {
        return this.semiAxisX;
    }

    public int getSemiAxisY() {
        return this.semiAxisY;
    }

    public abstract void setBoundingBox (int length, int width);
    public abstract void draw (Graphics g);

    public Color getC() {
        return this.c;
    }

    public Point getP() {
        return this.point;
    }

    public Figure(Color c, Point point) {
        this.c = c;
        this.point = point;
    }


    @Override
    public String toString() {
        return "Figure{}";
    }

    public static void main(String[] args) {
    }

}
