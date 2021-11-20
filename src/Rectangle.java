import java.awt.*;

public class Rectangle extends Figure {
    public int width=0;
    public int length=0;

    public Rectangle(int px, int py, Color c){
        super(c, new Point(px,py));
    }

    // Here we want to define length and width in order to draw in the fourth direction.
    // So, because the bounding box is a rectangle, we can recuperate length and width as the sizes and
    // test the four cases possible to draw in the right directions.
    // It is the same thing for the Ellipse Class but with semiAxisX and semiAxisY instead of length and width.

    public int getWidth() {
        return this.width;
    }
    public int getLength() {
        return this.length;
    }

    @Override
    public void setBoundingBox (int lengthBB, int widthBB){
        length = lengthBB;
        width = widthBB;
    }

    @Override
    public void draw(Graphics g) {
        Color c = this.getC();
        int px = this.getP().getX();
        int py = this.getP().getY();
        int width = this.getWidth();
        int length = this.getLength();
        g.setColor(c);
        if (width > 0 && length > 0) {
            g.fillRect(px, py, width, length);
        } else if (width > 0 && length < 0) {
            g.fillRect(px, py + length, width, -length);
        } else if (width < 0 && length > 0) {
            g.fillRect(px + width, py, -width, length);
        } else {
            g.fillRect(px + width, py + length, -width, -length);
        }

    }

    public static void main(String[] args) {
    }
}
