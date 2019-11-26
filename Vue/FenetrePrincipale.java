package Vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame implements PropertyChangeListener {

    private static final long serialVersionUID = 1L;
    private static final String TITRE_FENETRE = "Laboratoire 3 : LOG121 -Automne 2019 Groupe 3";
    private static final Dimension DIMENSION = new Dimension(900, 700);

    public FenetrePrincipale() {
        PanneauPrincipal panneauPrincipal = new PanneauPrincipal();

        MenuFenetre menuFenetre = new MenuFenetre();
        add(panneauPrincipal);
        add(menuFenetre, BorderLayout.NORTH);
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


    public void afficherMiseAjour(){
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("USINE PRODUCTION AVION - ANHE - PASCAL")) {
            repaint();
            System.out.println(evt.getNewValue());
        }
    }
}