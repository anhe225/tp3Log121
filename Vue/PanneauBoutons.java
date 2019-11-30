package Vue;

import Model.ImageModel;

import javax.swing.*;
import java.awt.*;

public class PanneauBoutons extends JPanel {

    private JButton bHaut;
    private JButton bBas;
    private JButton bGauche;
    private JButton bDroite;
    private JButton bZoomPlus;
    private JButton bZoomMoins;
    private ImageModel img;
    private JPanel bas;


    public PanneauBoutons() {
        super();
        this.bHaut = bHaut;
        this.bas = new JPanel(new GridLayout(1,6));
        createDirection();
    }

    public void createDirection(){
       /* bHaut = new JButton(new ActionTranslate(ImageModel,"Up",new Point(0,-10)));
        bBas = new JButton(new ActionTranslate(ImageModel,"Down", new Point(0,10)));
        bGauche = new JButton(new ActionTranslate(ImageModel,"Left", new Point(-10,0)));
        bDroite = new JButton(new ActionTranslate(ImageModel,"Right",new Point(10,0))); */

        bHaut = new JButton("haut");
        bBas = new JButton("bas");
        bGauche = new JButton("gauche");
        bDroite = new JButton("bas");
        bZoomPlus = new JButton("Zoom Plus");
        bZoomMoins = new JButton("Zoom Moins");



        bas.add(bHaut);
        bas.add(bBas);
        bas.add(bGauche);
        bas.add(bDroite);
        bas.add(bZoomPlus);
        bas.add(bZoomMoins);

        this.add(bas);



    }
}
