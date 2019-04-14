package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class BambooTile extends RankTile {
    public BambooTile(int rank) {
        super(rank);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 10;
        c.anchor = GridBagConstraints.WEST;
        c.ipadx = -150;
        setLayout(new GridBagLayout());
        JPanel containerPanel = new JPanel();
        if (rank < 4)
            containerPanel.setLayout(new GridLayout(3, 1));
        else if (rank < 7)
            containerPanel.setLayout(new GridLayout(3, 2));
        else
            containerPanel.setLayout(new GridLayout(3, 3));
        containerPanel.setLocation(200, 0);
        containerPanel.setPreferredSize(new Dimension(200, 75));
        for (int i = 1; i <= rank; i++) {
            if (i % 3 == 0)
                containerPanel.add(new BambooStick(Color.red));
            else if (i % 2 == 0)
                containerPanel.add(new BambooStick(Color.blue));
            else
                containerPanel.add(new BambooStick(Color.green));
        }
        add(containerPanel, c);
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

    public BambooStick(Color c) {
        this.color = c;
    }

    protected void paintComponent(Graphics g) {
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

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bamboo Tiles");

        frame.add(new BambooTile(2));
        frame.add(new BambooTile(3));
        frame.add(new BambooTile(4));
        frame.add(new BambooTile(5));
        frame.add(new BambooTile(6));
        frame.add(new BambooTile(7));
        frame.add(new BambooTile(8));
        frame.add(new BambooTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
