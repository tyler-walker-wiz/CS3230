package lab3;

public class CircleTile extends RankTile {
    public CircleTile(int rank){
        super(rank);
    }

    @Override
    public String toString() {
        return "Circle " + this.rank;
    }
}
