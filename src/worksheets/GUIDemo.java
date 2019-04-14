package worksheets;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class GUIDemo extends JFrame
{
    private	Image	image;									// Image version
    //private	ImageIcon	image;							// ImageIcon version

    public GUIDemo()
    {
        setTitle("GUI Demonstration");
        setSize(600, 400);								// unpacked version


        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent E)
        { close(); }
        });

        Dimension	screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        try
        {
            URL url = new URL("https://www.nps.gov/arch/photosmultimedia/upload/arches11.jpg");

            // -------------------------------------------------------------------------------------------
            //image = Toolkit.getDefaultToolkit().getImage("images/archesll.jpg");	// Image on disk
            image = Toolkit.getDefaultToolkit().getImage(url);			// Image from Internet

            //image = Toolkit.getDefaultToolkit().getImage(url).			// Resize image
            //	getScaledInstance(screenSize.width - 6, -1, Image.SCALE_SMOOTH);

            // -------------------------------------------------------------------------------------------

            //image = new ImageIcon(url);						// ImageIcon version

            //image = new ImageIcon(image.getImage().				// Resize ImageIcon
            //	getScaledInstance(screenSize.width - 6, -1, Image.SCALE_SMOOTH));
        }
        catch(java.net.MalformedURLException murle)
        {
            JOptionPane.showMessageDialog(this, "Bad URL: " + murle,
                    "Image Error", JOptionPane.ERROR_MESSAGE);
        }


        // --------------------------------------------------------------------------------------------------
		/*MediaTracker tracker = new MediaTracker(this);				// Used with Image
		tracker.addImage(image, 0);

		try
		{
			tracker.waitForAll();
		}
		catch (InterruptedException ie)
		{
			JOptionPane.showMessageDialog(this, "Unable to load image",
				"Image Error", JOptionPane.ERROR_MESSAGE);
		}*/
        // --------------------------------------------------------------------------------------------------

        add(new Display());

        //pack();									// packed version

        setLocation((screenSize.width - getWidth()) / 2,				// centers frame
                (screenSize.height - getHeight()) / 2);

        setVisible(true);
    }


    private void close()
    {
        if (JOptionPane.showConfirmDialog(null, "Exit Program?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }


    class Display extends JPanel
    {
        // -------------------------------- packed versions -------------------------------------------------

		/*public Display()
		{
			// ------------------------ packed/Image version --------------------------------------------

			//setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));

			// ------------------------------------------------------------------------------------------


			// ------------------------ packed/ImageIcon version ----------------------------------------

			//setPreferredSize(new Dimension(image.getImage().getWidth(this),
			//			image.getImage().getHeight(this) + 25));	// with caption



			// --------------- packed/ImageIcon version using Icon interface methods -------------------

			//setPreferredSize(new Dimension(image.getIconWidth(),
			//			image.getIconHeight() + 25));			// with caption

			// ------------------------------------------------------------------------------------------
		}*/

        // --------------------------------------------------------------------------------------------------

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.drawImage(image, 0, 0, this);						// Use with Image

            Image img = image.getScaledInstance(600, 400, Image.SCALE_SMOOTH);

            g.setColor(Color.black);g.drawLine(10, 10, 10, 50);g.setColor(Color.red);g.drawRect(100, 100, 150, 150);

            //g.drawImage(image.getImage(), 0, 0, this);				// Use with ImageIcon
            //image.paintIcon(this, g, 0, 0);					// ImageIcon alternate


            // --------------------------- picture caption code -----------------------------------------
			/*String	caption = "Park Avenue";

			//Font	f = g.getFont().deriveFont(20F);				// big font
			//g.setFont(f);								// install new font

			// ------------------------ additional font sizing example ----------------------------------
			//Font	f = g.getFont();
			//f = f.deriveFont(f.getSize2D() * 0.8F);				// shrink font
			//f = f.deriveFont(f.getSize2D() * 1.5F);				// enlarge font
			//g.setFont(f);
			// ------------------------------------------------------------------------------------------

			FontMetrics	fm = g.getFontMetrics();
			int		wid = fm.stringWidth(caption);

			//g.setColor(Color.RED);						// change font color
			g.drawString(caption, (getWidth() - wid) / 2, getHeight() - 10);*/
            // ------------------------------------------------------------------------------------------
        }
    }



    public static void main(String[] args)
    {
        new GUIDemo();
    }
}