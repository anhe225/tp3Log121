package Vue;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;

public class MenuFenetre extends JMenuBar {
    private static final long serialVersionUID = 1L;
    private static final String MENU_FICHIER_TITRE = "Fichier";
    private static final String MENU_FICHIER_CHARGER = "Charger";
    private static final String MENU_FICHIER_QUITTER = "Quitter";
    private static final String MENU_SIMULATION_TITRE = "Simulation";
    private static final String MENU_SIMULATION_CHOISIR = "Choisir";
    private static final String MENU_AIDE_TITRE = "Aide";
    private static final String MENU_AIDE_PROPOS = "À propos de...";


    public MenuFenetre() {
        ajouterMenuFichier();
    }

    /**
     * Créer le menu de Fichier
     */
    private void ajouterMenuFichier() {
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
        JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);




        menuQuitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        menuFichier.add(menuCharger);
        menuFichier.add(menuQuitter);

        add(menuFichier);

    }
}
