import java.awt.*;

    // Because I would like to delete in case of mistake during my drawing, I created the Eraser class
    // which permits erasing by drawing small white circles when we click.
    // I used the Figure Class here because it was more simple to draw circles with all its methods like
    // setBoundingBox and draw.

public class Eraser extends Figure{

    public Eraser(int px, int py){
        super(Color.WHITE, new Point(px, py));
    }

    protected int semiAxisX = 20;
    protected int semiAxisY = 20;

    @Override
    public void setBoundingBox(int length, int width) {
    }

    public void draw(Graphics g) {
        int px = this.getP().getX();
        int py = this.getP().getY();
        g.setColor(Color.WHITE);
        g.fillOval(px, py, this.semiAxisX, this.semiAxisY);
    }
}