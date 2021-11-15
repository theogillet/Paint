import java.awt.*;

public class Ellipse extends Figure{
    protected int semiAxisX = 0;
    protected int semiAxisY = 0;

    public Ellipse(int px, int py, Color c) {
        super(c, new Point(px, py));
    }

    public void setBoundingBox(int heightBB, int semiAxisXBB) {
        this.semiAxisX = semiAxisXBB;
        this.semiAxisY = heightBB;
    }

    public void draw(Graphics g) {
        Color c = this.getC();
        int px = this.getP().getX();
        int py = this.getP().getY();
        g.setColor(c);
        if (this.semiAxisX > 0 && this.semiAxisY > 0) {
            g.fillOval(px, py, this.semiAxisX, this.semiAxisY);
        } else if (this.semiAxisX > 0 && this.semiAxisY < 0) {
            g.fillOval(px, py + this.semiAxisY, this.semiAxisX, -this.semiAxisY);
        } else if (this.semiAxisX < 0 && this.semiAxisY > 0) {
            g.fillOval(px + this.semiAxisX, py, -this.semiAxisX, this.semiAxisY);
        } else {
            g.fillOval(px + this.semiAxisX, py + this.semiAxisY, -this.semiAxisX, -this.semiAxisY);
        }
    }
}
