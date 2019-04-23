package lab3;

import lab3.helper.Help;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MahJong extends JFrame {
    private MahJongBoard _board;
    private boolean started;

    public MahJong() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MahJong");
        createGame();
        //add(new MahJongBoard());
        setSize(1300, 900);
        //pack();
        setVisible(true);
    }

    private void createGame() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        JMenu soundMenu = new JMenu("Sound");
        JMenu moveMenu = new JMenu("Move");
        JMenu helpMenu = new JMenu("Help");
        gameMenu.setMnemonic('G');
        soundMenu.setMnemonic('S');
        moveMenu.setMnemonic('M');
        helpMenu.setMnemonic('H');

        menuBar.add(gameMenu);
        menuBar.add(soundMenu);
        menuBar.add(moveMenu);
        menuBar.add(helpMenu);

        addMenuItem(gameMenu, "Play", 'P', e -> play());
        addMenuItem(gameMenu, "Restart", 'R', e -> restart());
        addMenuItem(gameMenu, "Numbered", 'N', e -> play());
        addMenuItem(gameMenu, "Tournament", 'T', e -> play());
        addMenuItem(soundMenu, "On", 'O', e -> toggleSound(true));
        addMenuItem(soundMenu, "Off", 'F', e -> toggleSound(false));
        addMenuItem(moveMenu, "Undo", 'U', e -> undo());
        addMenuItem(helpMenu, "Operation", 'O', e -> action());
        addMenuItem(helpMenu, "Game Rules", 'R', e -> rules());
//        TileDeck deck = new TileDeck();
//        MahJongModel model = new MahJongModel(deck);
//        _board = new MahJongBoard(model);
        _board = new MahJongBoard();
        add(_board);
    }

    private void play() {
        if (started) return;
        remove(_board);
        started = true;
        TileDeck deck = new TileDeck();
        MahJongModel model = new MahJongModel(deck);
        _board = new MahJongBoard(model);
        add(_board);
        _board.playGame();
        revalidate();
    }

    private void restart() {
        int resp = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to restart?", "Confirm",
                JOptionPane.OK_CANCEL_OPTION);
        if (resp == JOptionPane.OK_OPTION)
            remove(_board);
        else return;
        TileDeck deck = new TileDeck();
        MahJongModel model = new MahJongModel(deck);
        _board = new MahJongBoard(model);
        add(_board);
        _board.playGame();
        revalidate();
    }

    private void toggleSound(boolean sound) {

    }

    private void undo() {
        _board.undoMove();
    }

    private void action() {
        JOptionPane.showMessageDialog(this,
                "Unknown", "Menu",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void rules() {
        JFrame newFrame = new JFrame();
        newFrame.setSize(800, 800);
        newFrame.add(new Help("rules.html", "Alright"));
        newFrame.setVisible(true);
    }

    private void addMenuItem(JMenu menu, String text, Character mn, ActionListener a) {
        JMenuItem item = new JMenuItem(text, mn);
        item.addActionListener(a);
        menu.add(item);
    }

    public static void main(String[] args) {
        new MahJong();
    }
}
