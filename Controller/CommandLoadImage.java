package Controller;

import Interfaces.Icommand;
import Model.ImageModel;
import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

import static jdk.jshell.spi.ExecutionControl.*;

public class CommandLoadImage extends Command implements Icommand {
    public CommandLoadImage(ImageModel img) {
        super(img);
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choisir une sauvegarde");
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtre = new FileNameExtensionFilter(".txt", "txt");
        fileChooser.addChoosableFileFilter(filtre);

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
                GestionnaireCommande.getInstance().reset();

                o.close();
                f.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Fichier Introuvable");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void undo() {
       System.out.println("pas de Undo pour le moment");
    }
}
