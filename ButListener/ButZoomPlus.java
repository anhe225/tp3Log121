package ButListener;

import Controller.CommandZoom;
import Model.ImageModel;

import java.awt.event.ActionEvent;

public class ButZoomPlus extends ButListener {
    public ButZoomPlus(String name, ImageModel img) {
        super(name, img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.manager.doCommand(new CommandZoom(this.getImg(),"plus"));
    }
}
