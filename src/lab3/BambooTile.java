package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class BambooTile extends RankTile {
    public BambooTile(int rank) {
        super(rank);
        Color color;
        int yPos = 5;
        int firstRow = 35;
        if (rank < 4)
            firstRow = 50;
        for (int i = 0; i < rank; i++) {
            if (i % 3 == 0)
                color = Color.red;
            else if (i % 2 == 0)
                color = Color.blue;
            else
                color = Color.green;
            if (i < 3)
                add(new BambooStick(color, firstRow, (i * 20) + yPos));
            else if (i < 6)
                add(new BambooStick(color, firstRow + 15, ((i - 3) * 20) + yPos));
            else
                add(new BambooStick(color, firstRow + 30, ((i - 6) * 20) + yPos));
        }
    }

    @Override
    public String toString() {
        return "Bamboo " + this.rank;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

class BambooStick extends JComponent {
    private Color color;
    private int x;
    private int y;

    public BambooStick(Color c, int x, int y) {
        this.color = c;
        this.x = x;
        this.y = y;
    }

    protected void paintComponent(Graphics g) {
        setSize(20, 20);
        setLocation(x, y);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(this.color);
//        g2.fillRect(0,0,30,50);
        Shape halfCircle = new Arc2D.Float(0, 0, 10, 10, 0, 180, Arc2D.CHORD);
        g2.fill(halfCircle);
        g2.fillRect(5, 5, 2, 20);
        Shape halfCircle1 = new Arc2D.Float(0, 10, 10, 10, 0, 180, Arc2D.CHORD);
        g2.fill(halfCircle1);
        Shape halfCircle2 = new Arc2D.Float(0, 20, 10, 10, 0, 180, Arc2D.CHORD);
        g2.fill(halfCircle2);
    }
}

class BambooTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle("Bamboo Tiles");

        frame.add(new BambooTile(2));
//        frame.add(new BambooTile(3));
//        frame.add(new BambooTile(4));
//        frame.add(new BambooTile(5));
//        frame.add(new BambooTile(6));
//        frame.add(new BambooTile(7));
//        frame.add(new BambooTile(8));
//        frame.add(new BambooTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
