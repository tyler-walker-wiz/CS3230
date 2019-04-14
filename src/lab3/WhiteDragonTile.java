package lab3;

import javax.swing.*;
import java.awt.*;

public class WhiteDragonTile extends Tile {
    public WhiteDragonTile(){
        setToolTipText("White Dragon");
    }
    @Override
    public String toString() {
        return "White Dragon";
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setPaint(Color.blue);
        g2.drawRect(40,30,60,60);
        g2.drawRect(45,35,50,50);

        g2.fillRect(40,30,10,6);
        g2.fillRect(60,30,10,5);
        g2.fillRect(80,30,10,5);

        g2.fillRect(40,85,10,5);
        g2.fillRect(60,85,10,5);
        g2.fillRect(80,85,10,5);

        g2.fillRect(40,45,5,10);
        g2.fillRect(40,65,5,10);

        g2.fillRect(95,35,5,10);
        g2.fillRect(95,55,5,10);
        g2.fillRect(95,75,5,11);
    }
}

class WhiteDragonTest{
    public static void main(String[] args){
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("White Dragon Tile");

        frame.add(new WhiteDragonTile());

        frame.pack();
        frame.setVisible(true);
    }
}