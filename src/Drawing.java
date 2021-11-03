import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
    public Color c;
    public ArrayList<Figure> list = new ArrayList<>();
    public String nameFigure;
    public int x;
    public int y;
    public boolean saveCanceled = false;

    public void setColor(Color c) {
        this.c = c;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public Drawing() {
        this.setBackground(Color.white);
        this.x = 0;
        this.y = 0;
        list.add(new Rectangle(0, 0, Color.BLACK));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        System.out.println("Creation of a new " + nameFigure + " coloured " + c + " and originating from :" + x + " " + y);
        switch (nameFigure) {
            case "Ellipse":
                list.add(new Ellipse(x, y, c));
                break;
            case "Circle":
                list.add(new Circle(x, y, c));
                break;
            case "Rectangle":
                list.add(new Rectangle(x, y, c));
                break;
            case "Square":
                list.add(new Square(x, y, c));
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        System.out.println("End of a the new " + nameFigure + " coloured " + c + " and terminating on :" + x + " " + y);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ((Figure)this.list.get(this.list.size() - 1)).setBoundingBox(e.getY() - this.y,e.getX() - this.x);
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        Iterator nameFigure = this.list.iterator();

        while (nameFigure.hasNext()) {
            Figure f = (Figure) nameFigure.next();
            f.draw(g);
        }
    }

    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        int rVal = fileChooser.showOpenDialog(this);
        if (rVal == 0) {
            try {
                FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile().getPath());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeInt(this.list.size());
                Iterator var5 = this.list.iterator();

                while(var5.hasNext()) {
                    Figure f = (Figure)var5.next();
                    oos.writeObject(f);
                }

                oos.close();
            } catch (Exception var7) {
                System.out.println("Drawing could not be saved");
            }

            this.saveCanceled = false;
        } else if (rVal == 1) {
            this.saveCanceled = true;
        }

    }

    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        int rVal = fileChooser.showOpenDialog(this);
        if (rVal == 0) {
            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().getName());
                ObjectInputStream ois = new ObjectInputStream(fis);
                int size = ois.readInt();

                for(int i = 0; i < size; ++i) {
                    this.list.add((Figure)ois.readObject());
                }

                ois.close();
                this.repaint();
            } catch (Exception var7) {
                var7.printStackTrace();
                System.out.println("File could not be opened");
            }
        }

    }

    public void nouveau() {
        int result = JOptionPane.showConfirmDialog(this, "Do you want to save the modifications ?", "Save ?", 0, 3);
        if (result == 0) {
            this.save();
            if (!this.saveCanceled) {
                this.list = new ArrayList();
                this.repaint();
            }
        } else if (result == 1) {
            this.list = new ArrayList();
            this.repaint();
        }

    }

    public static void main(String[] args) {
    }
}
