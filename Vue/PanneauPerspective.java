package Vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanneauPerspective extends JPanel {


public PanneauPerspective(){
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
