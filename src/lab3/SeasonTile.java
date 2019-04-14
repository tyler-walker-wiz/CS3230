package lab3;

import javax.swing.*;
import java.awt.*;

public class SeasonTile extends PictureTile {
    public SeasonTile(String name){
        super(name);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}

class SeasonTest{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel tiles = new JPanel();
        JScrollPane	scroller = new JScrollPane(tiles);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Season Tiles");
        frame.add(scroller);

        // Try something like this if your tiles don't fit on the screen.
        // Replace "tile width" and "tile height" with your values.
        //scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

        tiles.add(new SeasonTile(Tile.files[0]));
        tiles.add(new SeasonTile(Tile.files[1]));
        tiles.add(new SeasonTile(Tile.files[2]));
        tiles.add(new SeasonTile(Tile.files[3]));
        tiles.add(new SeasonTile(Tile.files[4]));
        tiles.add(new SeasonTile(Tile.files[5]));
        tiles.add(new SeasonTile(Tile.files[6]));

        frame.pack();
        frame.setVisible(true);
    }
}
