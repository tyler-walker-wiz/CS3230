package lab3;

import javax.swing.*;
import java.awt.*;


public class CircleTile extends RankTile {

    public CircleTile(int rank) {
        super(rank);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.anchor = GridBagConstraints.EAST;
        c.ipadx = -20;
        //setLayout(new GridBagLayout());
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(3, 3));
        containerPanel.setPreferredSize(new Dimension(50, 75));
        containerPanel.setLocation(20, 0);
        for (int i = 1; i <= rank; i++)
            containerPanel.add(new Circle(Color.blue, Color.RED));
        add(containerPanel, c);

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

    static final int OFFSETX = 30;
    static final int OFFSETY = 20;

    public Circle(Color color, Color dotColor) {
        this.color = color;
        this.dotColor = dotColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(this.color);
        g2.fillOval(0, 0, 12, 12);

        g2.setColor(this.dotColor);
//        g2.drawLine(1, 6, 11, 6);
//        //g2.rotate(Math.toRadians(45));
//        //g2.drawLine(0, 6, 12, 6);
//        g2.drawLine(6, 1, 6, 11);

        g2.fillOval(4, 7, 2, 2);
        g2.fillOval(4, 3, 2, 2);
        g2.fillOval(8, 3, 2, 2);
        g2.fillOval(8, 7, 2, 2);


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
