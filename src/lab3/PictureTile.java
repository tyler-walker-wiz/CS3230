package lab3;

public abstract class PictureTile extends Tile {
    private String name;
    public PictureTile(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
