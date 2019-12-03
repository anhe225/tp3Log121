package Vue;

import ButListener.ButTranslate;
import ButListener.ButZoomMoins;
import ButListener.ButZoomPlus;
import Interfaces.Observer;
import Model.Constantes;
import Model.ImageModel;

import javax.swing.*;
import java.awt.*;

public class PanneauBoutons extends JPanel  {

    private JButton bHaut;
    private JButton bBas;
    private JButton bGauche;
    private JButton bDroite;
    private JButton bZoomPlus;
    private JButton bZoomMoins;
    private ImageModel img;
    private JPanel bas;


    public PanneauBoutons(ImageModel img) {
        super();

        this.bas = new JPanel(new GridLayout(1,6));
        this.img=img;
        createDirection();

    }

    public void createDirection(){

        Point pHaut = new Point(0,-15);
        Point pBas = new Point(0,15);
        Point pGauche = new Point(-15,0);
        Point pDroite = new Point(15,0);


        bHaut = new JButton(new ButTranslate(Constantes.HAUT,img,pHaut));
        bBas = new JButton(new ButTranslate(Constantes.BAS,img,pBas));
        bGauche = new JButton(new ButTranslate(Constantes.GAUCHE,img,pGauche));
        bDroite = new JButton(new ButTranslate(Constantes.DROITE,img,pDroite));


        bZoomPlus = new JButton(new ButZoomPlus(Constantes.ZOOM_PLUS,img));
        bZoomMoins = new JButton(new ButZoomMoins(Constantes.ZOOM_MOINS,img));



        bas.add(bHaut);
        bas.add(bBas);
        bas.add(bGauche);
        bas.add(bDroite);
        bas.add(bZoomPlus);
        bas.add(bZoomMoins);

        this.add(bas);



    }


}
