package lab3;

import java.awt.*;

public class RankTile extends Tile {
    protected int rank;
    public RankTile(int rank){
        this.rank = rank;
    }

    @Override
    public boolean matches(Tile other) {
        return super.matches(other) && this.rank == ((RankTile)other).rank;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
