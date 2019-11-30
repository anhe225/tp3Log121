package ButListener;

import Controller.CommandSaveImage;
import Model.ImageModel;

import java.awt.event.ActionEvent;

public class ButOnSave extends ButListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CommandSaveImage commande = new CommandSaveImage(this.getImg());
        commande.execute();
    }

    public ButOnSave(String name, ImageModel img) {
        super(name, img);
    }
}
