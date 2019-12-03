package Vue;




import Interfaces.Observer;
import Model.ImageModel;

import java.awt.*;

import javax.swing.*;


public class PanneauPrincipal extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
public  static  ImageModel[] tab = new ImageModel[3];

    public PanneauPrincipal( ImageModel imageModel)  {



        initPanneau(imageModel);


    }

   public void initPanneau(ImageModel imageModel)
   {
       //ajout des perspectives pour effectuer l'operation sur les perpectives

       ImageModel m1,m2,m3;
       m1 = imageModel;
       m2 = imageModel;
       m3 = imageModel;


       this.tab[0]=m1;
       this.tab[1]=m2;
       this.tab[2]=m3;

       JPanel haut = new JPanel(new GridLayout(1,1));
       JPanel milieu = new JPanel(new GridLayout(1,2));
       JPanel bas = new JPanel(new GridLayout(1,1));

       PanneauImage panneauImage = new PanneauImage(tab[0]);
       panneauImage.setPreferredSize(new Dimension(300,200));
       haut.add(panneauImage);

       PanneauPerspective perspective1 = new PanneauPerspective(tab[1]);
       perspective1.setPreferredSize(new Dimension(400,300));
       milieu.add(perspective1);


       PanneauPerspective perspective2 = new PanneauPerspective(tab[2]);
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
