package lab3;

import java.util.HashMap;
import java.util.LinkedList;

public class MahJongModel {
    private HashMap<Integer, Tile[][]> tiles = new HashMap<>();
    private MahJongBoard board;
    public TileDeck deck;

    public MahJongModel(TileDeck deck) {
        this.deck = deck;
    }

    void positionTile(Tile t, int x, int y, int z) {
        if (t == null) return;
        t.posx = x;
        t.posy = y;
        t.layer = z;
        Tile[][] layerTiles = tiles.get(z);
        if (layerTiles != null) {
            if (layerTiles[x] == null)
                layerTiles[x] = new Tile[12];
            layerTiles[x][y] = t;
        } else {
            layerTiles = new Tile[11][12];
            layerTiles[x] = new Tile[12];
            layerTiles[x][y] = t;
        }
        tiles.put(z, layerTiles);
    }

//    boolean isTileOpen(Tile t) {
//        return t.top == null && ((t.left != null && t.right == null) || (t.right != null && t.left == null));
//    }

    boolean isTileOpen(Tile t) {
        Tile[][] layer = tiles.get(t.layer);
        Tile[][] layerTop = tiles.get(t.layer + 1);
        try {
            return ((layerTop == null || layer.length == 0 || layerIsEmpty(layerTop)) || layerTop[t.posx][t.posy] == null) &&
                    (layer[t.posx][t.posy + 1] == null || layer[t.posx][t.posy - 1] == null || layer[t.posx + 1][t.posy] == null || layer[t.posx - 1][t.posy] == null);
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    boolean layerIsEmpty(Tile[][] layer) {
        for (int i = 0; i < layer.length; i++) {
            Tile[] x = layer[i];
            for (int j = 0; j < x.length; j++) {
                Tile t = x[j];
                if (t != null) return false;
            }
        }
        return true;
    }

    boolean removeTile(Tile t) {
        try {
            tiles.get(t.layer)[t.posx][t.posy] = null;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    Tile getTile(int x, int y, int z) {
        Tile[][] layerTiles = tiles.get(z);
        return layerTiles[x][y];
    }
}
