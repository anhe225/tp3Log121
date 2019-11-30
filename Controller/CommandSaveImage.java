package Controller;

import Interfaces.Icommand;
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
            String repertoire = System.getProperty("user.dir");
            String fileName = repertoire + System.getProperty("file.separator") + date + ".txt";
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            Memento memento= new Memento(img);
            o.writeObject(memento);

            o.close();
            f.close();

            JOptionPane.showMessageDialog(null, "Le travail effectué a été sauvegardé avec succès dans le dossier : "+repertoire+".");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void undo() {

    }
}
