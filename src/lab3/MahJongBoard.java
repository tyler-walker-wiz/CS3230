package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class MahJongBoard extends JPanel implements MouseListener {
    private MahJongModel _model;
    private MahJong game;
    private int tileWidth = 70;
    private int tileHeight = 70;
    private Tile selected1;
    private JTextArea log;
    private JPanel[] discard = new JPanel[2];
    private Stack<Tile> undoStack = new Stack<Tile>();
    private int count = 0;
    private JScrollPane scroller;

    public MahJongBoard(MahJongModel model) {
        _model = model;
        setLayout(null);
        setSize(1300, 900);
        setBackground(Color.orange);
        setBoard();

        scroller = new JScrollPane();
//        scroller.setLocation(1100, 10);
//        scroller.setSize(100, 700);
        scroller.setLocation(200, 10);
        scroller.setSize(800, 120);
        discard[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discard[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        discard[0].setPreferredSize(new Dimension(0, 100));
        discard[1].setPreferredSize(new Dimension(0, 100));


        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel(new BorderLayout());
        scroller.setViewportView(panel);

        panel.add(discard[0], BorderLayout.NORTH);
        panel.add(discard[1], BorderLayout.SOUTH);

        discard[0].setBackground(new Color(254, 205, 33));
        discard[1].setBackground(new Color(254, 205, 33));
        panel.setBackground(new Color(254, 205, 33));
//        JTextArea textArea = new JTextArea("Move log...\n");
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//        textArea.setEditable(false);

        add(scroller);
    }

    public MahJongBoard() {
        setLayout(null);
        setSize(1000, 800);
        setBackground(Color.orange);
    }

    public void playGame() {
        revalidate();
        repaint();
    }

    private void setBoard() {
        putTile(5, 35, 0, 4, 35);
        handleLayer(2, 5, 3);
        handleLayer(4, 6, 2);
        handleLayer(6, 7, 1);
        handleBottomLayer();
    }

    private void handleBottomLayer() {
        int rowY = 9 * tileHeight - 10;
        int z = 0;
        int x = 0;
        putTile(5, -35, x, z, -(tileWidth * 7));
        addRow(12, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(8, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(10, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(12, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(12, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(10, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(8, rowY, x++, z, 0);
        rowY -= tileHeight;
        addRow(12, rowY, x++, z, 0);
        putTile(5, -35, x++, z, (tileWidth * 6));
        putTile(5, -35, x, z, (tileWidth * 7));
    }

    private void putTile(int row, int rowOffset, int x, int z, int xOffset) {
        int rowY = (row * tileHeight) - rowOffset;
        addRow(1, rowY, x, z, xOffset);
    }

    private void handleLayer(int cols, int row, int layer) {
        int rowY = (row * tileHeight);
        if (layer == 1)
            rowY += (20 * (layer + 1));
        else if (layer != 3)
            rowY += (20 * (layer - 1));
        int y = 0;
        for (int i = cols; i > 0; i--) {
            addRow(cols, rowY, y++, layer, 0);
            rowY -= tileHeight;
        }
    }

    private void addRow(int cols, int rowY, int x, int z, int xOffset) {
        TileDeck deck = _model.deck;
        int xPos = tileWidth + xOffset;
        Tile t;
        int xCols = cols;
        if (xCols < 12) {
            if (xCols % 2 == 1) xCols--;
            xPos += (((12 - xCols) / 2) * (tileWidth));
            if (z == 1)
                xPos -= (20 * (z + 1)) - 60;
            else if (z == 3)
                xPos += (20 * (3));
            else if (z > 0)
                xPos -= (20 * (z - 1)) - 60;
        }
        for (int i = 0; i < cols; i++) {
            t = deck.deal();
            if (t == null) return;
            _model.positionTile(t, x, i, z);
            t.setLocation(xPos, rowY);
            t.addMouseListener(this);
            add(t);
            xPos += t.getSize().width - 20;
        }
    }

    public void addToUndo(Tile t1, Tile t2) {
        undoStack.push(t1);
        undoStack.push(t2);

        Dimension size = new Dimension(++count * 100, 100 + 6);
        discard[0].setPreferredSize(size);
        discard[1].setPreferredSize(size);

        // This version puts the most recently added tiles on the right and scrolls
        // a scroll pane so that the most recently added tiles are visible.

        discard[0].add(t1);
        discard[1].add(t2);

        Rectangle r = new Rectangle(count * 100, 0, 100, 100 + 6);
        scroller.getViewport().scrollRectToVisible(r);


        // This version puts the most recently added tiles on the left - it doesn't
        // need to scroll - the most recently added tiles are always visible.

		/*discard[0].add(t1, 0);
		discard[1].add(t2, 0);*/

        revalidate();
        repaint();
    }

    public void undoMove() {
        if (undoStack.size() == 0) return;
        Tile t1 = undoStack.pop();
        t1.setLocation(t1.x, t1.y);
        Tile t2 = undoStack.pop();
        t2.setLocation(t2.x, t2.y);
        add(t1);
        add(t2);
        this.setComponentZOrder(t1, t1.zOrder);
        this.setComponentZOrder(t2, t2.zOrder);
        revalidate();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = Tile.face.get("dragon_bg").getImage();
        g.drawImage(img, 200, 200, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Tile tile = (Tile) e.getSource();
        if (selected1 == null) {
            selected1 = tile;
            tile.selected = true;
        } else {
            System.out.println(tile.getParent().getComponentZOrder(tile));

            if (tile.matches(selected1) && _model.isTileOpen(tile)) {
                tile.zOrder = tile.getParent().getComponentZOrder(tile);
                tile.x = tile.getX();
                tile.y = tile.getY();
                selected1.zOrder = selected1.getParent().getComponentZOrder(selected1);
                selected1.x = selected1.getX();
                selected1.y = selected1.getY();
                remove(tile);
                remove(selected1);
                if (!_model.removeTile(tile) || !_model.removeTile(selected1))
                    System.out.println("Unable to remove tile");
                addToUndo(tile, selected1);
            }
            tile.selected = false;
            selected1.selected = false;
            selected1 = null;
        }
        revalidate();
        super.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
