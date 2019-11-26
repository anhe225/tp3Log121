package Vue;




import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;


public class PanneauPrincipal extends JPanel {

    private static final long serialVersionUID = 1L;


    public PanneauPrincipal()  {
        super();
        GridLayout experimentLayout = new GridLayout(1,1);
        this.setLayout(experimentLayout);
        PanneauImage panneauImage = new PanneauImage();
       add(panneauImage, BorderLayout.CENTER);

        JPanel b2 = new JPanel();


        GridLayout experimentLayouts = new GridLayout(2,2);
       PanneauPerspective pp1 = new PanneauPerspective();
        PanneauPerspective pp2 = new PanneauPerspective();

        this.setLayout(experimentLayouts);
        this.add(pp1);
        this.add(pp2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }



}
