package Vue;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class PanneauImage extends JPanel {

    private BufferedImage image;



    public PanneauImage() {
        super();
        getImage ();
    }

    public void getImage ()
    {

        try {
            BufferedImage img = ImageIO.read(new File("images/image.jpeg"));//it must be an image file, otherwise you'll get an exception
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(img));
            add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
