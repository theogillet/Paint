import java.awt.*;

public class Circle extends Ellipse{

    public Circle(int px, int py, Color c){
        super(px, py, c);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        int max = Math.max(heightBB, widthBB);
        int min = Math.min(heightBB, widthBB);
        if (heightBB > 0 && widthBB > 0) {
            super.semiAxisX = max;
            super.semiAxisY = max;
        } else if (heightBB > 0 && widthBB < 0) {
            if (Math.abs(min) > Math.abs(max)) {
                super.semiAxisX = min;
                super.semiAxisY = -min;
            } else {
                super.semiAxisX = -max;
                super.semiAxisY = max;
            }
        } else if (heightBB < 0 && widthBB > 0) {
            if (Math.abs(min) > Math.abs(max)) {
                super.semiAxisX = -min;
                super.semiAxisY = min;
            } else {
                super.semiAxisX = max;
                super.semiAxisY = -max;
            }
        } else {
            super.semiAxisX = min;
            super.semiAxisY = min;
        }
    }
}
