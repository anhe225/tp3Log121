package Vue;

import Model.ImageModel;
import Model.ImgPerspective;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 -Automne 2019 Groupe 3";
    private static final Dimension DIMENSION = new Dimension(900, 700);
    private     BufferedImage bufferedImage;
    private ImageModel img;
    private ImgPerspective img_perspective;

    public FenetrePrincipale() {
        getImage();
        PanneauPrincipal panneauPrincipal = new PanneauPrincipal(img);

        MenuFenetre menuFenetre = new MenuFenetre(img);

        add(menuFenetre, BorderLayout.NORTH);
        add(panneauPrincipal);
        // Faire en sorte que le X de la fenêtre ferme la fenêtre
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(TITRE_FENETRE);
        setSize(DIMENSION);

        // Rendre la fenêtre visible
        setVisible(true);
        // Mettre la fenêtre au centre de l'écran
        setLocationRelativeTo(null);
        // Empêcher la redimension de la fenêtre
        setResizable(false);
    }

public void getImage(){
    try {
        this.bufferedImage = ImageIO.read(new java.io.File("images/images.jpeg"));
        this. img = new ImageModel(bufferedImage);

        this. img_perspective = new ImgPerspective(img);

    } catch (IOException e1) {
        e1.printStackTrace();
        System.out.println("pas d'image ou erreur lors du chatgement des images");
    }
}
    public void afficherMiseAjour(){
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("- ANHE - PASCAL")) {
            repaint();
            System.out.println(evt.getNewValue());
        }
    }
}