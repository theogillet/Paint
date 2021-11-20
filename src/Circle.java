import java.awt.Color;

public class Circle extends Ellipse {

    public Circle(int px, int py, Color c){
        super(px, py, c);
    }

    // Here we want to define semiAxisX and semiAxisY in order to draw in the fourth direction.
    // So, because the bounding box is a square, we can take the max in absolute
    // value as the length and the width, while keeping the sign of the values to define the directions.
    // It is the same thing for the Square Class.

    public void setBoundingBox(int heightBB, int widthBB) {
        int max = Math.max(heightBB, widthBB);
        int min = Math.min(heightBB, widthBB);
        int signheight = (int) Math.signum(heightBB);
        int signwidth = (int) Math.signum(widthBB);
        if (Math.abs(min) > Math.abs(max)) {
            super.semiAxisX = signwidth*Math.abs(min);
            super.semiAxisY = signheight*Math.abs(min);
        } else {
            super.semiAxisX = signwidth*Math.abs(max);
            super.semiAxisY = signheight*Math.abs(max);
        }
    }
}
