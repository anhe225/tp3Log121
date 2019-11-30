package ButListener;

import Controller.CommandZoom;
import Model.ImageModel;

import java.awt.event.ActionEvent;

public class ButZoomMoins extends ButListener {
    public ButZoomMoins(String name, ImageModel img) {
        super(name, img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.manager.doCommand(new CommandZoom(this.getImg(),"moins"));

    }


}
