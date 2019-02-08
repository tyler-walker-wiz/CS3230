package lab3;

public abstract class Tile {
    public boolean matches(Tile other){
        return this.getClass().equals(other.getClass());
    }
}
