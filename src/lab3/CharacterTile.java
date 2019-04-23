package lab3;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CharacterTile extends Tile {
    public static HashMap<Character,Character> map;

    static {
        map = new HashMap<>();
        map.put('1','\u4E00');
        map.put('2','\u4E8C');
        map.put('3','\u4E09');
        map.put('4','\u56DB');
        map.put('5','\u4E94');
        map.put('6','\u516D');
        map.put('7','\u4E03');
        map.put('8','\u516B');
        map.put('9','\u4E5D');
        map.put('N','\u5317');
        map.put('E','\u6771');
        map.put('W','\u897F');
        map.put('S','\u5357');
        map.put('C','\u4E2D');
        map.put('F','\u767C');
    }

    protected char symbol;

    public CharacterTile(char symbol) {
        super();
        this.symbol = symbol;
    }

    public boolean matches(Tile other) {
        return super.matches(other) && this.symbol == ((CharacterTile) other).symbol;
    }

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

    public String toChinese(){
        return Character.toString(map.get(this.symbol));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(Character.toString(symbol), 75, 15);
        g.drawString(toChinese(), 50, 50);
        setToolTipText(toString());
    }
}

class CharacterTest{
    public static void main(String[] args)
    {
        JFrame		frame = new JFrame();
        JPanel tiles = new JPanel();
        JScrollPane	scroller = new JScrollPane(tiles);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Tiles");
        frame.add(scroller);

        // Try something like this if your tiles don't fit on the screen.
        // Replace "tile width" and "tile height" with your values.
        //scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

        tiles.add(new CharacterTile('1'));
        tiles.add(new CharacterTile('2'));
        tiles.add(new CharacterTile('3'));
        tiles.add(new CharacterTile('4'));
        tiles.add(new CharacterTile('5'));
        tiles.add(new CharacterTile('6'));
        tiles.add(new CharacterTile('7'));
        tiles.add(new CharacterTile('8'));
        tiles.add(new CharacterTile('9'));
        tiles.add(new CharacterTile('N'));
        tiles.add(new CharacterTile('E'));
        tiles.add(new CharacterTile('W'));
        tiles.add(new CharacterTile('S'));
        tiles.add(new CharacterTile('C'));
        tiles.add(new CharacterTile('F'));

        frame.pack();
        frame.setVisible(true);
    }
}
