package ButListener;

import Controller.CommandZoom;
import Model.Constantes;
import Model.ImageModel;

import java.awt.event.ActionEvent;

public class ButZoomPlus extends ButListener {
    public ButZoomPlus(String name, ImageModel img) {
        super(name, img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gestionnaireDeCommande.doCommand(new CommandZoom(this.getImg(), Constantes.PLUS));
    }
}
