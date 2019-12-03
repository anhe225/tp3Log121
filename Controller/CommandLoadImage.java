package Controller;

import Interfaces.Icommand;
import Model.Constantes;
import Model.ImageModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class CommandLoadImage extends Command implements Icommand {
    public CommandLoadImage(ImageModel img) {
        super(img);
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle(Constantes.CHOISIR_SA_SAUVEGARDE);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filters = new FileNameExtensionFilter(Constantes.TYPE_FICHIER, Constantes.TXT);
        fileChooser.addChoosableFileFilter(filters);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            File selectedFile = fileChooser.getSelectedFile();

            try {
                FileInputStream f = new FileInputStream(selectedFile);
                ObjectInputStream o = new ObjectInputStream(f);

                Memento mememnto= (Memento) o.readObject();
                img.setImg(mememnto.getImg());
                img.modifyPerspectives(mememnto.getIndex());
                img.setTabPerpective(mememnto.getTabPerpective());
                img.update();
                GestionnaireCommande.getInstance().reboot();

                o.close();
                f.close();
            } catch (FileNotFoundException ex) {
                System.out.println(Constantes.FICHIER_INTROUVABLE);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void undo() {
       System.out.println(Constantes.UNDO_INTROUVABLE);
    }
}
