package Vue;




import Interfaces.Observer;
import Model.ImageModel;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;


public class PanneauPrincipal extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;


    public PanneauPrincipal( ImageModel imageModel)  {



        initPanneau(imageModel);


    }

   public void initPanneau(ImageModel imageModel)
   {
       JPanel haut = new JPanel(new GridLayout(1,1));
       JPanel milieu = new JPanel(new GridLayout(1,2));
       JPanel bas = new JPanel(new GridLayout(1,1));

       PanneauImage panneauImage = new PanneauImage(imageModel);
       panneauImage.setPreferredSize(new Dimension(300,200));
       haut.add(panneauImage);

       PanneauImage perspective1 = new PanneauImage(imageModel);
       perspective1.setPreferredSize(new Dimension(400,300));
       milieu.add(perspective1);

       PanneauImage perspective2 = new PanneauImage(imageModel);
       perspective2.setPreferredSize(new Dimension(400,300));
       milieu.add(perspective2);


PanneauBoutons panneauBoutons = new PanneauBoutons(imageModel);

       panneauBoutons.setPreferredSize(new Dimension(800,100));
       bas.add(panneauBoutons);
       add(haut,BorderLayout.NORTH);
       add(milieu,BorderLayout.CENTER);
       add(bas);

   }


    @Override
    public void update() {


        repaint();
    }





}
