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
        g2.drawRect(25,5,60,60);
        g2.drawRect(30,10,50,50);

        g2.fillRect(25,5,10,6);
        g2.fillRect(45,5,10,5);
        g2.fillRect(65,5,10,5);

        g2.fillRect(25,60,10,5);
        g2.fillRect(45,60,10,5);
        g2.fillRect(65,60,10,5);

        g2.fillRect(25,20,5,10);
        g2.fillRect(25,40,5,10);

        g2.fillRect(80,10,5,10);
        g2.fillRect(80,30,5,10);
        g2.fillRect(80,50,5,11);
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