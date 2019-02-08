package lab3;

public class CharacterTile extends Tile {
    protected char symbol;

    public CharacterTile(char symbol) {
        this.symbol = symbol;
    }

    public boolean matches(Tile other) {
        return super.matches(other) && this.symbol == ((CharacterTile) other).symbol;
    }

    @Override
    public String toString() {
        if (Character.isDigit(this.symbol))
            return "Character " + this.symbol;
        switch (this.symbol) {
            case 'N':
                return "North Wind";
            case 'E':
                return "East Wind";
            case 'W':
                return "West Wind";
            case 'S':
                return "South Wind";
            case 'C':
                return "Red Dragon";
            case 'F':
                return "Green Dragon";
            default:
                return "";
        }
    }
}
