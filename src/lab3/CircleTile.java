package lab3;

import javax.swing.*;
import java.awt.*;


public class CircleTile extends RankTile {
    public CircleTile(int rank) {
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
                add(new Circle(color, firstRow, (i * 20) + yPos, rank));
            else if (i < 6)
                add(new Circle(color, firstRow + 15, ((i - 3) * 20) + yPos, rank));
            else
                add(new Circle(color, firstRow + 30, ((i - 6) * 20) + yPos, rank));
        }
    }

    @Override
    public String toString() {
        return "Circle " + this.rank;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

class Circle extends JComponent {
    private Color color;
    private Color dotColor;
    private int x;
    private int y;
    private int rank;

    public Circle(Color color, int x, int y, int rank) {
        this.color = color;
        this.dotColor = Color.white;
        this.x = x;
        this.y = y;
        this.rank = rank;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(this.color);
        if (rank == 1) {
            setSize(40, 40);
            setLocation(35, 20);
            g2.fillOval(0, 0, 30, 30);
            g2.setColor(this.dotColor);
            g2.fillOval(10, 15, 3, 3);
            g2.fillOval(10, 9, 3, 3);
            g2.fillOval(18, 15, 3, 3);
            g2.fillOval(18, 9, 3, 3);
        } else {
            setSize(20, 20);
            setLocation(x, y);
            g2.fillOval(0, 0, 12, 12);
            g2.setColor(this.dotColor);
            g2.fillOval(4, 7, 2, 2);
            g2.fillOval(4, 3, 2, 2);
            g2.fillOval(8, 3, 2, 2);
            g2.fillOval(8, 7, 2, 2);
        }


    }
}

class CircleTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));

        frame.pack();
        frame.setVisible(true);
    }
}
