import java.awt.*;
import java.io.Serializable;

    // Figure is a Class where we define the methods to well-draw a figure.

public abstract class Figure implements Serializable {

    public Color c;
    protected Point point;

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
