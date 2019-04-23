/*
* package PT3;
* Tyler Walker
* Programming Test 3
* */

//package PT3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private void northMsg() {
        JOptionPane.showMessageDialog(this,
                "North", "Direction",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void eastMsg() {
        JOptionPane.showMessageDialog(this,
                "East", "Direction",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void southMsg() {
        JOptionPane.showMessageDialog(this,
                "South", "Direction",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void westMsg() {
        JOptionPane.showMessageDialog(this,
                "West", "Direction",
                JOptionPane.INFORMATION_MESSAGE);
    }


    private void addMenuItem(JMenu menu, String text, Character mn, ActionListener a) {
        JMenuItem item = new JMenuItem(text, mn);
        item.addActionListener(a);
        menu.add(item);
    }

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GUI");

        setSize(250, 200);
        setLayout(new BorderLayout());

        JPanel sPanel = new JPanel();
        JButton south = new JButton("South");
        south.addActionListener(a -> southMsg());
        sPanel.add(south);

        JPanel ePanel = new JPanel();
        JButton east = new JButton("East");
        east.addActionListener(a -> eastMsg());
        ePanel.add(east);

        JPanel nPanel = new JPanel();
        JButton north = new JButton("North");
        north.addActionListener(a -> northMsg());
        nPanel.add(north);

        JPanel wPanel = new JPanel();
        JButton west = new JButton("West");
        west.addActionListener(a -> westMsg());
        wPanel.add(west);

        add(sPanel, BorderLayout.SOUTH);
        add(ePanel, BorderLayout.EAST);
        add(nPanel, BorderLayout.NORTH);
        add(wPanel, BorderLayout.WEST);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu dirMenu = new JMenu("Directions");
        dirMenu.setMnemonic('D');
        menuBar.add(dirMenu);

        addMenuItem(dirMenu, "North", 'N', e -> northMsg());
        addMenuItem(dirMenu, "East", 'E', e -> eastMsg());
        addMenuItem(dirMenu, "South", 'S', e -> southMsg());
        addMenuItem(dirMenu, "West", 'W', e -> westMsg());

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
