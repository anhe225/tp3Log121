package ButListener;

import Controller.GestionnaireCommande;
import Model.ImageModel;

import javax.swing.*;
/**
 * @author  anhe pascal
 * source https://docs.oracle.com/javase/7/docs/api/javax/swing/AbstractAction.html
 */
public abstract  class ButListener extends AbstractAction {

    private ImageModel img;
    protected final static GestionnaireCommande manager = GestionnaireCommande.getInstance();

    public ButListener(String name, ImageModel img) {
        super(name);
        this.img = img;
    }

    public ImageModel getImg() {
        return img;
    }

    public void setImg(ImageModel img) {
        this.img = img;
    }

    public static GestionnaireCommande getManager() {
        return manager;
    }
}
