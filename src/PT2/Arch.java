//package PT2;
//Tyler Walker
//Programming Test 2

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Arch extends JFrame {
    private BufferedImage image;

    public Arch() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Arch");

        URL url;
        try {
            url = new URL("https://www.nps.gov/arch/learn/photosmultimedia/upload/arches3.jpg");
            image = ImageIO.read(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        setSize(new Dimension(image.getWidth() + 75, image.getHeight() + 135));

        JLabel caption = new JLabel("Delicate Arch");
        caption.setBorder(new EmptyBorder(10, 10, 10, 10));
        caption.setHorizontalAlignment(SwingConstants.CENTER);
        caption.setForeground(Color.red);

        add(caption, BorderLayout.SOUTH);
        add(new UrlImage());
        setVisible(true);
    }

    class UrlImage extends JPanel {
        public UrlImage() {
            setBackground(Color.blue);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(image, 30, 30, this);
        }
    }

    public static void main(String[] args) {
        new Arch();
    }
}
