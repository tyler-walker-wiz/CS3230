package lab3;

import java.util.HashMap;
import java.util.LinkedList;

public class MahJongModel {
    private HashMap<Integer, Tile[][]> tiles = new HashMap<>();
    private MahJongBoard board;

    void positionTile(Tile t, int x, int y, int z) {
        t.posx = x;
        t.posy = y;
        t.layer = z;
        Tile[][] layerTiles = tiles.get(z);
        if (layerTiles != null) {
            layerTiles[x][y] = t;
        } else {
            layerTiles = new Tile[][]{new Tile[]{t}};
        }
        tiles.put(z, layerTiles);
    }

    boolean isTileOpen(Tile t) {
        return t.top == null && ((t.left != null && t.right == null) || (t.right != null && t.left == null));
    }

    Tile getTile(int x, int y, int z) {
        Tile[][] layerTiles = tiles.get(z);
        return layerTiles[x][y];
    }
}
