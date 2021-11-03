import java.awt.*;

public class Square extends Rectangle {
    public Square(int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        int max = Math.max(heightBB, widthBB);
        int min = Math.min(heightBB, widthBB);
        if (heightBB > 0 && widthBB > 0) {
            super.width = max;
            super.length = max;
        } else if (heightBB > 0 && widthBB < 0) {
            if (Math.abs(min) > Math.abs(max)) {
                super.width = min;
                super.length = -min;
            } else {
                super.width = -max;
                super.length = max;
            }
        } else if (heightBB < 0 && widthBB > 0) {
            if (Math.abs(min) > Math.abs(max)) {
                super.width = -min;
                super.length = min;
            } else {
                super.width = max;
                super.length = -max;
            }
        } else {
            super.width = min;
            super.length = min;
        }

    }
}
