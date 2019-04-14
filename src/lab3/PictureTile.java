package lab3;

import java.awt.*;

public abstract class PictureTile extends Tile {
    private String name;

    public PictureTile(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = Tile.face.get(name).getImage();
        g.drawImage(img, 40, 40, this);
    }
}
