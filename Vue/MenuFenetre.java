package Vue;

import Controller.CommandPerspective;
import Controller.GestionnaireCommande;
import Model.ImageModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuFenetre extends JMenuBar {
    private static final long serialVersionUID = 1L;
    private static final String MENU_FICHIER_TITRE = "Fichier";
    private static final String MENU_FICHIER_CHARGER = "Charger";
    private static final String MENU_FICHIER_QUITTER = "Quitter";
    private static final String MENU_SIMULATION_TITRE = "Simulation";
    private static final String MENU_SIMULATION_CHOISIR = "Choisir";
    private static final String MENU_AIDE_TITRE = "Aide";
    private static final String MENU_AIDE_PROPOS = "À propos de...";

    private ImageModel img;


    public MenuFenetre(ImageModel img) {
        this.img= img;
        ajouterMenuFichier();
        ajouterMenuPerspective();
    }

    /**
     * Créer le menu de Fichier
     */
    private void ajouterMenuFichier() {
        JMenu menuFichier = new JMenu(MENU_FICHIER_TITRE);
        JMenuItem menuCharger = new JMenuItem(MENU_FICHIER_CHARGER);
        JMenuItem menuQuitter = new JMenuItem(MENU_FICHIER_QUITTER);

        menuCharger.addActionListener((ActionEvent e) -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setDialogTitle("Selectionnez une image");
            fileChooser.setAcceptAllFileFilterUsed(false);
            //le filtre pour selectionner que les jpg
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".jpg", "jpg");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {

                File fichierChoisi = fileChooser.getSelectedFile();
                BufferedImage mon_image;
                try {
                    mon_image = ImageIO.read(fichierChoisi);
                    this.img.setImg(mon_image);
                    System.out.println("Chargement Image OK  : "+fichierChoisi.getAbsolutePath());
                    this.img.update();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });


        menuQuitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        menuFichier.add(menuCharger);
        menuFichier.add(menuQuitter);

        add(menuFichier);

    }


    private void ajouterMenuPerspective() {
        JMenu menuAide = new JMenu("Perpective");
        for(int i=0; i < img.getTabPerpective().length; i++) {
            JMenuItem menuItem = new JMenuItem("Perspective " + (i+1));
            menuAide.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String strIndex = menuItem.getText().split(" ")[1];
                    int index = Integer.parseInt(strIndex) - 1;
                    GestionnaireCommande.getInstance().doCommand(new CommandPerspective(img, index));
                }
            });
        }

        add(menuAide);
    }
}
