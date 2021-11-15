import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    Drawing draw = new Drawing();

    public Window(String Title, int x, int y)
    {
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();
        Container contentPanel2 = this.getContentPane();
        Container contentPanel3 = this.getContentPane();

        JMenuBar m= new JMenuBar();

        JMenu menu1 = new JMenu("File");
        JMenuItem nouveau = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Quit");
        nouveau.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);
        menu1.add(nouveau);
        menu1.add(open);
        menu1.add(save);
        menu1.add(quit);
        m.add(menu1);
        JMenu menu2 = new JMenu("A Propos");
        JMenuItem creator = new JMenuItem("Creator");
        JMenuItem version = new JMenuItem("Version");
        menu2.add(creator);
        menu2.add(version);
        JMenu menu3 = new JMenu("Help");
        JMenuItem advice = new JMenuItem("Advice");
        menu3.add(advice);
        creator.addActionListener(this);
        version.addActionListener(this);
        m.add(menu2);
        advice.addActionListener(this);
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog( info, "          Bienvenue sur mon Paint !\nPour commencer à dessiner, cliquez sur Ok",
                "Pop-Up",JOptionPane.INFORMATION_MESSAGE);
        m.add(menu3);

        //JButton OkButton = new JButton("I love Java !");
        //contentPanel.add(OkButton);
        //OkButton.addActionListener(this);


        JPanel SouthPanel = new JPanel();
        SouthPanel.setLayout(new GridLayout(2,6));
        JButton noir = new JButton("Noir");
        noir.addActionListener(this);
        JButton rouge = new JButton("Rouge");
        rouge.addActionListener(this);
        JButton vert = new JButton("Vert");
        vert.addActionListener(this);
        JButton bleu = new JButton("Bleu");
        bleu.addActionListener(this);
        JButton jaune = new JButton("Jaune");
        jaune.addActionListener(this);
        JButton rose = new JButton("Rose");
        rose.addActionListener(this);
        JButton magenta = new JButton("Magenta");
        magenta.addActionListener(this);
        JButton orange = new JButton("Orange");
        orange.addActionListener(this);
        JButton ellipse = new JButton("Ellipse");
        ellipse.addActionListener(this);
        JButton cercle = new JButton("Circle");
        cercle.addActionListener(this);
        JButton rectangle = new JButton("Rectangle");
        rectangle.addActionListener(this);
        JButton carre = new JButton("Square");
        carre.addActionListener(this);

        JPanel NorthPanel = new JPanel();
        JButton gomme = new JButton("Eraser");
        gomme.addActionListener(this);

        JPanel WestPanel = new JPanel();
        WestPanel.setLayout(new GridLayout(2,1));
        JButton Darken = new JButton("Darken");
        Darken.addActionListener(this);
        JButton Brighten = new JButton("Brighten");
        Brighten.addActionListener(this);

        contentPanel.add(draw,"Center");
        noir.setBackground(Color.BLACK);
        rouge.setBackground(Color.RED);
        vert.setBackground(Color.GREEN);
        bleu.setBackground(Color.BLUE);
        jaune.setBackground(Color.YELLOW);
        rose.setBackground(Color.PINK);
        magenta.setBackground(Color.MAGENTA);
        orange.setBackground(Color.ORANGE);

        SouthPanel.add(noir);
        SouthPanel.add(rouge);
        SouthPanel.add(vert);
        SouthPanel.add(bleu);
        SouthPanel.add(ellipse);
        SouthPanel.add(cercle);
        SouthPanel.add(jaune);
        SouthPanel.add(rose);
        SouthPanel.add(magenta);
        SouthPanel.add(orange);
        SouthPanel.add(rectangle);
        SouthPanel.add(carre);
        NorthPanel.add(gomme);
        WestPanel.add(Darken);
        WestPanel.add(Brighten);

        contentPanel.add(SouthPanel, "South");
        contentPanel2.add(NorthPanel, "North");
        contentPanel3.add(WestPanel, "West");

        setJMenuBar(m);
        SouthPanel.setVisible(true);
        NorthPanel.setVisible(true);
        WestPanel.setVisible(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Noir":
                System.out.println("La couleur noire est sélectionnée !");
                draw.setColor(Color.black);
                break;
            case "Rouge":
                System.out.println("La couleur rouge est sélectionnée !");
                draw.setColor(Color.red);
                break;
            case "Vert":
                System.out.println("La couleur verte est sélectionnée !");
                draw.setColor(Color.green);
                break;
            case "Bleu":
                System.out.println("La couleur bleue est sélectionnée !");
                draw.setColor(Color.blue);
                break;
            case "Jaune":
                System.out.println("La couleur jaune est sélectionnée !");
                draw.setColor(Color.yellow);
                break;
            case "Rose":
                System.out.println("La couleur rose est sélectionnée !");
                draw.setColor(Color.pink);
                break;
            case "Magenta":
                System.out.println("La couleur magenta est sélectionnée !");
                draw.setColor(Color.magenta);
                break;
            case "Orange":
                System.out.println("La couleur orange est sélectionnée !");
                draw.setColor(Color.orange);
                break;
            case "Ellipse":
                System.out.println("La figure ellipse est sélectionnée !");
                draw.setNameFigure("Ellipse");
                break;
            case "Circle":
                System.out.println("La figure cercle est sélectionnée !");
                draw.setNameFigure("Circle");
                break;
            case "Rectangle":
                System.out.println("La figure rectangle est sélectionnée !");
                draw.setNameFigure("Rectangle");
                break;
            case "Square":
                System.out.println("La figure carre est sélectionnée !");
                draw.setNameFigure("Square");
                break;
            case "Eraser":
                System.out.println("La gomme est sélectionnée !");
                draw.setNameFigure("Eraser");
                break;
            case "Darken":
                draw.setColor(draw.getC().darker());
                break;
            case "Brighten":
                draw.setColor(draw.getC().brighter());
                break;
            case "New":
                this.draw.nouveau();
                break;
            case "Open":
                this.draw.open();
                break;
            case "Save":
                this.draw.save();
                break;
            case "Quit":
                this.dispose();
                break;
            case "Creator":
                JOptionPane infoCreator = new JOptionPane();
                JOptionPane.showInternalMessageDialog(infoCreator, "Author : Theo Gillet", "Creator information", 1);
                break;
            case "Version":
                JOptionPane infoVersion = new JOptionPane();
                JOptionPane.showInternalMessageDialog(infoVersion, "Version 1.0", "Version information", 1);
                break;
            case "Advice":
                JOptionPane agoodadvice = new JOptionPane();
                JOptionPane.showInternalMessageDialog(agoodadvice, "If you need help, rise your hand until M.Tauvel has seen you !", "Advice", 1);
                break;
        }
    }
    public static void main(String[] args) {
        Window win = new Window("Le Paint de Théo", 800,600);
    }


}
