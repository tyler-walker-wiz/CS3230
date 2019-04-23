package lab3;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Tile extends JPanel {
    static Color grd;
    static Color back;
    static Rectangle rect;
    static GradientPaint grad;
    static GradientPaint selectedGrad;
    static GradientPaint gradMain;
    static GradientPaint gradReverse;
    static Polygon poly1h;
    static Polygon poly1w;
    static Polygon poly2h;
    static Polygon poly2w;
    protected static Map<String, ImageIcon> face = new HashMap<String, ImageIcon>();
    protected static String[] files = {"Bamboo", "Chrysanthemum", "dragon_bg", "Fall", "Orchid", "Plum", "Sparrow", "Spring", "Summer", "Winter"};
    protected MahJongModel model;
    public int posx;
    public int posy;
    public int layer;
    public Tile left;
    public Tile right;
    public Tile top;
    public boolean selected;
    public int zOrder;
    public int x;
    public int y;

    static {
        grd = new Color(37, 165, 14);
        back = new Color(237, 213, 120);
        rect = new Rectangle(20, 0, 70, 70);
        grad = new GradientPaint(100, 0, grd, 140, 100, Color.WHITE);
        selectedGrad = new GradientPaint(100, 0, Color.yellow, 140, 100, Color.WHITE);
        gradMain = new GradientPaint(100, 0, back, 140, 100, Color.WHITE);
        gradReverse = new GradientPaint(0, 100, Color.WHITE, 100, 100, grd);
        poly1h = SetPolygonH(0, 10, 80, 70);
        poly1w = SetPolygonV(0, 10, 80, 70);
        poly2h = SetPolygonH(10, 0, 80, 70);
        poly2w = SetPolygonV(10, 0, 80, 70);

        // this version can read from a JAR file and from the file system
        // in a JAR, file names are case-sensitive
        // eclipse: position "images" in the bin folder
        for (int i = 0; i < files.length; i++) {
            URL url = Tile.class.getResource("images/" + files[i] + ".png");
            face.put(files[i], new ImageIcon(url));
        }
    }

    public boolean matches(Tile other) {
        return this.getClass().equals(other.getClass()) && !this.equals(other);
    }

    public Tile() {
        setSize(90, 90);
        setPreferredSize(new Dimension(90, 90));
        setOpaque(false);
        setBackground(Color.PINK);
    }


    private static Polygon SetPolygonV(int x, int y, int height, int width) {
        int shift = 10;
        int xpoints[] = {x, x, x + shift, x + shift, x};
        int ypoints[] = {y + shift, y + height, y + height - shift, y, y + shift};
        int npoints = 5;

        return new Polygon(xpoints, ypoints, npoints);
    }

    private static Polygon SetPolygonH(int x, int y, int height, int width) {
        int shift = 10;
        int xpoints[] = {x, x + width, x + width + shift, x + shift, x};
        int ypoints[] = {y + height, y + height, y + height - shift, y + height - shift, y + height};
        int npoints = 5;

        return new Polygon(xpoints, ypoints, npoints);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        if (selected)
            g2.setPaint(selectedGrad);
        else
            g2.setPaint(gradMain);
        g2.fill(rect);
        g2.fillPolygon(poly2h);
        g2.fillPolygon(poly2w);

        if (selected)
            g2.setColor(Color.yellow);
        else
            g2.setColor(Color.black);
        g2.draw(rect);
        g2.drawPolygon(poly2h);
        g2.drawPolygon(poly2w);


        g2.setPaint(gradReverse);
        g2.fillPolygon(poly1h);
        g2.setPaint(grad);
        g2.fillPolygon(poly1w);

        g2.setColor(Color.black);
        g2.drawPolygon(poly1h);
        g2.drawPolygon(poly1w);
    }
}

class TileTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");

        frame.add(new Tile());
        frame.add(new Tile());

        frame.pack();
        frame.setVisible(true);
    }
}
