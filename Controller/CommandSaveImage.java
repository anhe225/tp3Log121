package Controller;

import Interfaces.Icommand;
import Model.Constantes;
import Model.ImageModel;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;

public class CommandSaveImage extends Command implements Icommand {
    public CommandSaveImage(ImageModel img) {
        super(img);
    }

    @Override
    public void execute() {
        try {
            LocalDateTime date = LocalDateTime.now();
            String repertoire = System.getProperty(Constantes.SYSTEM_REPERTOIRE);
            String fileName = repertoire + System.getProperty(Constantes.FILE_SEPARATOR) + date + Constantes.TYPE_FICHIER;
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            Memento memento= new Memento(img);
            o.writeObject(memento);

            o.close();
            f.close();

            JOptionPane.showMessageDialog(null, Constantes.MESSAGE_SAUVEGARDE +repertoire+Constantes.POINT);
        } catch (FileNotFoundException ex) {
            System.out.println(Constantes.FICHIER_INTROUVABLE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void undo() {

    }
}
