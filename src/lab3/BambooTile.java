package lab3;

public class BambooTile extends RankTile {
    public BambooTile(int rank){
        super(rank);
    }

    @Override
    public String toString() {
        return "Bamboo " + this.rank;
    }
}
