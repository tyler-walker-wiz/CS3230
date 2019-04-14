package demos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;


public class DieDemo extends JFrame implements MouseListener {
    public DieDemo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 5));

        for (int i = 0; i < 5; i++) {
            Die die = new Die();
            die.addMouseListener(this);
            add(die);
        }

        pack();
        setVisible(true);
    }


    public void mousePressed(MouseEvent e) {
        Die die = (Die) e.getSource();

        //System.out.println(die.getParent());
        //System.out.println(die.getParent().getComponentZOrder(die));

        if (e.getButton() == MouseEvent.BUTTON3) {
            die.setBackground(Color.RED);
            die.removeMouseListener(this);

            //remove(die);	// other side of add
            //revalidate();
        } else
            die.roll();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }


    public static void main(String[] args) {
        new DieDemo();
    }
}


class Die extends JPanel {
    private static ImageIcon[] face = new ImageIcon[6];
    private static Random rand = new Random();
    private static Dimension size = new Dimension(42, 42);
    private int spots = rand.nextInt(6);

    public Die() {
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBackground(Color.GREEN);
        setPreferredSize(size);
    }

    public int getSpots() {
        return spots + 1;
    }

    public void roll() {
        spots = rand.nextInt(6);
        repaint();
    }

    public void freeze() {
        setBackground(Color.RED);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(face[spots].getImage(), 5, 5, this);
    }

    static {
        String[] files = {"one", "two", "three", "four", "five", "six"};

        // this version can read from a JAR file and from the file system
        // in a JAR, file names are case-sensitive
        // eclipse: position "images" in the bin folder
        for (int i = 0; i < files.length; i++) {
            URL url = Die.class.getResource("images/" + files[i] + ".gif");
            face[i] = new ImageIcon(url);
        }

        // this version read from a file system.
        // eclipse: position "images" in the project folder
        //for (int i = 0; i < files.length; i++)
        //	face[i] = new ImageIcon("images/" + files[i] + ".gif");
    }
}
